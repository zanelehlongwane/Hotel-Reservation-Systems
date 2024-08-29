/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package payment.service;

import java.sql.SQLException;
import payment.model.Payment;

/**
 *
 * @author user
**/
public interface PaymentService {
    
boolean processPayment(Payment payment) throws SQLException;
}