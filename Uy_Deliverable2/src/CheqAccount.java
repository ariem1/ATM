/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author grech
 */
public class CheqAccount extends Account {

    //default constrcutor
    public CheqAccount() {
    }

    public CheqAccount(double balance, User u) {
        super(balance, u);

    }

    @Override
    public String toString() {
        return "Chequing Account of account holder:" + super.getCardNum();
    }
}
