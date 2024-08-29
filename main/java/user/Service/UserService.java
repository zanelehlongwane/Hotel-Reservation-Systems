/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package user.Service;


import user.Exception.EmailNotSentException;
import user.Exception.InvalidPasswordException;
import user.Exception.UserNotFoundException;
import user.model.User;

/**
 *
 * @author user
 */
public interface UserService  {
    
    
    
    User login(String email, String password) throws UserNotFoundException,InvalidPasswordException ;
    boolean register(User user) throws EmailNotSentException;
    //User aunthenticateUser(String email, String password) throws Exception;
    
}
