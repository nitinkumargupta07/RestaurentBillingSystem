package com.gupta.nitin.billing.totalAmount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gupta.nitin.billing.Item;
import com.gupta.nitin.billing.strategy.DiscountStrategy;
import com.gupta.nitin.billing.strategy.PaymentStrategy;

public class OrderCart {
	// List of items
	List<Item> items;
	public static Map<String, Integer> discountConfigurationMap = new HashMap<>();

	public OrderCart() {
		this.items = new ArrayList<Item>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public int calculateTotal() {
		int sum = 0;
		for (Item item : items) {
			sum += item.getPrice() * item.getQuantity();
		}
		return sum;
	}

	static void fillDiscountConfigurationMap() {
		discountConfigurationMap.put("LowBenefitDiscount", 10);
		discountConfigurationMap.put("MaxBenefitDiscount", 25);
		discountConfigurationMap.put("NoDiscount", 25);
	}

	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}

	public void applyDiscount(DiscountStrategy discountStrategy) {
		int amount = calculateTotal();
		discountStrategy.applyDiscount(amount);
	}

}
