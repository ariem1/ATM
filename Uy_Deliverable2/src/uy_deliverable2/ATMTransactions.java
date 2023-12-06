/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uy_deliverable2;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *Represents an ATM transaction with associated details.
 * This class is used to store information regarding the ATM's transactions.
 * @author grech
 */
public class ATMTransactions {

    //in the json properties
    @JsonProperty
    private String transaction;
    @JsonProperty
    private String accNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public ATMTransactions() {

        this.transaction = "";
        this.accNumber = "";

    }

    public ATMTransactions(String transaction, String accNumber,
            Date date
    ) {

        this.transaction = transaction;
        this.accNumber = accNumber;
        this.date = date;
        //   this.amountWithdrawn = amountWithdrawn;

    }

}
