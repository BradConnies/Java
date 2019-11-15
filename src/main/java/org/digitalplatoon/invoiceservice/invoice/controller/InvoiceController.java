package org.digitalplatoon.invoiceservice.invoice.controller;


import org.digitalplatoon.invoiceservice.invoice.exception.ResourceNotFoundException;
import org.digitalplatoon.invoiceservice.invoice.model.Invoice;
import org.digitalplatoon.invoiceservice.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices() {return invoiceRepository.findAll();}

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable(value = "id") Long invoiceId)
            throws ResourceNotFoundException {
        Invoice invoice= invoiceRepository.findById(invoiceId)
            .orElseThrow(() -> new ResourceNotFoundException("Invoice not found for this id :: " + invoiceId));
        return ResponseEntity.ok().body(invoice);
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {return invoiceRepository.save(invoice);
    }
}
