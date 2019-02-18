package com.constants;

public enum RGBEnum {
	GREY("#808080"), PINK("#FF00FF"), RED("#FF0000"), BLUE("#0000FF"), BLACK("#000000"), GREEN("#008000"), PURPLE(
			"#800080"), WHITE("#FFFFFF"), LIME("#00FF00"),GOLD("#FFD700"),ORANGE("#FFA500"),MULTI("#808080"),YELLOW("#FFFF00"), Cyan("#00FFFF"), Magenta("#FF00FF"), Silver("#C0C0C0"), Gray("#808080"), Maroon(
			"#800000"), Olive("#808000"), Purple("#800080"), Teal("#008080"), Navy("#000080");

	private RGBEnum(String string) {
		this.string = string;
	}

	private String string;

	public String getRGB() {
		return string;
	}
}
