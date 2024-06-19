package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.AppUser;
import org.example.hospital_management.entity.CustomUserDetail;
import org.example.hospital_management.entity.request.AppUserRegisterRequest;
import org.example.hospital_management.entity.response.UserResponse;
import org.example.hospital_management.repository.AppUserRepository;
import org.example.hospital_management.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper mapper;

    public AppUserServiceImpl(AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper mapper) {
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepository.getUserByEmail(username);
        return new CustomUserDetail(user);
    }

    @Override
    public UserResponse registerNewUser(AppUserRegisterRequest userRegisterRequest) {
        String password = bCryptPasswordEncoder.encode(userRegisterRequest.getPassword());
        userRegisterRequest.setPassword(password);
        userRegisterRequest.setUserType(userRegisterRequest.getUserType().toUpperCase());
        appUserRepository.registerNewUser(userRegisterRequest);
        AppUser user = appUserRepository.getUserByEmail(userRegisterRequest.getEmail());
        return mapper.map(user, UserResponse.class);
    }
}
