package com.converter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.model.ColorSwatchModel;
import com.model.ColorSwatches;

public class ColorSwatchesToColorSwatchModelConverterTest {

	

	ColorSwatchesToColorSwatchModelConverter colorSwatchModelConverter;
	

	@Before
	public void setUp() throws Exception {
		colorSwatchModelConverter = new ColorSwatchesToColorSwatchModelConverter();
	}

	@Test
	public void given_colorSwatches_and_basicColorIsBlack_when_convertColorSwatchesToColorSwatchModel_then_returnColorSwatchModel()
			throws Exception {


		// given
		ColorSwatches colorSwatches = new ColorSwatches();
		colorSwatches.setBasicColor("Black");
		colorSwatches.setSkuId("237469767");
		colorSwatches.setColor("Black");
		// when
		ColorSwatchModel colorSwatchModel = colorSwatchModelConverter.convert(colorSwatches);
		// then
		assertEquals("#000000", colorSwatchModel.getRgbColor());
		assertEquals("237469767", colorSwatchModel.getSkuid());
		assertEquals("Black", colorSwatchModel.getColor());
	}
	 @Test
	    public void given_colorSwatch_and_basicColorIsGreen_when_convertColorSwatchToColorSwatchModel_then_returnColorSwatchModel() throws Exception {
	        
	    	//given
	    	ColorSwatches colorSwatches = new ColorSwatches();
	    	colorSwatches.setBasicColor("Green");
			colorSwatches.setSkuId("237473294");
			colorSwatches.setColor("Green");
	        //when
	    	ColorSwatchModel colorSwatchModel  = colorSwatchModelConverter.convert(colorSwatches);
	    	//then	    	
	       
	        assertEquals("237473294", colorSwatchModel.getSkuid());
	        assertEquals("Green", colorSwatchModel.getColor());
	       assertEquals("#008000", colorSwatchModel.getRgbColor());
	    }
}
