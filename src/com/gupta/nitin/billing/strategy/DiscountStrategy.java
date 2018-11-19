package com.gupta.nitin.billing.strategy;

public interface DiscountStrategy {
	public float applyDiscount(int amount);
}

class LowBenefitDiscount implements DiscountStrategy {
	float discount;

	public LowBenefitDiscount() {
		this.discount = 10;
	}

	@Override
	public float applyDiscount(int amount) {
		return (amount * discount) / 100;
	}

}

class MaxBenefitDiscount implements DiscountStrategy {
	float discount;

	public MaxBenefitDiscount() {
		this.discount = 25;
	}

	@Override
	public float applyDiscount(int amount) {
		return (amount * discount) / 100;
	}

}

class DynamicStrategy implements DiscountStrategy {
	float discount;

	public DynamicStrategy(float discount) {
		this.discount = 25;
	}

	@Override
	public float applyDiscount(int amount) {
		return (amount * discount) / 100;
	}

}
