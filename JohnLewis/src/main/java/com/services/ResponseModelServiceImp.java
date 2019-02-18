package com.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.constants.PriceLabelTypeEnum;
import com.converter.ProductToResponseModelConverter;
import com.model.Product;
import com.model.ResponseModel;

@Service
public class ResponseModelServiceImp implements ResponseModelService {

	@Autowired
	ProductService productService;

	@Autowired
	ProductToResponseModelConverter productToResponseModelConverter;

	@Override
	public List<ResponseModel> getProductsByCategoryAndPriceLabel(Integer categoryID,
			Optional<PriceLabelTypeEnum> priceLabelType) {
		List<Product> products = productService.getProductsByCategory(categoryID);
		if(products!=null)
		return products.stream().map(product -> {
			return productToResponseModelConverter.populate(product, priceLabelType);
		}).collect(Collectors.toList());
		else 
		  return null;	
	}



}
