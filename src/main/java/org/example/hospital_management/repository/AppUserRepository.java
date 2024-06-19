package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.AppUser;
import org.example.hospital_management.entity.request.AppUserRegisterRequest;
import org.example.hospital_management.entity.response.UserResponse;

@Mapper
public interface AppUserRepository {

    @Select("""
    SELECT * FROM tbUser
    WHERE email = #{username}
    """)
    @Results(id = "userMapping", value = {
            @Result(property = "userId", column = "UserID"),
            @Result(property = "username", column = "Username"),
            @Result(property = "email", column = "Email"),
            @Result(property = "password", column = "Password"),
            @Result(property = "userType", column = "UserType"),
            @Result(property = "status", column = "Status"),
    })
    AppUser getUserByEmail(String username);

    @Insert("""
    INSERT INTO tbUser(username, email, password, usertype)
    VALUES (#{user.username}, #{user.email}, #{user.password}, #{user.userType})
    """)
    @ResultMap("userMapping")
    void registerNewUser(@Param("user") AppUserRegisterRequest userRegisterRequest);

    @Select("""
    SELECT * FROM tbUser
    WHERE EmployeeID = #{employeeId}
    """)
    @Results(id = "userResponseMapping", value = {
            @Result(property = "userId", column = "UserID"),
            @Result(property = "username", column = "Username"),
            @Result(property = "email", column = "Email"),
            @Result(property = "userType", column = "UserType"),
            @Result(property = "status", column = "Status"),
    })
    UserResponse getUserByEmployeeId(Integer employeeId);
}
