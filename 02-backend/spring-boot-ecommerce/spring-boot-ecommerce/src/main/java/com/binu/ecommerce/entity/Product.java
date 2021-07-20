package com.binu.ecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name="product")
@Data  // lombok annotation to reduce boilerplate code such as getters/setters/constructors/etc.
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)  // the join field category_id is defined in this table for the relationship
	private ProductCategory category;
	
	
	@Column(name="sku")	
	private String sku;
	@Column(name="name")	
	private String name;
	@Column(name="description")	
	private String description;
	@Column(name="unit_price")	
	private BigDecimal unitPrice;
	@Column(name="image_url")	
	private String imageUrl;
	@Column(name="active")	
	private boolean active;
	@Column(name="units_in_stock")	
	private int unitsInStock;
	@Column(name="date_created")	
	@CreationTimestamp  // Hibernate will automatically manage this timestamp field in the background
	private Date dateCreated;
	@Column(name="last_updated")	
	@UpdateTimestamp   // Hibernate will automatically manage this timestamp field in the background
	private Date lastUpdated;

}
