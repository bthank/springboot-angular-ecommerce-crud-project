package com.binu.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binu.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	
	
	
}
