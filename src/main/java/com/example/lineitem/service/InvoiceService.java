package com.example.lineitem.service;

import com.example.lineitem.model.Invoice;
import com.example.lineitem.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice addInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoiceListBasic(){
        return invoiceRepository.getInvoiceListBasic();
    }

    public Invoice getInvoiceById(String id){
        Optional<Invoice> optional = invoiceRepository.findById(id);
        return optional.orElse(null);
    }

    public Invoice updateInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }

    public Object deleteInvoice(String id){
        invoiceRepository.deleteById(id);
        return Collections.emptyList();
    }
}
