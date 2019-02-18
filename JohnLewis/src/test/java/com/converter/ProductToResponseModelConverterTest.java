package com.converter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.constants.CurrencyEnum;
import com.constants.PriceLabelTypeEnum;
import com.model.ColorSwatchModel;
import com.model.ColorSwatches;
import com.model.Price;
import com.model.Product;
import com.model.ResponseModel;




public class ProductToResponseModelConverterTest {
	ProductToResponseModelConverter productToResponseModelConverter;
	Product product;
	Price price;
	
	ColorSwatchesToColorSwatchModelConverter colorSwatchModelConverterMock = mock(ColorSwatchesToColorSwatchModelConverter.class);
	//ColorSwatchesToColorSwatchModelConverter colorSwatchModelConverterMock;
	

    @Before
    public void setUp() throws Exception {
    	 
    	
    	productToResponseModelConverter = new ProductToResponseModelConverter();
    	 price = new Price();
      	price.setCurrency(CurrencyEnum.GBP);
      	price.setNow("10.00");
      	price.setWas(Optional.ofNullable(20.00f)); 
      	price.setThen1(Optional.ofNullable(15.00f)); 
      	price.setThen2(Optional.ofNullable(13.00f)); 
    	ColorSwatches colorSwatches = new ColorSwatches();
    	colorSwatches.setBasicColor("Green");
		colorSwatches.setSkuId("237473294");
		colorSwatches.setColor("Green");
    	product = new Product(); 
    	product.setProductId("3509555");
    	product.setTitle("Warehouse V-Neck Cami Dress");
    	product.setPrice(price);
    	product.setColorSwatches(Arrays.asList(colorSwatches));
    	ColorSwatchModel colorSwatch = new ColorSwatchModel();
		colorSwatch.setColor("Black");
		colorSwatch.setSkuid("237469767");
		colorSwatch.setRgbColor("#000000");		
	    Mockito.when(colorSwatchModelConverterMock.convert(colorSwatches))
        .thenReturn(colorSwatch);
    }
    
    @Test
  	public void given_product_when_convertProductToResponseModel_then_returnResponseModel() throws Exception {    	
        ResponseModel responseModel =productToResponseModelConverter.convert(product);      	
		assertEquals("3509555", responseModel.getId());
		assertEquals("Warehouse V-Neck Cami Dress", responseModel.getTitle());
		assertEquals("£10.0", productToResponseModelConverter.populateNowPrice(price));
      	
      	
  	}
    @Test
 	public void given_product_and_labelTypeIsShowThenNow_when_convertProductToProductModel_then_returnProductModel() throws Exception {
     	
  		Optional<PriceLabelTypeEnum> priceType = Optional.of(PriceLabelTypeEnum.ShowWasThenNow);       	
         	ResponseModel responseModel = productToResponseModelConverter.populate(product, priceType);
          assertEquals("3509555", responseModel.getId());
  		assertEquals("Warehouse V-Neck Cami Dress", responseModel.getTitle());
  		assertEquals("£10.0", productToResponseModelConverter.populateNowPrice(price));
        	assertEquals("Was £20.0 then £13.0, now £10.0", responseModel.getPriceLabel());
     		
 		
 	}
    
   
    @Test
   	public void given_product_and_labelTypeIsShowPercDscount_when_convertProductToProductModel_then_returnProductModel() throws Exception {
       	
     
       	Optional<PriceLabelTypeEnum> priceType = Optional.of(PriceLabelTypeEnum.ShowPercDscount);       	
       	ResponseModel responseModel = productToResponseModelConverter.populate(product, priceType);
        assertEquals("3509555", responseModel.getId());
		assertEquals("Warehouse V-Neck Cami Dress", responseModel.getTitle());
		assertEquals("£10.0", productToResponseModelConverter.populateNowPrice(price));
      	assertEquals("50.0% off - now £10.0", responseModel.getPriceLabel());
   		
   	}
        
       @Test
   	public void given_product_and_labelTypeIsShowWasNow_when_convertProductToProductModel_then_returnProductModel() throws Exception {
       	
    		Optional<PriceLabelTypeEnum> priceType = Optional.of(PriceLabelTypeEnum.ShowWasNow);       	
           	ResponseModel responseModel = productToResponseModelConverter.populate(product, priceType);
            assertEquals("3509555", responseModel.getId());
    		assertEquals("Warehouse V-Neck Cami Dress", responseModel.getTitle());
    		assertEquals("£10.0", productToResponseModelConverter.populateNowPrice(price));
          	assertEquals("Was £20.0, now £10.0", responseModel.getPriceLabel());
       		
   		
   	}
       
      
       
}
