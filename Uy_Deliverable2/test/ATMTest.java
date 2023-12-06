/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.ArrayList;
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
public class ATMTest {
    
    public ATMTest() {
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
     * Test of addUser method, of class ATM.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User u = null;
        ATM instance = new ATM();
        instance.addUser(u);
    }

    /**
     * Test of getInstance method, of class ATM.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        ATM expResult = null;
        ATM result = ATM.getInstance();
        assertEquals(expResult, result);
    }

    /**
     * Test of validate method, of class ATM.
     */
    @Test
    public void testValidate() {
        System.out.println("validate");
        ATM atm = null;
        String cardN = "";
        String pin = "";
        ATM instance = new ATM();
        boolean expResult = false;
        boolean result = instance.validate(atm, cardN, pin);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of cheqAccount method, of class ATM.
     */
    @Test
    public void testCheqAccount() {
        System.out.println("cheqAccount");
        ATM instance = new ATM();
        Account expResult = null;
        Account result = instance.cheqAccount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of savingsAcc method, of class ATM.
     */
    @Test
    public void testSavingsAcc() {
        System.out.println("savingsAcc");
        ATM instance = new ATM();
        Account expResult = null;
        Account result = instance.savingsAcc();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class ATM.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        double amount = 0.0;
        ATM instance = new ATM();
        instance.withdraw(amount);
        fail("The test case is a prototype.");
    }

    /**
     * Test of clientAccount method, of class ATM.
     */
    @Test
    public void testClientAccount() {
        System.out.println("clientAccount");
        ATM instance = new ATM();
        Account expResult = null;
        Account result = instance.clientAccount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of processRequest method, of class ATM.
     */
    @Test
    public void testProcessRequest() {
        System.out.println("processRequest");
        ATM instance = new ATM();
        instance.processRequest();
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidRequest method, of class ATM.
     */
    @Test
    public void testInvalidRequest() {
        System.out.println("invalidRequest");
        ATM instance = new ATM();
        instance.invalidRequest();
        fail("The test case is a prototype.");
    }

    /**
     * Test of balance method, of class ATM.
     */
    @Test
    public void testBalance() {
        System.out.println("balance");
        ATM instance = new ATM();
        double expResult = 0.0;
        double result = instance.balance();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterTransactionHistory method, of class ATM.
     */
    @Test
    public void testEnterTransactionHistory() {
        System.out.println("enterTransactionHistory");
        ATM instance = new ATM();
        instance.enterTransactionHistory();
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClient method, of class ATM.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
        ATM instance = new ATM();
        User expResult = null;
        User result = instance.getClient();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClient method, of class ATM.
     */
    @Test
    public void testSetClient() {
        System.out.println("setClient");
        User client = null;
        ATM instance = new ATM();
        instance.setClient(client);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChoice method, of class ATM.
     */
    @Test
    public void testGetChoice() {
        System.out.println("getChoice");
        ATM instance = new ATM();
        Account expResult = null;
        Account result = instance.getChoice();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChoice method, of class ATM.
     */
    @Test
    public void testSetChoice() {
        System.out.println("setChoice");
        Account choice = null;
        ATM instance = new ATM();
        instance.setChoice(choice);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class ATM.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        ATM instance = new ATM();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUsers();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class ATM.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        ArrayList<User> Users = null;
        ATM instance = new ATM();
        instance.setUsers(Users);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRequestProcess method, of class ATM.
     */
    @Test
    public void testSetRequestProcess() {
        System.out.println("setRequestProcess");
        boolean requestProcess = false;
        ATM instance = new ATM();
        instance.setRequestProcess(requestProcess);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRequestProcess method, of class ATM.
     */
    @Test
    public void testGetRequestProcess() {
        System.out.println("getRequestProcess");
        ATM instance = new ATM();
        boolean expResult = false;
        boolean result = instance.getRequestProcess();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTransaction method, of class ATM.
     */
    @Test
    public void testSetTransaction() {
        System.out.println("setTransaction");
        String transaction = "";
        ATM instance = new ATM();
        instance.setTransaction(transaction);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTransaction method, of class ATM.
     */
    @Test
    public void testGetTransaction() {
        System.out.println("getTransaction");
        ATM instance = new ATM();
        String expResult = "";
        String result = instance.getTransaction();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
