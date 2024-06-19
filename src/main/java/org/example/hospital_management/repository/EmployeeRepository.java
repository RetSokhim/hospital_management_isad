package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Employee;
import org.example.hospital_management.entity.request.EmployeeRequest;

import java.util.List;

@Mapper
public interface EmployeeRepository {
    @Insert("""
        INSERT INTO tbEmployee (
            nameEN, nameKH, sex, birthDate, staffPosition, contact, address, salary, hireDate
        ) VALUES (
            #{employeeRequest.nameEN}, #{employeeRequest.nameKH}, #{employeeRequest.sex}, #{employeeRequest.birthDate},
            #{employeeRequest.staffPosition}, #{employeeRequest.contact}, #{employeeRequest.address}, #{employeeRequest.salary},
            #{employeeRequest.hireDate}
        )
    """)
    void addNewEmployee(@Param("employeeRequest") Employee employeeRequest);

    @Select("SELECT * FROM tbEmployee")
    @Results(id = "employeeMapping", value = {
            @Result(property = "employeeId", column = "EmployeeID"),
            @Result(property = "nameEN", column = "NameEN"),
            @Result(property = "nameKH", column = "NameKH"),
            @Result(property = "sex", column = "Sex"),
            @Result(property = "birthDate", column = "BirthDate"),
            @Result(property = "staffPosition", column = "StaffPosition"),
            @Result(property = "contact", column = "Contact"),
            @Result(property = "address", column = "Address"),
            @Result(property = "salary", column = "Salary"),
            @Result(property = "hireDate", column = "HireDate"),
            @Result(property = "photo", column = "Photo"),
            @Result(property = "stoppedWork", column = "StoppedWork"),
            @Result(property = "user", column = "UserID",
                    one = @One(select = "org.example.hospital_management.repository.AppUserRepository.getUserByEmployeeId")
            )
    })
    List<Employee> getAllEmployee();

    @Delete("""
    DELETE FROM tbEmployee
    WHERE EmployeeID = #{employeeId}
    """)
    void removeEmployee(Integer employeeId);

    @Select("""
    SELECT * FROM tbEmployee
    WHERE EmployeeID = #{employeeId}
    """)
    @ResultMap("employeeMapping")
    Employee getEmployeeById(Integer employeeId);

    @Update("""
    UPDATE tbEmployee
    SET
        nameEN = #{employeeRequest.nameEN},
        nameKH = #{employeeRequest.nameKH},
        sex = #{employeeRequest.sex},
        birthDate = #{employeeRequest.birthDate},
        staffPosition = #{employeeRequest.staffPosition},
        contact = #{employeeRequest.contact},
        address = #{employeeRequest.address},
        salary = #{employeeRequest.salary},
        hireDate = #{employeeRequest.hireDate}
    WHERE EmployeeID = #{employeeId}
    """)
    void updateEmployeeByID(@Param("employeeRequest") Employee employeeRequest, @Param("employeeId") Integer employeeId);
}
