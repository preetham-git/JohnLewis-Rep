package com.services;

import java.util.List;
import java.util.Optional;

import com.constants.PriceLabelTypeEnum;
import com.model.ResponseModel;

public interface ResponseModelService {
	
	 List<ResponseModel> getProductsByCategoryAndPriceLabel(Integer categoryID, Optional<PriceLabelTypeEnum> priceLabelType) ;
	
}
