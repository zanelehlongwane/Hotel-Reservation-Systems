/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payment.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import payment.model.Payment;

/**
 *
 * @author user
 */
public class PaymentDaoImpl implements PaymentDao {
    
    private String dbUser = "root";
    private String dbPassword = "Zahlo@5538";
    private String url = "jdbc:mysql://localhost:3306/hotel_system?useSSL=false";
    private Connection con;

    public PaymentDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded...");
        } catch (ClassNotFoundException ex) {
            System.out.println("Couldn't load driver");
        }
        try {
            con = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (SQLException ex) {
            System.out.println("Connection failed");
        }
    }

    @Override
    public boolean insertPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (firstname,email, cardname, cardnumber, expmonth, expyear, cvv,price) VALUES (?, ?, ?, ?, ?, ?,?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
        preparedStatement.setString(1, payment.getFirstname());
        preparedStatement.setString(2, payment.getEmail());
        preparedStatement.setString(3, payment.getCardname());
        preparedStatement.setString(4, payment.getCardnumber());
        preparedStatement.setString(5, payment.getExpmonth());
        preparedStatement.setString(6, payment.getExpyear());
        preparedStatement.setString(7, payment.getCvv());
        preparedStatement.setDouble(8, payment.getAmount()); // Set the amount parameter

         
        return preparedStatement.executeUpdate()>0;
    }
        
    }}        
