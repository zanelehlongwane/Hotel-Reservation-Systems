/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package room.service;

/**
 *
 * @author user
 * */



import java.sql.SQLException;
import java.time.LocalDate;


import java.util.List;
import reservation.dao.ReservationDao;
import reservation.dao.ReservationDaoImpl;
import reservation.model.Reservation;
import room.dao.roomDao;
import room.dao.roomDaoImpl;

import room.model.Room;
import room.model.RoomStatus;
import room.model.RoomType;

public class RoomServiceImpl implements RoomService {
    private final roomDao roomDao;
    private ReservationDao reservationDao = new ReservationDaoImpl();
    private Room room = new Room();
   
    
    public RoomServiceImpl(roomDao roomDao) {
        roomDao = new roomDaoImpl();
        this.roomDao = roomDao;
    }
    

//    @Override
//    public List<Room> getAvailableRooms(LocalDate checkInDate,LocalDate checkOutDate, RoomType roomType, int numPeople) throws SQLException {
//        
//        
//        
//        if(room.getId()==reservation.getRoomId() && checkInDate ==reservation.getCheckInDate() && checkOutDate==reservation.getCheckOutDate()){
//            
//            RoomStatus status = RoomStatus.OCUPIED;
//            
//        }
//        
//        
//        return roomDao.findAvailableRooms(checkInDate, checkOutDate, roomType, numPeople);
//    }
    
   @Override
public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, RoomType roomType, int numPeople) throws SQLException {
    // Validate input parameters
    if (checkInDate == null || checkOutDate == null) {
        throw new IllegalArgumentException("Check-in and check-out dates cannot be null");
    }

    // Assuming roomDao.findAvailableRooms returns a list of rooms that meet the criteria
    List<Room> availableRooms = roomDao.findAvailableRooms(checkInDate, checkOutDate, roomType, numPeople);

//    for (Room room : availableRooms) {
//        // Assuming roomDao.getReservationByRoomId retrieves a list of reservations for a given room ID
//        List<Reservation> reservations = roomDao.findReservationsByroomId(room.getId());
//        boolean isOccupied = false;
//        
//        for (Reservation reservation : reservations) {
//            if (reservation != null 
//                && reservation.getCheckInDate() != null 
//                && reservation.getCheckOutDate() != null 
//                && !(checkInDate.isAfter(reservation.getCheckOutDate()) || checkOutDate.isBefore(reservation.getCheckInDate()))) {
//                
//                // If there is an overlap, mark the room as occupied
//                isOccupied = true;
//                break;
//            }
//        }
//        
//        if (isOccupied) {
//            room.setStatus(RoomStatus.OCUPIED);
//        }
//    }
//
//    // Filter out rooms that are marked as OCCUPIED
//    availableRooms.removeIf(room -> room.getStatus() == RoomStatus.OCUPIED);

    return availableRooms;
}


    
}
