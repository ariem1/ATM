/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author grech
 */
public class InvalidLogInException extends Exception {

    private String msg;

    public InvalidLogInException(String msg) {
        super(msg);
    }

}
