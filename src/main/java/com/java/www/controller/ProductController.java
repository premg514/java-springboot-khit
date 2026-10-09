package com.java.www.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.www.model.Product;
import com.java.www.repository.ProductRepository;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;


    // 1. ADD PRODUCT
    // POST: http://localhost:5050/product
    // RECEIVE: Product
    // RESPONSE: String

    @PostMapping("/product")
    public String createProduct(@RequestBody Product product) {

        repository.save(product);

        return "product data is stored in database";
    }


    // 2. GET ALL PRODUCTS
    // GET: http://localhost:5050/products
    // RECEIVE: Nothing
    // RESPONSE: List<Product>

    @GetMapping("/products")
    public List<Product> getProds() {

        return repository.findAll();
    }

    
    
    
    

    // 3. GET SPECIFIC PRODUCT
    // GET: http://localhost:5050/product/1
    // RECEIVE: id
    // RESPONSE: Product

    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {

        return repository.findById(id);
    }

    
    
    
    
    

    
    // 4. UPDATE PRODUCT
    // PUT: http://localhost:5050/product/1
    // RECEIVE: id + Product
    // RESPONSE: String

    @PutMapping("/product/{id}")
    public String updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        product.setId(id);

        repository.save(product);

        return "product data is updated";
    }

    
    
    
    
    
    

    // 5. DELETE PRODUCT
    // DELETE: http://localhost:5050/product/1
    // RECEIVE: id
    // RESPONSE: String

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {

        repository.deleteById(id);

        return "product is deleted";
    }
}