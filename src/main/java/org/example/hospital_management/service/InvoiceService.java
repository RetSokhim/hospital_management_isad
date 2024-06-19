package org.example.hospital_management.service;

import org.example.hospital_management.entity.Invoice;
import org.example.hospital_management.entity.request.InvoiceRequest;

import java.util.List;

public interface InvoiceService {
    void addNewInvoice(InvoiceRequest invoice);
    Invoice getInvoiceById(Integer invoiceId);
    List<Invoice> getAllInvoices();
    void deleteInvoiceById(Integer invoiceId);
    Invoice updateInvoiceById(Integer invoiceId, InvoiceRequest invoice);
}
