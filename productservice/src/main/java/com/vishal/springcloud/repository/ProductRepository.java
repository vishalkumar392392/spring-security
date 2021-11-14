package com.vishal.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishal.springcloud.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
