package com.binu.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.binu.ecommerce.entity.Product;
import com.binu.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		// disable methods for Product which Spring Rest exposes by default: PUT, POST and DELETE ---> effectively making PRODUCT read only
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metData, httpMethods) -> httpMethods.disable(theUnsupportedActions))
			.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		// disable methods for ProductCategory which Spring Rest exposes by default: PUT, POST and DELETE ---> effectively making PRODUCT read only
		config.getExposureConfiguration()
			.forDomainType(ProductCategory.class)
			.withItemExposure((metData, httpMethods) -> httpMethods.disable(theUnsupportedActions))
			.withCollectionExposure((metdata,httpMethods) -> httpMethods.disable(theUnsupportedActions));
		
		
	}
	
	
	
}
