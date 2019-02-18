package com.model;

import java.util.Optional;

import com.constants.CurrencyEnum;


public class Price {
	
	private Optional<Float> was;
	private Optional<Float> then1;
	private Optional<Float> then2;
	private Object now;
	private CurrencyEnum currency;
	public Optional<Float> getWas() {
		return was;
	}
	public void setWas(Optional<Float> was) {
		this.was = was;
	}
	public Optional<Float> getThen1() {
		return then1;
	}
	public void setThen1(Optional<Float> then1) {
		this.then1 = then1;
	}
	public Optional<Float> getThen2() {
		return then2;
	}
	public void setThen2(Optional<Float> then2) {
		this.then2 = then2;
	}
	public Object getNow() {
		return now;
	}
	public void setNow(Object now) {
		this.now = now;
	}
	public CurrencyEnum getCurrency() {
		return currency;
	}
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}

}

