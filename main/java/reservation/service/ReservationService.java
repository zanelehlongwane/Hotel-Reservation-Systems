/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


package reservation.service;

import reservation.model.Reservation;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import reservation.dining.model.DiningOption;

public interface ReservationService {
    
    boolean createReservation(Reservation reservation) throws SQLException;
    List<Reservation> getReservationsByUserId(int userId) throws SQLException;
    List<DiningOption> getAllDiningOptions() throws SQLException;
    boolean cancelBooking(int userId) throws SQLException;
    boolean EditBooking(Reservation  reservation) throws SQLException;
    List<Reservation> getReservationByDate(LocalDate checkIn, LocalDate checkOut) throws SQLException;
    List<Reservation> getUpcomingBooking() throws SQLException ;
    List<Reservation>getHistory() throws SQLException;
    List<Reservation>getHistoryByUser(int userId) throws SQLException;
    List<Reservation>trackReservation(int userId) throws SQLException;
    List<Reservation> allRes() throws SQLException;
    
     
}

