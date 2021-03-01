package com.example.lineitem.repository;

import com.example.lineitem.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {

    @Query(value = "{'id':{$ne: null}}", fields = "{'id': 1, 'date': 1}")
    List<Invoice> getInvoiceListBasic();
}
