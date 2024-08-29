/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package room.model;

/**
 *
 * @author user
 */


public class Room {
    private int id;
    private int hotelId;
    private String roomNumber;
    private RoomType roomType;
    private String description;
    private Double rate;
    private int occupancyLimit;
    private RoomStatus status;

    public Room() {
    }

    
    
    public Room(int id, RoomType roomType,String description, Double rate, int occupancyLimit, RoomStatus status,int hotelId) {
        this.id = id;
        this.roomType = roomType;
        this.description = description;
        this.rate = rate;
        this.occupancyLimit = occupancyLimit;
        this.status = status;
        this.hotelId=hotelId;
    }

   

    
    // Getters and setters
    
    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public int getOccupancyLimit() {
        return occupancyLimit;
    }

    public void setOccupancyLimit(int occupancyLimit) {
        this.occupancyLimit = occupancyLimit;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
