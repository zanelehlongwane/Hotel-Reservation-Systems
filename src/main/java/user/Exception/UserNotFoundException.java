/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.Exception;

/**
 *
 * @author user
 */
public class UserNotFoundException extends Exception {
    
     public UserNotFoundException(String msg) {
         super(msg);
    }

    public UserNotFoundException() {
        this("User not found");
    }
    
    
    
    
}
