package user.Controller;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import user.Exception.EmailNotSentException;
import user.Exception.InvalidPasswordException;
import user.Exception.UserNotFoundException;
import user.model.Role;
import user.model.User;
import user.Service.UserService;
import user.Service.UserServiceImpl;
import user.dao.UserDaoImpl;
import user.model.EmailSender;


/**
 *
 * @author user
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    
    private UserService userService;
     private EmailSender emailSender;
   
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        //User user = new User();
        userService = new UserServiceImpl(new UserDaoImpl());
        
      
        switch (request.getParameter("submit")) {
            
            case "login":
                
                try {
                    
                 User  user = userService.login(request.getParameter("email"), request.getParameter("password"));
                 //put in a session
                  // Example of setting user object in session after successful login
                   

                     // loggedInUser is your User object
                     
                    HttpSession  session = request.getSession(true);
                    session.setAttribute("user", user);
                   
                    
                    Role role = Role.ADMIN;
                    //Role.ADMIN;
                    
                    
                    if (role.equals(user.getRole())) {
                        
                        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
                        
                    } else {
                        
                        request.setAttribute("message", "Welcome to Luxury Leisure Hotel");
                        request.getRequestDispatcher("userDashboard.jsp").forward(request, response);
                        
                    }
                    session.setAttribute("user_id", user.getId());
            
             
                    
                    
                     
                } catch (UserNotFoundException | InvalidPasswordException ex) {
                    
                    request.setAttribute("message", "You have entered wrong password or email");
                       request.getRequestDispatcher("Login.jsp").forward(request, response);
                   
                }
                
                break;
            
            case "Register":
                
                
//                Role role = Role.valueOf(request.getParameter("role"));
                String username = request.getParameter("username");
                String phoneNumber = request.getParameter("phone_number");
                String password =  request.getParameter("password");
                String email = request.getParameter("email");
                
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                

                User user=new User(username, email, hashedPassword, phoneNumber,Role.GUEST);
            {
                try {
                    if(userService.register(user)){
                        emailSender = new EmailSender();
                        String subject ="Registration confirmation at Luxury Leisure Hotel";
                        String body = "Dear "+user.getUserName()+",\n\n" +"Thank you for registering with us.\n" +"Please use your email and password to login\n\nEmail : "+user.getEmail()+"\n\nRegards\nLuxury Leisure Hotel(LLH)";
                        emailSender.sendRegistrationEmail(email,subject,body);
                        request.setAttribute("message", username +" you have Succesfully registered please LogIn");
                        request.getRequestDispatcher("Login.jsp").forward(request, response);
                    }else{
                        request.setAttribute("message", "Couldn't register");
                        request.getRequestDispatcher("Register.jsp").forward(request, response);
                    }
                } catch (EmailNotSentException ex) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               
                
                break;

                
             case "back":
                    
                    //request.setAttribute("user", user);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
             
        }
        
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}