package com.example.lineitem.repository;

import com.example.lineitem.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query(value="{'id':{$ne : null}}", fields = "{'id':1, 'name':1}")
    List<Product> getProductNameAndId();

    @Query(value = "{'name':{$regex : ?0, $options: 'i'}}", fields = "{'id':1}")
    Optional<Product> isNameExist(String name);
}
