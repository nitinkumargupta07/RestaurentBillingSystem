package com.gupta.nitin.billing;



public class Item {
	private String code;
	private  String description;
	private ItemType itemType;
	private int price;
	private int quantity;
	
	
	public Item(String code, String description, ItemType itemType, int price) {
		super();
		this.code = code;
		this.description = description;
		this.itemType = itemType;
		this.price = price;
		this.quantity=1;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(String code, String description, ItemType itemType, int price, int quantity) {
		super();
		this.code = code;
		this.description = description;
		this.itemType = itemType;
		this.price = price;
		this.quantity = quantity;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
