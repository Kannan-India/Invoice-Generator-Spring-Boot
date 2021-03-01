package com.example.lineitem.controller;

import com.example.lineitem.model.Customer;
import com.example.lineitem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer/")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "{id}")
    public Customer getCustomerById(@PathVariable("id") String id){
        return customerService.getCustomerById(id);
    }

    @GetMapping(value = "customerbasic/")
    public List<Customer> getCustomerNameAndId(){
        return customerService.getCustomerNameAndId();
    }

    @GetMapping(value = "viewall/")
    public List<Customer> getCustomerListForViewAll(){
        return customerService.getCustomerListForViewAll();
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @PutMapping(value = "phone/{phone}")
    public Customer editCustomerByPhone(@PathVariable("phone") String phone, @RequestBody Customer customer){
        return customerService.editCustomerByPhone(phone, customer);
    }

    @DeleteMapping("{id}")
    public Object deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }
}
