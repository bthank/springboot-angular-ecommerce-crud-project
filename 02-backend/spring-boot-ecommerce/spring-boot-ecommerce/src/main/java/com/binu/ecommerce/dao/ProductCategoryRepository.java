package com.binu.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.binu.ecommerce.entity.ProductCategory;

// name of Json entry is productCategory; reference for Rest path is "/product-category"
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

	
	
}
