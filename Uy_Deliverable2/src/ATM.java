/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The ATM class represents an Automated Teller Machine that allows users to
 * perform banking transactions.
 *
 * * @author grech
 */
public class ATM implements Transactions {

    private static ArrayList<User> Users;
    private static ATM instance;
    private User client;
    private Account choice;
    private boolean requestProcess;
    private String transaction;

    //default constructor
    public ATM() {
        this.Users = new ArrayList<User>();
        instance = this;

    }

    /**
     * Adds a User to the ArrayList of Users. Maintains a list of Users for the
     * ATM
     *
     * @param u User to be added.
     */
    public void addUser(User u) {
        Users.add(u);
    }

    /**
     *
     * @return
     */
    public static ATM getInstance() {
        if (instance == null) {
            instance = new ATM();
        }
        return instance;
    }

    /**
     * Validates a user's card and PIN
     *
     * @param atm The ATM instance.
     * @param cardN The card number to validate.
     * @param pin The PIN to validate.
     * @return True if the card number and PIN are valid, false otherwise.
     */
    public boolean validate(ATM atm, String cardN, String pin) {

        //makes a temporary User for login verification
        User checkUser = new User(cardN, pin);

        //verify cardNum & pin format
        if ((HelperClass.validateCardNum(cardN)
                && HelperClass.validatePIN(pin))) {

            //checks if user is in the User list
            if (HelperClass.UserExists(checkUser.getAccNum()) >= 0) {

                //gets the index of the user in the User list
                int ind = HelperClass.UserExists(checkUser.getAccNum());

                //if account number exists, check if pin is right
                User client = Users.get(ind);

                //check if accNum is with the right pin
                if (client.getAccPinMap().get(cardN) != null && (client.getAccPinMap().get(cardN).equals(pin))) {

                    this.setClient(client);

                } else {

                    return false;
                }

            } else {
                System.err.println("Invalid login.");

                return false;
            }

            return true;
        } else {

            //output if acc number and pin don't match
            System.err.println("Invalid login.");
            return false;

        }
    }

    /**
     * Helper class for ATM class that validates account number and pin
     */
    private static class HelperClass {

        /**
         * Validates the format of the card number entered
         *
         * @param cardNum The card number entered.
         * @return True if it is has the right length of 6 and if it is not
         * empty, false otherwise.
         */
        private static boolean validateCardNum(String cardNum) {

            //if cardNum length is good
            return cardNum.length() == 6 && !cardNum.isEmpty();
        }

        /**
         * Validates the format of the pin number entered.
         *
         * @param pin The pin number entered.
         * @return True if it is has the right length of 4 and if it is not
         * empty, false otherwise.
         */
        private static boolean validatePIN(String pin) {
            // If pin length is good and not empty
            return pin.length() == 4 && !pin.isEmpty();
        }

        /**
         * Verifies the user exists by returning the index of the User within
         * the User list
         *
         * @param accNum Account number to be entered.
         * @return The index of the User within the Users list.
         */
        public static int UserExists(String accNum) {

            int ind = -1;
            for (int i = 0; i < Users.size(); i++) {
                //checks the user's account number
                if (Users.get(i).getAccNum().equals(accNum)) {
                    ind = i;
                    //exit loop if found
                    break;
                }

            }

            return ind;
        }

    }

    /**
     * Creates and returns a Chequing Account.
     *
     * @return A Chequing Account instance.
     */
    public Account cheqAccount() {
        CheqAccount c = new CheqAccount();

        return c;

    }

    /**
     * Creates and returns a Savings Account.
     *
     * @return A Savings Account instance.
     */
    public Account savingsAcc() {
        SavingsAcc s = new SavingsAcc();
        return s;
    }

    /**
     * Withdraws the specified amount from the client's account. The withdrawal
     * is processed if the account has sufficient funds.
     *
     * @param amount The amount to be withdrawn.
     */
    @Override
    public void withdraw(double amount) {

        //assigning the account that the user has chosen
        Account clientAcc = clientAccount();

        if (clientAcc.enoughFunds() != false) {
            //verify is account has necessary funds

            //if balance is greater than amount, 
            if (clientAcc.balance() >= amount) {

                //prints and sets request is being processed
                processRequest();

                //calls account's withdraw method
                clientAcc.withdraw(amount);

                //gets the transaction history
                enterTransactionHistory();

            } else {
                invalidRequest();

            }

        } else {
            invalidRequest();

        }

    }

    /**
     * Retrieves the client's account based on the selected account type
     * (chequing or savings).
     *
     * @return The client's account corresponding to the selected account type.
     */
    public Account clientAccount() {

        Account clientAcc = null;

        if (choice.getClass().equals(cheqAccount().getClass())) {

            //get the client's cheqiung
            for (int i = 0; i < client.getAccLinked().size(); i++) {

                if (client.getAccLinked().get(i).getClass().equals(cheqAccount().getClass())) {

                    clientAcc = client.getAccLinked().get(i);

                }
            }

            //if choice is savingsAcc
        } else if (choice.getClass().equals(savingsAcc().getClass())) {

            //get the client's savings
            for (int i = 0; i < client.getAccLinked().size(); i++) {

                if (client.getAccLinked().get(i).getClass().equals(savingsAcc().getClass())) {

                    clientAcc = client.getAccLinked().get(i);

                }
            }
        }

        return clientAcc;
    }

    /**
     * Processes the request and sets request process to true. This method is
     * called when a transaction request is being processed.
     */
    public void processRequest() {
        System.out.println("Processing request");
        //set the request process as true
        this.requestProcess = true;

    }

    /**
     * Marks the transaction request as invalid. This method is called when a
     * transaction request is determined to be invalid.
     */
    public void invalidRequest() {
        System.out.println("Invalid. Request not processed.");
        this.requestProcess = false;
    }

    /**
     * Retrieves the balance of the client's account. This method determines the
     * type of account (chequing or savings) chosen by the client and returns
     * the corresponding balance.
     *
     * @return The current balance of the client's account.
     */
    @Override
    public double balance() {
        Account clientAcc = clientAccount();

        //verify account has necessary funds
        return clientAcc.balance();

    }

    /**
     * Records a withdrawal transaction and updates the ATM's transaction
     * history.
     *
     *
     */
    public void enterTransactionHistory() {

        // Get the account number of the client
        String setAccNumber = "" + this.getClient().getAccNum();
        // Specify the transaction type
        String transaction = "Withdrawal";
        // Get the current date and time
        Date date = new Date();

        // Create an ATMTransactions object
        ATMTransactions toFile = new ATMTransactions(transaction,
                setAccNumber, date);

        System.out.println("\n");

        //display transaction log to console
        String log = setAccNumber + " " + transaction + " " + date;
        System.out.println(log);

        // Make a JSON file for the transaction
        String filePath = "atmWithdrawalHistory.json";

        // Read existing data from the file
        List<ATMTransactions> existingData = readDataFromFile(filePath);

        // Append the new data
        existingData.add(toFile);

        // Write the updated data back to the file
        writeDataToFile(filePath, existingData);

    }

    /**
     * Reads data from the specified JSON file and returns a list of
     * ATMTransactions.
     *
     * @param filePath The path of the JSON file.
     * @return A list of ATMTransactions read from the file. If the file doesn't
     * exist or an error occurs, returns an empty list.
     */
    private List<ATMTransactions> readDataFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File(filePath);

            // If the file doesn't exist, return an empty list
            if (!file.exists()) {
                return new ArrayList<>();
            }

            // Read the existing data from the file
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, ATMTransactions.class));

        } catch (IOException e) {

            e.printStackTrace();
            System.err.println("An error occurred while reading/writing data. Please try again.");

            return new ArrayList<>();
        }
    }

    /**
     * Writes the specified list of ATMTransactions to the specified JSON file.
     *
     * @param filePath The path of the JSON file.
     * @param data The list of ATMTransactions to be written to the file.
     */
    private void writeDataToFile(String filePath, List<ATMTransactions> data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            // Write the updated data back to the file
            objectMapper.writeValue(new File(filePath), data);
            System.out.println("Data has been appended to " + filePath);
            System.out.println("\n");
        } catch (IOException e) {

            e.printStackTrace();
            System.err.println("An error occurred while reading/writing data. Please try again.");
        }
    }

    //getters and setters
    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Account getChoice() {
        return choice;
    }

    public void setChoice(Account choice) {
        this.choice = choice;
    }

    public ArrayList<User> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<User> Users) {
        this.Users = Users;
    }

    public void setRequestProcess(boolean requestProcess) {
        this.requestProcess = requestProcess;
    }

    public boolean getRequestProcess() {
        return requestProcess;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }

}
