package com.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.converter.ProductToResponseModelConverter;
import com.model.Product;
import com.model.ResponseModel;

public class ResponseModelServiceImplTest {
	
	@Autowired
	ProductService productService;
	 private static int CATEGORY_ID=600001506;
	 ResponseModelServiceImp responseModelServiceImp;
	
	 @Before
	    public void setUp() throws Exception {
		  responseModelServiceImp=new ResponseModelServiceImp();
	       Mockito.when(productService.getProductsByCategory(CATEGORY_ID)).thenReturn(new ArrayList<Product>());
	    }

	    @Test
	    public void get_productModels() {
	        List<ResponseModel> responseModelServiceList = responseModelServiceImp.getProductsByCategoryAndPriceLabel(CATEGORY_ID, Optional.empty());
	        assertTrue(responseModelServiceList.size()==0);
	    }

}
