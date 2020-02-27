package com.priceminister.account;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.priceminister.account.implementation.CustomerAccountRule;

public class CustomerAccountRuleTest {
	
	private AccountRule customerAccountRule;
	private static final Double VALID_AMMOUNT = 1.0;
	
	@Before
    public void setUp() throws Exception {
		customerAccountRule = new CustomerAccountRule();
    }
	
	/**
	 * checks {@link CustomerAccountRule#withdrawPermitted(Double)}.
	 */
	@Test
	public void withdrawPermittedTest() {
		assertTrue(this.customerAccountRule.withdrawPermitted(VALID_AMMOUNT));
	}

}
