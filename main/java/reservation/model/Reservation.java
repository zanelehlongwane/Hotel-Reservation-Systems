/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservation.model;

/**
 *
 * @author user
 */




import java.time.LocalDate;

public class Reservation {
    private int resId;
    private int userId;
    private int hotelId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    //private Date reservationTime;
    private reservationStatus reservationStatus;
    private int diningOptionId;

    public int getDiningOptionId() {
        return diningOptionId;
    }

   

    public Reservation(int userId,int hotelId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, reservationStatus reservationStatus, int diningOptionId) {
        this.userId = userId;
        this.hotelId=hotelId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus = reservationStatus;
        this.diningOptionId = diningOptionId;
    }
    public Reservation(int userId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, int diningOptionId) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
       
        this.diningOptionId = diningOptionId;
    }
    
    
//(userId, roomId, checkInDate, checkOutDate, reservationStatus, diningOptionId
    public void setDiningOptionId(int diningOptionId) {
        this.diningOptionId = diningOptionId;
    }

    public Reservation() {
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

//    public Date getReservationTime() {
//        return reservationTime;
//    }
//
//    public void setReservationTime(Date reservationTime) {
//        this.reservationTime = reservationTime;
//    }

    
    public reservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(reservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

   
    
   
}
