/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author grech
 */
public class User {

    private String name;
    private String accNum;
    private String pin;
    private ArrayList<Account> accLinked;
    private HashMap<String, String> accPinMap;

    public User() {
        this.accNum = "";

    }

    public User(String name, String accNum, String pin) {
        this.name = name;
        this.accLinked = new ArrayList();
        this.accPinMap = new HashMap();
        this.accNum = accNum;
        this.pin = pin;

    }

    public User(String accNum, String pin) {
        this.accNum = accNum;
        this.pin = pin;

    }

    /**
     * Verifies if the provided card number and PIN match the stored PIN in the
     * account.
     *
     * @param cardN The card number to verify.
     * @param pin The PIN to verify.
     * @return True if the PIN matches the card number, otherwise false.
     */
    public boolean verifyPINAcc(String cardN, String pin) {

        //veryify if pin and card number match
        return accPinMap.get(cardN).equals(pin);
    }

    /**
     * Adds an account to the client's profile.
     *
     * @param accToLink The account to be linked to the client's profile.
     */
    public void linkAccount(Account accToLink) {

        this.accLinked.add(accToLink);
    }

    /**
     * Adds a card number and pin to the mapping
     *
     * @param an The account to add.
     * @param pin The pin associated with the account
     */
    public void mapPinAcc(Account an, String pin) {

        this.accPinMap.put(an.getCardNum(), pin);
    }

    /**
     * Retrieves the chequing account linked to the client.
     *
     * @return The chequing account linked to the client.
     */
    public Account getChequing() {

        int ind = -1;
        for (int i = 0; i < this.getAccLinked().size(); i++) {

            if (this.getAccLinked().get(i).getClass().equals(CheqAccount.class)) {
                ind = i;
            }
        }

        return this.getAccLinked().get(ind);
    }
    
        /**
     * Retrieves the savings account linked to the client.
     *
     * @return The savings account linked to the client.
     */
    public Account getSavings() {

        int ind = -1;
        for (int i = 0; i < this.getAccLinked().size(); i++) {

            if (this.getAccLinked().get(i).getClass().equals(SavingsAcc.class)) {
                ind = i;
            }
        }

        return this.getAccLinked().get(ind);
    }


    //getters & setters
    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getName() {
        return name;
    }

    public void setHolderName(String name) {
        this.name = name;
    }

    public ArrayList<Account> getAccLinked() {
        return accLinked;
    }

    public void setAccLinked(ArrayList<Account> accLinked) {
        this.accLinked = accLinked;
    }

    public HashMap<String, String> getAccPinMap() {
        return accPinMap;
    }

    public void setAccPinMap(HashMap<String, String> accPinMap) {
        this.accPinMap = accPinMap;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "" + this.getAccNum();
    }

}
