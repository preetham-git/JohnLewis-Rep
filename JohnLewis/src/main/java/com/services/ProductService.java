package com.services;

import java.util.List;
import com.model.Product;

public interface ProductService {
	
	
	 List<Product> getProductsByCategory(Integer categoryID);

}
