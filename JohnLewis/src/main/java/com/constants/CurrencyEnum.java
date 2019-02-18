package com.constants;

public enum CurrencyEnum {
	GBP("£"), USD("$"), EUR("€");
	
	private String value;

     public String getValue() {
		return value;
	}


	CurrencyEnum(String value){
        this.value = value;
    }
}

