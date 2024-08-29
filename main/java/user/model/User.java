/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.model;


/**
 *
 * @author user
 */
public class User {
 
    
    private int id;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;

    public User() {
    }

    
    public User(int id, String userName, String email, String password, String phoneNumber, Role role) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User(String userName, String email, String password, String phoneNumber, Role role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

   

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    

    public Role getRole() {
        return role;
    }

    
   
    public int getId() {
        
        return id;
    }

    
    public String getUserName() {
        
        return userName;
    }

    
    public String getPasssword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
        
   


    
}
