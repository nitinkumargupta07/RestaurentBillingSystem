package com.gupta.nitin.billing.strategy;

public interface PaymentStrategy {
	public void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {

	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String nm, String ccNum, String cvv, String expiryDate) {
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}

}

class NetBankingStrategy implements PaymentStrategy {

	private String username;
	private String password;

	public NetBankingStrategy(String username, String pwd) {
		this.username = username;
		this.password = pwd;
	}

	@Override
	public void pay(int amount) {
		System.out.println(amount + " paid using Net Banking.");
	}

}
