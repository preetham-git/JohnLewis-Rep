package com.converter;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.constants.PriceLabelTypeEnum;
import com.model.Price;
import com.model.Product;
import com.model.ResponseModel;

@Service

public class ProductToResponseModelConverter implements Converter<Product, ResponseModel> {
	
	@Autowired 
	ColorSwatchesToColorSwatchModelConverter colorSwatchModelConverter;

	
	@Override
	public ResponseModel convert(Product product) {

		if (product != null) {			
			ResponseModel target = new ResponseModel();
			target.setId(product.getProductId());
			target.setTitle(product.getTitle());			
			target.setNowPrice(populateNowPrice(product.getPrice()));
			//target.setColorSwatches(colorSwatchModelConverter.populatecolorSwatches(product));
			if(colorSwatchModelConverter!=null)
			target.setColorSwatches(product.getColorSwatches().stream().map(x -> {
				return colorSwatchModelConverter.convert(x);
			}).collect(Collectors.toList()));

			return target;
		}
		return null;
	}

	public ResponseModel populate(Product product, Optional<PriceLabelTypeEnum> priceLabelType) {		
		ResponseModel responseModel=convert(product);
		if(responseModel!=null)
		{
			String priceLabel = populatePriceLabel(priceLabelType, product.getPrice());
			responseModel.setPriceLabel(priceLabel);
		}			
		return responseModel;
	}
	public String populateNowPrice(Price price) {
		Float nowPrice;

		try {
			nowPrice = Float.parseFloat((String) price.getNow());
		} catch (Exception e) {
			nowPrice = 0.00f;
		}
		if (nowPrice < 10)
			return price.getCurrency().getValue() + Math.round(nowPrice);
		else
			return price.getCurrency().getValue() + nowPrice;
	}
	
	public String populatePriceLabel(Optional<PriceLabelTypeEnum> labelType, Price price) {

		String response = "";
		PriceLabelTypeEnum priceLabel = labelType.map(label -> {
			return label;
		}).orElse(PriceLabelTypeEnum.ShowWasNow);

		if (PriceLabelTypeEnum.ShowWasNow.equals(priceLabel)) {
			response = price.getWas().map(x -> {
				return "Was " + price.getCurrency().getValue() + x + ", now " + populateNowPrice(price);
			}).orElse("Was " + populateNowPrice(price) + ", now " + populateNowPrice(price));

		} else if (PriceLabelTypeEnum.ShowWasThenNow.equals(priceLabel)) {
			String was = price.getWas().map(x -> {
				return price.getCurrency().getValue() + x;
			}).orElse(price.getCurrency().getValue() + 0);

			response = price.getThen2().map(x -> {
				return "Was " + was + " then " + price.getCurrency().getValue() + x + ", now "
						+ populateNowPrice(price);
			}).orElse(price.getThen1().map(x -> {
				return "Was " + was + " then " + price.getCurrency().getValue() + x + ", now "
						+ populateNowPrice(price);
			}).orElse("Was " + was + ", now " + populateNowPrice(price)));

		} else if (PriceLabelTypeEnum.ShowPercDscount.equals(priceLabel)) {
			Float was = price.getWas().map(x -> {
				return x;
			}).orElse(0.0f);
			
			Float nowPrice=0.0f;
			try {
				nowPrice = Float.parseFloat((String) price.getNow());
			} catch (Exception e) {
				nowPrice = 0.00f;
			};
			response = calculateDiscountperc(nowPrice,was) + "% off - now " + populateNowPrice(price);

		}

		return response;
	}
	
	private Float calculateDiscountperc(Float nowPrice, Float was) {
		try {
		return ((was-nowPrice)/was)*100;
		}
		catch(Exception e){
			return 0.0f;
		}
	}
	
}
