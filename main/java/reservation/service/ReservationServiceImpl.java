package reservation.service;

import reservation.dining.dao.DiningOptionDao;
import reservation.dao.ReservationDao;
import reservation.model.Reservation;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import reservation.dining.model.DiningOption;
import reservation.dao.ReservationDaoImpl;
import reservation.dining.dao.DiningOptionDaoImpl;

public class ReservationServiceImpl implements ReservationService {
    
    private final DiningOptionDao diningOptionDao;
    private final ReservationDao  reservationDao;
    
    //private final ReservationDaoImpl rs = new ReservationDaoImpl();

    public ReservationServiceImpl(ReservationDao reservationDao,DiningOptionDao diningOptionDao) {
        this.reservationDao = reservationDao;
        reservationDao = new ReservationDaoImpl();
        
       diningOptionDao = new DiningOptionDaoImpl();
       this.diningOptionDao = diningOptionDao;
    }

    @Override
    public boolean createReservation(Reservation reservation) throws SQLException {
        return reservationDao.saveReservation(reservation);
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) throws SQLException {
        return reservationDao.findReservationsByUserId(userId);
    }

    

    @Override
    public List<DiningOption> getAllDiningOptions() throws SQLException {
        return diningOptionDao.findAll();
    }

    @Override
    public boolean cancelBooking(int userId) throws SQLException {
        
        return reservationDao.cancelReservation(userId);
    }
    @Override
    public boolean EditBooking(Reservation reservation) throws SQLException {
        
        return reservationDao.updateReservation(reservation);
    }
    

    @Override
    public List<Reservation> getReservationByDate(LocalDate checkIn, LocalDate checkOut) throws SQLException {
        
     return reservationDao.getReservationsByDateRange(checkIn, checkOut);
    }

    @Override
    public List<Reservation> getUpcomingBooking() throws SQLException {
        
        
        
        
     return reservationDao.upComingReservations();
    }

    @Override
    public List<Reservation> getHistory() throws SQLException {
        
       return reservationDao.reservationsHistory();
    }

    @Override
    public List<Reservation> trackReservation(int userId) throws SQLException {
     
         return reservationDao.upComingReservationsById(userId);
    }

    @Override
    public List<Reservation> allRes() throws SQLException {
        
       return reservationDao.allReservation();
    }

    @Override
    public List<Reservation> getHistoryByUser(int userId) throws SQLException {
        
        return reservationDao.reservationsHistoryById(userId);
    }
    
}
