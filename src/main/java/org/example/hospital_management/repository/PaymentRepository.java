package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Payment;
import org.example.hospital_management.entity.request.PaymentRequest;

import java.util.List;

@Mapper
public interface PaymentRepository {
    @Insert("""
        INSERT INTO tbPayment (payDate, paidAmount, patientID, employeeID)
        VALUES (#{payDate}, #{paidAmount}, #{patientId}, #{employeeId})
    """)
    void addNewPayment(PaymentRequest paymentRequest);

    @Select("""
        SELECT * FROM tbPayment WHERE paymentId = #{paymentId}
    """)
    @Results(id = "paymentMapping", value = {
            @Result(property = "paymentId", column = "paymentId", id = true),
            @Result(property = "payDate", column = "payDate"),
            @Result(property = "paidAmount", column = "paidAmount"),
            @Result(property = "patient", column = "patientID",
                    one = @One(select = "org.example.hospital_management.repository.PatientRepository.getPatientById")),
            @Result(property = "employee", column = "employeeID",
                    one = @One(select = "org.example.hospital_management.repository.EmployeeRepository.getEmployeeById"))
    })
    Payment getPaymentById(Integer paymentId);

    @Select("""
        SELECT * FROM tbPayment
    """)
    @ResultMap("paymentMapping")
    List<Payment> getAllPayments();

    @Delete("""
        DELETE FROM tbPayment WHERE paymentId = #{paymentId}
    """)
    void deletePaymentById(Integer paymentId);

    @Update("""
        UPDATE tbPayment SET payDate = #{payDate}, paidAmount = #{paidAmount},
        patientID = #{patientId}, employeeID = #{employeeId}
        WHERE paymentId = #{paymentId}
    """)
    void updatePaymentById(@Param("paymentRequest") PaymentRequest paymentRequest, @Param("paymentId") Integer paymentId);
}
