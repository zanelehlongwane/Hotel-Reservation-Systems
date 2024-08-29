package payment.controller;

import payment.service.PaymentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import payment.dao.PaymentDaoImpl;
import payment.model.Payment;
import payment.service.PaymentServiceStub;
import user.model.EmailSender;
import user.model.User;

@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
    
    private PaymentService paymentService = new PaymentServiceStub(new PaymentDaoImpl());
    private EmailSender emailSender;
    
   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String firstname = request.getParameter("firstname");
        String email = request.getParameter("email");
        String cardname = request.getParameter("cardname");
        String cardnumber = request.getParameter("cardnumber");
        String expmonth = request.getParameter("expmonth");
        String expyear = request.getParameter("expyear");
        String cvv = request.getParameter("cvv");
        double amount = Double.parseDouble(request.getParameter("amount"));
        Payment payment = new Payment(firstname,email,cardname,cardnumber,expmonth,expyear,cvv,amount);
        User user = new User();
        
        
        try {
            if (paymentService.processPayment(payment)) {
                HttpSession session = request.getSession(false);
                User users =(User)session.getAttribute("user");
                // Generate invoice and send confirmation email (omitted for brevity)
                request.setAttribute("paymentStatus", "success");
                request.setAttribute("message", "Payment was successful!");
                emailSender = new EmailSender();
                String emai = email;
                String subject = "Reservation Payment Confirmation ";
                String body = "Dear "+users.getUserName()+",\nWe are delighted to confirm your reservation at Luxury Leisure Hotel.\n Below are the details of your booking:\n" +
                        "\n" +"We look forward to welcoming you and ensuring you have a memorable stay.\n Thank you for choosing us!\n\nRegards\nLuxury Leisure Hotel";
                
                emailSender.sendRegistrationEmail(emai,subject,body);
            } else {
                request.setAttribute("paymentStatus", "failure");
                request.setAttribute("message", "Payment failed. Please try again.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("paymentConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
