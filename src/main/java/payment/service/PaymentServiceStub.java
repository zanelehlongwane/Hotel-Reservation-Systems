
package payment.service;

import java.sql.SQLException;
import payment.dao.PaymentDao;
import payment.dao.PaymentDaoImpl;
import payment.model.Payment;


public class PaymentServiceStub implements PaymentService {

    
    private PaymentDao paymentDao;
    public PaymentServiceStub(PaymentDao paymentDao) {
        this.paymentDao= paymentDao;
        paymentDao = new PaymentDaoImpl();
    }
    
    
    
    
    @Override
    public boolean processPayment(Payment payment) throws SQLException {
        
       return paymentDao.insertPayment(payment);
    }

    
}
