package com.java.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.www.model.Product;

@Repository	
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
