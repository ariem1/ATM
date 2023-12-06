/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The Transactions interface defines methods for banking transactions.
 * It includes methods for withdrawing funds and retrieving the current account balance.
 * Classes implementing this interface should provide the specific implementation for these methods.
 *
 * @author grech
 */
public interface Transactions {

    /**
     * Withdraws the specified amount from the account.
     *
     *
     * @param amount The amount to be withdrawn.
     */
    void withdraw(double amount);

    /**
     * Retrieves the current balance of the account.
     *
     * @return The current account balance.
     */
    double balance();

}
