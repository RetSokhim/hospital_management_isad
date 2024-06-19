package org.example.hospital_management.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.hospital_management.entity.Invoice;
import org.example.hospital_management.entity.request.InvoiceRequest;
import org.example.hospital_management.entity.response.ApiResponse;
import org.example.hospital_management.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice")
@SecurityRequirement(name = "basicAuth")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/add-invoice")
    @Operation(summary = "Add new invoice")
    public ResponseEntity<?> addInvoice(@RequestBody InvoiceRequest invoice) {
        invoiceService.addNewInvoice(invoice);
        return new ResponseEntity<>(new ApiResponse<>("Invoice added successfully",
                HttpStatus.CREATED,
                null,
                201,
                LocalDateTime.now()),
                HttpStatus.CREATED);
    }

    @GetMapping("/get-invoice-by-id/{invoiceId}")
    @Operation(summary = "Get invoice by ID")
    public ResponseEntity<?> getInvoiceById(@PathVariable Integer invoiceId) {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);
        return new ResponseEntity<>(new ApiResponse<>("Get invoice by ID successfully",
                HttpStatus.OK,
                invoice,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @GetMapping("/get-all-invoices")
    @Operation(summary = "Get all invoices")
    public ResponseEntity<?> getAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        return new ResponseEntity<>(new ApiResponse<>("Get all invoices successfully",
                HttpStatus.OK,
                invoices,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete-invoice-by-id/{invoiceId}")
    @Operation(summary = "Delete invoice by ID")
    public ResponseEntity<?> deleteInvoiceById(@PathVariable Integer invoiceId) {
        invoiceService.deleteInvoiceById(invoiceId);
        return new ResponseEntity<>(new ApiResponse<>("Delete invoice by ID successfully",
                HttpStatus.OK,
                null,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }

    @PutMapping("/update-invoice-by-id/{invoiceId}")
    @Operation(summary = "Update invoice by ID")
    public ResponseEntity<?> updateInvoiceById(@RequestBody InvoiceRequest invoice, @PathVariable Integer invoiceId) {
        Invoice updatedInvoice = invoiceService.updateInvoiceById(invoiceId, invoice);
        return new ResponseEntity<>(new ApiResponse<>("Update invoice by ID successfully",
                HttpStatus.OK,
                updatedInvoice,
                200,
                LocalDateTime.now()),
                HttpStatus.OK);
    }
}
