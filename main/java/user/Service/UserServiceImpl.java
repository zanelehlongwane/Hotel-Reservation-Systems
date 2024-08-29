/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package user.Service;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
//import at.favre.lib.crypto.bcrypt.BCrypt;
import user.Exception.InvalidPasswordException;
import user.Exception.UserNotFoundException;
import user.dao.UserDaoImpl;
import user.dao.userDao;
import user.model.User;


/**
 *
 * @author user
 */
public class UserServiceImpl implements UserService {

   
    private final userDao userDao  ;

    public UserServiceImpl(userDao userDao) {
        userDao = new UserDaoImpl();
        this.userDao = userDao;
        
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException,InvalidPasswordException {

          User user = userDao.getUserByEmail(email);
          
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            } else {
                throw new InvalidPasswordException("Incorrect password");
            }
        }
        throw new UserNotFoundException("User not found");
    }

    

    
    
    

    @Override
    public boolean register(User user) {
        
       String email =user.getEmail();
        try {
            if (userDao.getUserByEmail(email) != null) {
                
                throw new RuntimeException("User already exists with this email");
            }
        } catch (UserNotFoundException ex) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userDao.createUser(user);
    }

}
