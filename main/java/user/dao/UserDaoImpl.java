/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.Exception.UserNotFoundException;
import user.model.Role;
import user.model.User;

/**
 *
 * @author user
 */
public class UserDaoImpl implements userDao {

    private String dbUser = "root";
    private String dbPassword = "Zahlo@5538";
    private String url = "jdbc:mysql://localhost:3306/hotel_system?useSSL=false";
    private Connection con;
    private PreparedStatement prepStatements;
   // private ResultSet resultSet;
   
    public UserDaoImpl() {

        
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
    public boolean createUser(User user) {
        
    try {
        String sql = "INSERT INTO users (username, email, password, phone_number, role) VALUES (?, ?, ?, ?, ?)";
    
        prepStatements = con.prepareStatement(sql);
            
        prepStatements.setString(1, user.getUserName());
        prepStatements.setString(2, user.getEmail());
        prepStatements.setString(3, user.getPassword());
        prepStatements.setString(4, user.getPhoneNumber());
        prepStatements.setObject(5, user.getRole().toString()); // Assuming role is stored as a string
        
        return prepStatements.executeUpdate()>0;
              
        
        } catch (SQLException e) {
            throw new RuntimeException("Failed to add user: " + e.getMessage(), e);
        }
    }

    @Override
    public User getUserByEmail(String email)throws UserNotFoundException {

        String sql = "SELECT id, username, email, password, phone_number, role FROM users WHERE email=?";

        try (PreparedStatement prepStatement = con.prepareStatement(sql)) {
            prepStatement.setString(1, email);
            try (ResultSet resultSet = prepStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String phoneNumber = resultSet.getString("phone_number");
                    String password = resultSet.getString("password"); // Ensure password is retrieved if needed
                    Role role = Role.valueOf(resultSet.getString("role"));

                    return new User(id, username, email, password, phoneNumber, role);
                } else {
                    throw new UserNotFoundException("User not found with email: " + email);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get user by email: " + email, e);
        }

    }

}
