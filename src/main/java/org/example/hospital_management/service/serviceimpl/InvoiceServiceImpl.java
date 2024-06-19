package org.example.hospital_management.service.serviceimpl;

import org.example.hospital_management.entity.Invoice;
import org.example.hospital_management.entity.request.InvoiceRequest;
import org.example.hospital_management.repository.InvoiceRepository;
import org.example.hospital_management.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void addNewInvoice(InvoiceRequest invoice) {
        invoiceRepository.addNewInvoice(invoice);
    }

    @Override
    public Invoice getInvoiceById(Integer invoiceId) {
        return invoiceRepository.getInvoiceById(invoiceId);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.getAllInvoice();
    }

    @Override
    public void deleteInvoiceById(Integer invoiceId) {
        invoiceRepository.deleteInvoiceById(invoiceId);
    }

    @Override
    public Invoice updateInvoiceById(Integer invoiceId, InvoiceRequest invoice) {
        invoiceRepository.updateInvoiceById(invoice,invoiceId);
        return getInvoiceById(invoiceId);
    }
}
