package com.example.lineitem.repository;

import com.example.lineitem.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query(value="{'id' : {$ne : null}}", fields = "{'id':1, 'name':1}")
    List<Customer> getCustomerNameAndId();

    @Query(value = "{'id': {$ne: null}}", fields = "{'id':1, 'name':1, 'email':1, 'company':1}")
    List<Customer> getCustomerListForViewAll();

    @Query(value = "{'phone': ?0}")
    Customer editCustomerByPhone(String phone, Customer customer);


}
