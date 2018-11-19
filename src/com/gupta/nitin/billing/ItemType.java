package com.gupta.nitin.billing;

public enum ItemType {
	FRUITS("fru"), VEGETABLES("veg"), LIQUOURS("liq"), TEA("tea"), COFFEE("coffee"), COLD_DRINKS("cold_drinks"),
	SODAS("sod");

	private String dbCode;

	ItemType(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getDbCode() {
		return this.dbCode;
	}
}
