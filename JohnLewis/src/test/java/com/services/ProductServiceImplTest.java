package com.services;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.model.Product;
import com.model.Products;

public class ProductServiceImplTest {
	ProductServiceImpl productServiceImpl;
	
	RestTemplate restTemplate;
   

	@Before
	public void setUp() throws Exception {
		
		 restTemplate= new RestTemplate();
		productServiceImpl = new ProductServiceImpl();

	}

	@Test
	public void when_invokeapi_thenStatussuccess() throws Exception {

	
		String serviceUpdatedURL = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";

		ResponseEntity<String> responseEntity = restTemplate.exchange(serviceUpdatedURL, HttpMethod.GET, null,String.class);

		assertTrue(responseEntity.getBody().contains("products"));
		assertTrue(responseEntity.getBody().length() > 1);
	}

}
