package com.gupta.nitin.billing.discount;

public class DiscountState {
	int stateAmount;
	int quantity;

	public DiscountState(int stateAmount, int quantity) {
		super();
		this.stateAmount = stateAmount;
		this.quantity = quantity;
	}

	public int getStateAmount() {
		return stateAmount;
	}

	public int getQuantity() {
		return quantity;
	}

}
