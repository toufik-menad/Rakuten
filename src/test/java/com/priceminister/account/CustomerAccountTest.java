package com.priceminister.account;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.priceminister.account.implementation.CustomerAccount;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    private Account customerAccount;
    private AccountRule rule;
    private static final Double valueToAdd = 1.5D;
    private static final Double valueToWithdraw = 20000D;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotNull(this.customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	final Double initialBalance = this.customerAccount.getBalance();
        this.customerAccount.add(valueToAdd);
        assertEquals(Double.valueOf(initialBalance + valueToAdd), this.customerAccount.getBalance());
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     * @throws IllegalBalanceException 
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
    	this.customerAccount.withdrawAndReportBalance(valueToWithdraw,this.rule);
    }
    
    // Also implement missing unit tests for the above functionalities.

}
