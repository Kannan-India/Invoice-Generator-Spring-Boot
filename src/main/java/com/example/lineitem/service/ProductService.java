package com.example.lineitem.service;

import com.example.lineitem.model.Product;
import com.example.lineitem.repository.ProductRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String addProduct(Product product){
        Optional<Product> optional = productRepository.isNameExist(product.getName());
        if(optional.isEmpty()){
            productRepository.save(product);
            return "Uploaded Successfully";
        }else{
            return "Product Name Already Exists. Please try again with a different name";
        }
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }

    public List<Product> getProductNameAndId(){
        return productRepository.getProductNameAndId();
    }

    public Product updateProduct(Product product){
        return productRepository.save(product);
    }

    public Object deleteProduct(String id){
        productRepository.deleteById(id);
        return Collections.emptyList();
    }
}
