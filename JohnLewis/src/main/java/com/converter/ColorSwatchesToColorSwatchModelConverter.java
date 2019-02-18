package com.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import com.constants.RGBEnum;
import com.model.ColorSwatchModel;
import com.model.ColorSwatches;

@Service
public class ColorSwatchesToColorSwatchModelConverter implements Converter<ColorSwatches, ColorSwatchModel> {


	@Override
	public ColorSwatchModel convert(ColorSwatches colorSwatches) {

		if (colorSwatches != null) {
			ColorSwatchModel colorSwatch = new ColorSwatchModel();
			colorSwatch.setColor(colorSwatches.getColor());
			colorSwatch.setSkuid(colorSwatches.getSkuId());
			colorSwatch.setRgbColor(getHexColor(colorSwatches.getBasicColor()));
			return colorSwatch;
		}
		return null;
	}

	private String getHexColor(String basicColor) {
		// TODO Auto-generated method stub
		if (isColorAvailableENUM(basicColor))
			return RGBEnum.valueOf(basicColor.toUpperCase()).getRGB();

		return basicColor;
	}

	private boolean isColorAvailableENUM(String basicColor) {
		// TODO Auto-generated method stub
		for (RGBEnum type : RGBEnum.values()) {
			if (basicColor.equalsIgnoreCase(type.name())) {
				return true;
			}
		}
		return false;
	}

	
}
