/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy_deliverable2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grech
 */
public abstract class Account extends User implements Transactions, Serializable {

    private String cardNum;

    private double balance;

    private ArrayList<Account> linkedCheqSav;

    public Account() {
        this.cardNum = "";

    }

    public Account(double balance, User u) {
        super(u.getName(), u.getAccNum(), u.getPin());
        this.cardNum = u.getAccNum();
        this.balance = balance;

        linkedCheqSav = new ArrayList();
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" + "cardNum=" + cardNum + '}';
    }

    /**
     * * Withdraws a specified amount from the account balance. This method
     * performs a withdrawal operation by subtracting the given amount from the
     * current account balance. It checks if there are enough funds to process
     * the withdrawal. If successful, the new account balance is updated.
     *
     * @param amount amount The amount to be withdrawn from the account.
     */
    @Override
    public void withdraw(double amount) {

        
        if (  enoughFunds() != false) { // if true

            double newBalance = getBalance() - amount;

            if (newBalance >= 0) {
                this.setBalance(newBalance);
            }
        } 

    }

    /**
     * Retrieves the current balance of the account.
     *
     * This method returns the current balance of the account. It does not
     * modify the account state.
     *
     * @return The current balance of the account.
     */
    @Override
    public double balance() {
        return this.getBalance();

    }

    /**
     * Checks if the account has sufficient funds to perform
     * financial operations, such as withdrawals. 
     * It returns true if the account
     * balance is greater than zero.
     *
     * @return True if the account has sufficient funds, false otherwise.
     */
    public boolean enoughFunds() {
        //balance is > 0
        if (getBalance() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
