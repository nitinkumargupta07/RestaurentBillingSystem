package com.gupta.nitin;

import com.gupta.nitin.billing.Item;
import com.gupta.nitin.billing.ItemType;
import com.gupta.nitin.billing.discount.DiscountChainDispancer;
import com.gupta.nitin.billing.strategy.Currency;
import com.gupta.nitin.billing.totalAmount.OrderCart;

public class TestBillingSoftware {
	 

	

	public static void main(String[] args) {
		OrderCart cart = new OrderCart();
		cart.addItem(new Item("RG", "Regular Tea", ItemType.TEA, 10));
		cart.addItem(new Item("MS", "Masalla Tea", ItemType.TEA, 15));
		cart.addItem(new Item("LM", "LEMON Tea", ItemType.TEA, 10));
		cart.addItem(new Item("CC", "cold coffee", ItemType.COLD_DRINKS, 30));
		cart.addItem(new Item("CH", "Capechino", ItemType.COLD_DRINKS, 50));
		cart.addItem(new Item("RG", "Regular Tea", ItemType.TEA, 10));
		cart.addItem(new Item("LS", "Lassi", ItemType.COLD_DRINKS, 30));
		cart.addItem(new Item("SP", "Sprite  ", ItemType.COLD_DRINKS, 15));
		cart.addItem(new Item("MS", "Masalla Tea", ItemType.TEA, 15));
		cart.addItem(new Item("LM", "LEMON Tea", ItemType.TEA, 10));
		cart.addItem(new Item("NS", "Ness coffee  ", ItemType.COFFEE, 20));
		cart.addItem(new Item("CC", "cold coffee", ItemType.COFFEE, 30));
		cart.addItem(new Item("CH", "Capechino", ItemType.COFFEE, 50));
		cart.addItem(new Item("NS", "Ness coffee  ", ItemType.COFFEE, 20));
		cart.addItem(new Item("CC", "cold coffee", ItemType.COFFEE, 30));
		cart.addItem(new Item("CH", "Capechino", ItemType.COFFEE, 50));
		cart.addItem(new Item("NS", "Ness coffee  ", ItemType.COLD_DRINKS, 20));
		cart.addItem(new Item("CC", "cold coffee", ItemType.COLD_DRINKS, 30));
		cart.addItem(new Item("CH", "Capechino", ItemType.COLD_DRINKS, 50));
		cart.addItem(new Item("PS", "Pepsi    ", ItemType.COLD_DRINKS, 10));
		cart.addItem(new Item("LS", "Lassi", ItemType.COLD_DRINKS, 30));
		cart.addItem(new Item("SP", "Sprite  ", ItemType.COLD_DRINKS, 15));
		int amount = cart.calculateTotal();
		new DiscountChainDispancer().calculateTotalDiscount(new Currency(amount));
	}

}
