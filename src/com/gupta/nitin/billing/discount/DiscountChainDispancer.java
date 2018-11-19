package com.gupta.nitin.billing.discount;

import java.util.ArrayList;
import java.util.List;

import com.gupta.nitin.billing.strategy.Currency;

interface DispenseChain {
	void setNextChain(DispenseChain nextChain);

	/**
	 * @deprecated Use {@link #dispense(Currency,List)} instead
	 */
	void dispense(Currency cur);

	void dispense(Currency cur, List<DiscountState> discountState);
}

class Discount200Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	/**
	 * @deprecated Use {@link #dispense(Currency,List)} instead
	 */
	@Override
	public void dispense(Currency cur) {
		dispense(cur, null);
	}

	@Override
	public void dispense(Currency cur, List<DiscountState> discountState) {
		if (cur.getAmount() >= 200) {
			int num = cur.getAmount() / 200;
			int remainder = cur.getAmount() % 200;
			System.out.println("Dispensing " + num + " 200$ note");
			discountState.add(new DiscountState(200, num));
			if (remainder != 0)
				System.out.println("Remaining Amount is " + remainder + " $ ");
			this.chain.dispense(new Currency(remainder), discountState);
		} else {
			this.chain.dispense(cur, discountState);
		}
	}
}

class Discount100Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	/**
	 * @deprecated Use {@link #dispense(Currency,List)} instead
	 */
	@Override
	public void dispense(Currency cur) {
		dispense(cur, null);
	}

	@Override
	public void dispense(Currency cur, List<DiscountState> discountState) {
		if (cur.getAmount() >= 100) {
			int num = cur.getAmount() / 100;
			int remainder = cur.getAmount() % 100;
			discountState.add(new DiscountState(100, num));
			System.out.println("Dispensing " + num + " 100$ note");
			if (remainder != 0)
				this.chain.dispense(new Currency(remainder), discountState);
		} else {
			this.chain.dispense(cur, discountState);
		}
	}
}

class Discount10Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	/**
	 * @deprecated Use {@link #dispense(Currency,List)} instead
	 */
	@Override
	public void dispense(Currency cur) {
		dispense(cur, null);
	}

	@Override
	public void dispense(Currency cur, List<DiscountState> discountState) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			int remainder = cur.getAmount() % 10;
			discountState.add(new DiscountState(10, num));
			System.out.println("Dispensing " + num + " 10$ note");
			if (remainder != 0)
			discountState.add(new DiscountState(remainder, 1));
			this.chain.dispense(new Currency(remainder));
		} else {
			this.chain.dispense(cur, discountState);
		}
	}
}

public class DiscountChainDispancer {
	private DispenseChain chain1;
	private DispenseChain chain2;
	private DispenseChain chain3;
	List<DiscountState> discountState = new ArrayList<>();

	public DiscountChainDispancer() {
		this.chain1 = new Discount200Dispenser();
		this.chain2 = new Discount100Dispenser();
		this.chain3 = new Discount10Dispenser();
		// set the chain of responsibility
		chain1.setNextChain(chain2);
		chain2.setNextChain(chain3);
	}

	public float calculateTotalDiscount(Currency cur) {
		if (cur.getAmount() <= 100) {
			System.out.println("No discount less or equal to 100 rs");
			return cur.getAmount();
		} else {
			// process the request
			chain1.dispense(cur, discountState);
		}
		return 0;

	}

}
