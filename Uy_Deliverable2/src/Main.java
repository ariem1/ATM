/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author grech
 */
public class Main extends Application {

    private Stage primaryStage;

    /**
     * Main method to execute the ATM 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //make user
        User user1 = new User("Emma", "a10000", "0000");

        //make a Chequing
        CheqAccount c1 = new CheqAccount(110, user1);

        //make Savings account
        SavingsAcc s1 = new SavingsAcc(100, user1);

        //link Cheq to User
        user1.linkAccount(c1);
        //link savings to user 
        user1.linkAccount(s1);

        //hashmap acc num & pin
        user1.mapPinAcc(c1, user1.getPin());
        user1.mapPinAcc(s1, user1.getPin());

        //make user
        User user2 = new User("Cyreen", "a20000", "0000");

        //make a Chequing
        CheqAccount c2 = new CheqAccount(110, user2);

        //make Savings account
        SavingsAcc s2 = new SavingsAcc(100, user2);

        //link Cheq to User
        user2.linkAccount(c2);
        //link savings to user 
        user2.linkAccount(s2);

        //hashmap acc num & pin
        user2.mapPinAcc(c2, user2.getPin());

        user2.mapPinAcc(s2, user2.getPin());

        //make an ATM
        ATM atm = new ATM();

        //link user to ATM
        atm.addUser(user1);
        //link user to ATM
        atm.addUser(user2);

        //launch javafx
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("ATM");

        //shows the login window
        showLoginScene();
    }

    private void showLoginScene() {
        System.out.println("Welcome to ATM!");
        //make container
        VBox vbLogin = new VBox();
        vbLogin.setAlignment(Pos.CENTER);
        vbLogin.setSpacing(10);

        //enter username text
        Text accNumText = new Text("Enter account number: ");
        //acc number field
        TextField accField = new TextField();
        accField.setMaxWidth(200);

        //enter pin text
        Text passText = new Text("Enter PIN: ");
        //password field
        PasswordField pinField = new PasswordField();
        pinField.setMaxWidth(200);

        //make invalid text
        Text invalid = new Text();
        invalid.setText("Invalid account number or pin!");
        invalid.setFill(Color.RED);
        invalid.setVisible(false);

        //login button
        Button loginButton = new Button("Login");

        //event handler for loginButton, next scene is choosing transactions
        loginButton.setOnAction(e -> chooseTransaction(accField, pinField, invalid));

        //add children to vbox
        vbLogin.getChildren().addAll(accNumText, accField,
                passText, pinField, invalid,
                loginButton);

        //make login scene and show scene
        Scene loginScene = new Scene(vbLogin, 300, 300);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void chooseTransaction(TextField acc, TextField pin, Text invalid) {
        

        VBox vbAccount = new VBox(10);
        vbAccount.setAlignment(Pos.CENTER);
        Button withdrawButton = new Button("Withdraw");
        Button balanceButton = new Button("Check Balance");
        Button cancelButton = new Button("Cancel transaction");

        Text selectText = new Text("Select Transaction: ");

        //checks if pin and card number match
        if (atm().validate(atm(), acc.getText(), pin.getText())) {

            System.out.println("Login successful.");
            System.out.println("User : " + acc.getText());
              
            //if true go to next scenes
            withdrawButton.setOnAction(e -> showAccountTypeScene("Withdraw"));
            balanceButton.setOnAction(e -> showAccountTypeScene("Balance"));
            cancelButton.setOnAction(e -> endScene());

            //add nodes to container
            vbAccount.getChildren().addAll(selectText, withdrawButton,
                    balanceButton, cancelButton);

            //set scene
            Scene chooseTransaction = new Scene(vbAccount, 300, 300);
            primaryStage.setScene(chooseTransaction);
        } else {

            //display invalid in sene
            invalid.setVisible(true);

        }

    }

    private void showAccountTypeScene(String transaction) {

        //make vbox
        VBox vbAccount = new VBox(10);
        vbAccount.setAlignment(Pos.CENTER);

        //make button
        Button checkingButton = new Button("Checking");
        Button savingsButton = new Button("Savings");

        //if transaction chosen is withdrawal
        if (transaction == "Withdraw") {
            checkingButton.setOnAction(e -> showWithdrawalScene("Chequing"));
            savingsButton.setOnAction(e -> showWithdrawalScene("Savings"));
            //if transaction chosen is check balance
        } else if (transaction == "Balance") {
            checkingButton.setOnAction(e -> showBalanceScene("Chequing"));
            savingsButton.setOnAction(e -> showBalanceScene("Savings"));
        }

        vbAccount.getChildren().addAll(new Label("Select Account Type:"),
                checkingButton, savingsButton);

        //set scene
        Scene accountChoose = new Scene(vbAccount, 300, 300);
        primaryStage.setScene(accountChoose);
    }

    private void showWithdrawalScene(String accountType) {
        System.out.println("Withdrawal Transaction");

        VBox vbWithdrawal = new VBox(10);
        vbWithdrawal.setAlignment(Pos.CENTER);
        TextField amountText = new TextField();
        amountText.setMaxWidth(200);
        Text invalid = new Text();
        invalid.setText("Invalid input");
        invalid.setVisible(false);
        Button enterWithdrawButton = new Button("Withdraw");

        //set scene
        Scene withdrawalScene = new Scene(vbWithdrawal, 300, 300);

        //sets the type of account the client wants to withdraw from
        if (accountType == "Chequing") {
  
            //set chequing account
            atm().setChoice(atm().cheqAccount());

            //  enterWithdrawButton.setOnAction(e -> cheqSaveWithdraw(amountText));
        } else if (accountType == "Savings") {
            //set chequing account
            atm().setChoice(atm().savingsAcc());

        }

        if (containsLetters(amountText.getText())) {
            System.err.println("Invalid input");
                    invalid.setVisible(true);


        } else {
            primaryStage.setScene(withdrawalScene);
        }

        enterWithdrawButton.setOnAction(e -> cheqSaveWithdraw(amountText));

        vbWithdrawal.getChildren().addAll(new Label("Enter Amount to Withdraw:"),
                amountText, invalid, enterWithdrawButton);

    }

    private void cheqSaveWithdraw(TextField amountText) {

        VBox vbProcess = new VBox(10);
        vbProcess.setAlignment(Pos.CENTER);
        Text accountText = new Text();
        Text processText = new Text();
        Text newBalanceText = new Text();
        vbProcess.getChildren().addAll(accountText, processText, newBalanceText);
        Scene processScene = new Scene(vbProcess, 300, 300);

        Button moreTransaction = new Button("Do another transaction");
        Button finishTransactionButton = new Button("Finish transaction");

        vbProcess.getChildren().addAll(moreTransaction, finishTransactionButton);

        double amount = 0;
        if (containsLetters(amountText.getText())) {
            System.err.println("Invalid input");

        } else {

            //if (amountText.getText().contains("0123456789")) {
            amount = Double.parseDouble(amountText.getText());

            //call atm withdraw
            atm().withdraw(amount);

            if (atm().getRequestProcess() != false) {

                accountText.setText("Withdraw from Chequing Account:\n\n");
                processText.setText("Amount withdrawn: $" + amount);

                Account clientAcc;
                double balance = 0;
                atm().setTransaction("Withdrawal");

                //if withdrawal is from chequing, show new balance from chequing
                if (atm().getChoice().getClass().equals(atm().cheqAccount().getClass())) {

                    //get the client's cheqiung
                    for (int i = 0; i < atm().getClient().getAccLinked().size(); i++) {

                        if (atm().getClient().getAccLinked().get(i).getClass().equals(atm().cheqAccount().getClass())) {

                            clientAcc = atm().getClient().getAccLinked().get(i);

                            //atm().enterTransactionHistory("Withdrawal");
                            balance = clientAcc.getBalance();
                            newBalanceText.setText("New balance: $ " + balance + "\n\n");

                        }

                    }

                } else if (atm().getChoice().getClass().equals(atm().savingsAcc().getClass())) {

                    accountText.setText("Withdraw from Savings Account\n\n");

                    //get the client's cheqiung
                    for (int i = 0; i < atm().getClient().getAccLinked().size(); i++) {

                        if (atm().getClient().getAccLinked().get(i).getClass().equals(atm().savingsAcc().getClass())) {

                            clientAcc = atm().getClient().getAccLinked().get(i);

                            balance = clientAcc.getBalance();
                            newBalanceText.setText("New balance " + balance);

                        }

                    }
                }

            } else {

                //Withdraw denied
                System.out.println("Withdraw denied \nInsufficient funds.");
                processText.setText("Withdraw denied \nInsufficient funds.");
                primaryStage.setScene(processScene);

            }
            moreTransaction.setOnAction(e -> transactionsScene());
            finishTransactionButton.setOnAction(e -> recieptScene());

            primaryStage.setScene(processScene);

        }

    }

    private static boolean containsLetters(String input) {
        // Use regular expression to check if the string contains letters
        return input.matches(".*[a-zA-Z].*");
    }

    //when the user chooses balance and account already
    public void showBalanceScene(String accountType) {
        System.out.println("Check balance transaction");

        VBox vbAccount = new VBox(60);
        vbAccount.setAlignment(Pos.CENTER);
        VBox vb1 = new VBox(10);
        VBox vb2 = new VBox(10);
        vb1.setAlignment(Pos.CENTER);
        vb2.setAlignment(Pos.CENTER);

        Text balance = new Text();
        Text yourBalanceText = new Text();
        Text choiceAccText = new Text();
        Font font = new Font("Arial", 14);

        vb1.getChildren().addAll(choiceAccText,
                yourBalanceText, balance);

        String balanceAmount;

        if (accountType == "Chequing") {

            //set chequing account
            atm().setChoice(atm().cheqAccount());

            choiceAccText.setText("Chequing account");

            //display balance amount
            //enterWithdrawButton.setOnAction(e -> cheqWithdraw(amountText));
        } else if (accountType == "Savings") {
            //set chequing account
            atm().setChoice(atm().savingsAcc());

            choiceAccText.setText("Savings account");
        }

        //call atm withdrawal
        balanceAmount = "" + atm().balance();

        yourBalanceText.setText("Your balance is: ");
        balance.setFont(font);
        balance.setText("$" + balanceAmount);

        //add back button
        Button doMoreButton = new Button("More transactions");
        Button finishTransactionButton = new Button("Finish transaction");

        //buttons actions
        doMoreButton.setOnAction(e -> transactionsScene());
        finishTransactionButton.setOnAction(e -> endScene());

        //VBox
        vb2.getChildren().addAll(doMoreButton, finishTransactionButton);

        //set stage
        Scene scene = new Scene(vbAccount, 300, 300);
        primaryStage.setScene(scene);

        vbAccount.getChildren().addAll(vb1, vb2);

    }

    public void cheqSaveBalance(TextField amountText) {

        VBox vbProcess = new VBox(10);
        vbProcess.setAlignment(Pos.CENTER);
        Text processText = new Text();

        vbProcess.getChildren().addAll(processText);

        double amount = Double.parseDouble(amountText.getText());

    }

    public void transactionsScene() {

        VBox vbAccount = new VBox(10);
        vbAccount.setAlignment(Pos.CENTER);
        Button withdrawButton = new Button("Withdraw");
        Button balanceButton = new Button("Check Balance");
        Button cancelButton = new Button("Cancel transaction");

        Text selectText = new Text("Select Transaction: ");

        withdrawButton.setOnAction(e -> showAccountTypeScene("Withdraw"));
        balanceButton.setOnAction(e -> showAccountTypeScene("Balance"));
        cancelButton.setOnAction(e -> endScene());

        vbAccount.getChildren().addAll(selectText, withdrawButton,
                balanceButton, cancelButton);

        //set scene
        Scene chooseTransaction = new Scene(vbAccount, 300, 300);
        primaryStage.setScene(chooseTransaction);

    }

    public void finishScene() {

        //finish transaction
    }

    public void recieptScene() {

        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);
        Text recieptText = new Text();
        recieptText.setText("Print reciept?");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        vb.getChildren().addAll(recieptText, yesButton, noButton);
        Scene scene = new Scene(vb, 300, 300);

        yesButton.setOnAction(e -> printReciept());
        noButton.setOnAction(e -> endScene());

        primaryStage.setScene(scene);
        //add user text/json into file of atm user transaction history
    }

    public void printReciept() {

        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);
        Text recieptText = new Text();
        recieptText.setText("Transaction ended.\nThank you! \n\nReciept printed. \nDon't forget to take your reciept.");

        vb.getChildren().addAll(recieptText);
        Scene scene = new Scene(vb, 300, 300);

        scene.setOnMouseClicked(e -> primaryStage.close());

        primaryStage.setScene(scene);

    }

    public void endScene() {

        System.out.println("Transaction ended.");

        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);
        Text recieptText = new Text();
        recieptText.setText("Transaction ended. \nThank you!");

        vb.getChildren().add(recieptText);

        Scene endScene = new Scene(vb, 300, 300);

        primaryStage.setScene(endScene);

        //when u click the screen, it closes
        endScene.setOnMouseClicked(e -> primaryStage.close());

    }

    public ATM atm() {

        return ATM.getInstance();
    }

}
