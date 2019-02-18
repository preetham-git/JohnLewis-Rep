package com.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.model.Product;
import com.model.Products;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	RestTemplate restTemplate;
	@Value("${operations.restURL}")
	String serviceURL;
	@Value("${operations.restKey}")
	String restKey;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.services.ProductService#getProductsByCategory(java.lang.Integer)
	 */
	@Override
	public List<Product> getProductsByCategory(Integer categoryID) {
		ResponseEntity<Products> responseEntity = null;
		try {


			String serviceUpdatedURL = serviceURL+categoryID+restKey;
			responseEntity = restTemplate.exchange(serviceUpdatedURL, HttpMethod.GET, null, Products.class);
			return responseEntity.getBody().getProducts();
		} catch (Exception ex) {
			return null;
		}

	}

}