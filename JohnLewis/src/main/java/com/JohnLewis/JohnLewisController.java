package com.JohnLewis;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.constants.PriceLabelTypeEnum;
import com.exceptions.ProductNotFoundException;
import com.model.ResponseModel;
import com.services.ResponseModelService;

/*
 * @Author: Preetham
 */
@Configuration
@ComponentScan(basePackages = { "com.config", "com.services", "com.converter","com.exceptions" })
@RestController
public class JohnLewisController {

	@Autowired
	private ResponseModelService responseModelService;

	@GetMapping(value = "/ProductsByCategory/{categoryId}")
	public List<ResponseModel> getProductsDataByCategory(@PathVariable(required = true) Integer categoryId,
			@RequestParam(required = false) PriceLabelTypeEnum priceType)
			throws Exception
	{
		Optional<PriceLabelTypeEnum> labelPriceType = Optional.ofNullable(priceType);
		List<ResponseModel> response = responseModelService.getProductsByCategoryAndPriceLabel(categoryId,
				labelPriceType);

		if (response == null) {
			throw new ProductNotFoundException("Porduct not found");
		}
		return response;

	}

}
