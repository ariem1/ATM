/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author grech
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCardNum method, of class Account.
     */
    @Test
    public void testGetCardNum() {
         System.out.println("getCardNum");
        User user1 = new User("Emma", "a10000", "0000");
        Account instance = new CheqAccount(110, user1);
        String expResult = "a10000";
        String result = instance.getCardNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCardNum method, of class Account.
     */
    @Test
    public void testSetCardNum() {
        System.out.println("setCardNum");
        String cardNum = "";
        Account instance = new AccountImpl();
        instance.setCardNum(cardNum);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBalance method, of class Account.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        Account instance = new AccountImpl();
        double expResult = 0.0;
        double result = instance.getBalance();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBalance method, of class Account.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        double balance = 0.0;
        Account instance = new AccountImpl();
        instance.setBalance(balance);
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Account.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Account instance = new AccountImpl();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amount = 0.0;
        Account instance = new AccountImpl();
        instance.withdraw(amount);
        fail("The test case is a prototype.");
    }

    /**
     * Test of balance method, of class Account.
     */
    @Test
    public void testBalance() {
        System.out.println("balance");
        Account instance = new AccountImpl();
        double expResult = 0.0;
        double result = instance.balance();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of enoughFunds method, of class Account.
     */
    @Test
    public void testEnoughFunds() {
        System.out.println("enoughFunds");
        Account instance = new AccountImpl();
        boolean expResult = false;
        boolean result = instance.enoughFunds();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public class AccountImpl extends Account {
    }
    
}
