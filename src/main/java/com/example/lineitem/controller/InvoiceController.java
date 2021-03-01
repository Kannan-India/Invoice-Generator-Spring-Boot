package com.example.lineitem.controller;

import com.example.lineitem.model.Invoice;
import com.example.lineitem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/invoice/")
@CrossOrigin(origins = "*")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping
    public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoiceService.addInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> getAllInvoice(){
        return invoiceService.getAllInvoice();
    }

    @GetMapping(value = "basic/")
    public List<Invoice> getInvoiceListBasic(){
        return invoiceService.getInvoiceListBasic();
    }

    @GetMapping(value = "{id}")
    public Invoice getInvoiceById(@PathVariable("id") String id){
        return invoiceService.getInvoiceById(id);
    }

    @PutMapping
    public Invoice updateInvoice(@RequestBody Invoice invoice){
        return invoiceService.updateInvoice(invoice);
    }

    @DeleteMapping(value = "{id}")
    public Object deleteInvoiceById(@PathVariable("id") String id){
        return invoiceService.deleteInvoice(id);
    }
}
