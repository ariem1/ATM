/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy_deliverable2;

public class SavingsAcc extends Account {

    //default
 public SavingsAcc(){}
    
    public SavingsAcc(double balance, User u) {
        super(balance, u);
    }

    @Override
    public String toString() {
        return "Savings Account of account holder:" + super.getCardNum();
    }

 

}
