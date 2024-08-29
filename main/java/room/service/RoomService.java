/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package room.service;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import room.model.Room;
import room.model.RoomType;

/**
 *
 * @author user
 */
public interface RoomService {
    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate,RoomType roomType,int numPeople) throws SQLException;
    
}
