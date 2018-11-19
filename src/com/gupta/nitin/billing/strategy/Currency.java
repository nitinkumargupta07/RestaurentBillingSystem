package com.gupta.nitin.billing.strategy;

enum CurrencyType {
	USD, GPB, RS, BTH;
}

public class Currency {
	private int amount;

	public Currency(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}
}
