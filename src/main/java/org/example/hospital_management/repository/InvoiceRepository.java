package org.example.hospital_management.repository;

import org.apache.ibatis.annotations.*;
import org.example.hospital_management.entity.Invoice;
import org.example.hospital_management.entity.request.InvoiceRequest;

import java.util.List;

@Mapper
public interface InvoiceRepository {
    @Insert("""
        INSERT INTO tbInvoice (invoiceDate, totalAmount, paidAmount, patientID, employeeID)
        VALUES (#{invoiceDate}, #{totalAmount}, #{paidAmount}, #{patientId}, #{employeeId})
    """)
    void addNewInvoice(InvoiceRequest invoice);
    @Select("""
    SELECT * FROM tbInvoice WHERE invoiceId = #{invoiceId}
    """)
    @Results(id = "invoiceMapping", value = {
            @Result(property = "invoiceId", column = "invoiceId", id = true),
            @Result(property = "invoiceDate", column = "invoiceDate"),
            @Result(property = "totalAmount", column = "totalAmount"),
            @Result(property = "paidAmount", column = "paidAmount"),
            @Result(property = "patient", column = "patientID",
                    one = @One(select = "org.example.hospital_management.repository.PatientRepository.getPatientById")),
            @Result(property = "employee", column = "employeeID",
                    one = @One(select = "org.example.hospital_management.repository.EmployeeRepository.getEmployeeById"))
    })
    Invoice getInvoiceById(Integer invoiceId);
    @Select("""
    SELECT * FROM tbInvoice
    """)
    List<Invoice> getAllInvoice();
    @Delete("""
    DELETE FROM tbInvoice WHERE invoiceId = #{invoiceId}
    """)
    void deleteInvoiceById(Integer invoiceId);
    @Update("""
    UPDATE tbInvoice SET invoiceDate = #{invoiceDate}, totalAmount = #{totalAmount}, paidAmount = #{paidAmount},
    patientID = #{patient.patientID}, employeeID = #{employee.employeeID}
    WHERE invoiceId = #{invoiceId}
    """)
    void updateInvoiceById(InvoiceRequest invoice, Integer invoiceId);
}
