package com.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {
	
	private String id;
	private String title;
	private String nowPrice;
	private String priceLabel;
	private List<ColorSwatchModel> colorSwatches = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice(String nowPrice) {
		this.nowPrice = nowPrice;
	}
	public String getPriceLabel() {
		return priceLabel;
	}
	public void setPriceLabel(String priceLabel) {
		this.priceLabel = priceLabel;
	}
	public List<ColorSwatchModel> getColorSwatches() {
		return colorSwatches;
	}
	public void setColorSwatches(List<ColorSwatchModel> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}
	


}
