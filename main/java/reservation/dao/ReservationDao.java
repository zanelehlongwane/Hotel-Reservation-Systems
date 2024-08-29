/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reservation.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import reservation.model.Reservation;

/**
 *
 * @author user
 */
public interface ReservationDao {
    
    boolean saveReservation(Reservation reservation) throws SQLException;
    List<Reservation> findReservationsByUserId(int userId) throws SQLException;
    boolean cancelReservation(int userId) throws SQLException;
    boolean updateReservation(Reservation reservation) throws SQLException;
    List<Reservation> getReservationsByDateRange(LocalDate checkInDate, LocalDate checkOutDate) throws SQLException;
    List<Reservation> upComingReservations() throws SQLException;
    List<Reservation> reservationsHistory() throws SQLException;
    List<Reservation> reservationsHistoryById(int userId) throws SQLException;
    List<Reservation> upComingReservationsById(int userId) throws SQLException;
    List<Reservation> allReservation() throws SQLException;
    
}
