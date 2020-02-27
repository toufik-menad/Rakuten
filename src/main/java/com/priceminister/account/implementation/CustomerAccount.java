package com.priceminister.account.implementation;

import com.priceminister.account.*;

public class CustomerAccount implements Account {

	private Double balance;
	
	public CustomerAccount() {
		this.balance = 0.0;
	}

	/** private args constructor for {@link CustomerAccount#createWithValidBalance(Double)}.
	 * @param balance
	 */
	private CustomerAccount(final Double balance) {
		this.balance = balance;
	}

	/** Factory to instantiate {@link CustomerAccount} with appropriate balance.
	 * @param balance
	 * @return
	 * @throws IllegalBalanceException
	 */
	public static CustomerAccount createWithValidBalance(final Double balance) throws IllegalBalanceException {
		if (balance >= 0) {
			return new CustomerAccount(balance);
		} else {
			throw new IllegalBalanceException(balance);
		}
	}

	public void add(Double addedAmount) {
		this.balance = this.balance + addedAmount;
	}

	public Double getBalance() {
		return this.balance;
	}

	
	public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {

		if (rule.withdrawPermitted(this.balance - withdrawnAmount)) {
			return this.balance - withdrawnAmount;
		} else {
			throw new IllegalBalanceException(balance);
		}
	}

}
