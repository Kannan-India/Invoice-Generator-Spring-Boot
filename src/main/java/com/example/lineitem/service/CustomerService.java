package com.example.lineitem.service;

import com.example.lineitem.model.Customer;
import com.example.lineitem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    //TODO: Basic CRUD Functions
    //Add new customer
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //get all customers list
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    //get single customer details using id
    public Customer getCustomerById(String id){
        Optional<Customer> optional = customerRepository.findById(id);
        return optional.orElse(null);
    }

    //update customer details using the id (here by directly passing the object conatining the id)
    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    //deleting customer using id
    public Object deleteCustomer(String id){
        customerRepository.deleteById(id);
        return Collections.emptyList();
    }

    //TODO: User defined functions using query and mongo templates
    //get all customers list containing only their name and id fields
    public List<Customer> getCustomerNameAndId(){
        return customerRepository.getCustomerNameAndId();
    }

    //get partial details of all the customers
    public List<Customer> getCustomerListForViewAll(){
        return customerRepository.getCustomerListForViewAll();
    }

    //not working for now
    //editing a customer's detail using their phone number
    public Customer editCustomerByPhone(String phone, Customer customer){
        Query query = new Query().addCriteria(
                Criteria.where("phone").is(phone)
        );
//        Update updateDefinition;
//        updateDefinition.set("customer.$.collection.$.value", );
//        mongoTemplate.updateFirst(query, ,Customer.class);

//        return mongoTemplate.findAndModify(query, updateDefinition,Customer.class,  );
        return customerRepository.editCustomerByPhone(phone, customer);
    }

}
