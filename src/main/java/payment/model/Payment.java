/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payment.model;

import java.math.BigDecimal;

/**
 *
 * @author user
 */
public class Payment {
    
    private String firstname;
    private String email;
    private String cardname;
    private String cardnumber;
    private String expmonth;
    private String expyear;
    private String cvv;
    private double amount;

    public Payment(String firstname, String email, String cardname, String cardnumber, String expmonth, String expyear, String cvv, double amount) {
        this.firstname = firstname;
        this.email = email;
        this.cardname = cardname;
        this.cardnumber = cardnumber;
        this.expmonth = expmonth;
        this.expyear = expyear;
        this.cvv = cvv;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getExpmonth() {
        return expmonth;
    }

    public void setExpmonth(String expmonth) {
        this.expmonth = expmonth;
    }

    public String getExpyear() {
        return expyear;
    }

    public void setExpyear(String expyear) {
        this.expyear = expyear;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

   
   
    
}
