package com.example.lineitem.controller;

import com.example.lineitem.model.Product;
import com.example.lineitem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/product/")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public String addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "{id}")
    public Product getProductById(@PathVariable("id") String id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "productbasic/")
    public List<Product> getProductNameAndId(){
        return productService.getProductNameAndId();
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public Object deleteProduct(@PathVariable("id") String id){
        return productService.deleteProduct(id);
    }

}
