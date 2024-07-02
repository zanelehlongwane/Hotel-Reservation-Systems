/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package user.dao;



import user.Exception.UserNotFoundException;
import user.model.User;

/**
 *
 * @author user
 */
public interface userDao {
    
    
    User getUserByEmail(String email) throws UserNotFoundException;
    
    boolean createUser(User user);
    
    
    
}
