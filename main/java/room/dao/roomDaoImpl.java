package room.dao;

import room.model.Room;
import room.model.RoomType;
import java.sql.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import reservation.model.Reservation;
import reservation.model.reservationStatus;
import room.model.RoomStatus;

public class roomDaoImpl implements roomDao {
    private final String dbUser = "root";
    private final String dbPassword = "Zahlo@5538";
    private final String url = "jdbc:mysql://localhost:3306/hotel_system?useSSL=false";
    private Connection con;
    private Room room;
    //private ResultSet resultSet;

    public roomDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

   

    @Override
    public List<Room> findAvailableRooms(LocalDate checkInDate,LocalDate checkOutDate, RoomType roomType, int numPeople) throws SQLException {
        List<Room> rooms = new ArrayList<>();
        String query = "SELECT * FROM rooms WHERE room_type = ? OR occupancylimit >= ? AND availability_status = 'available' AND id NOT IN "
                + "(SELECT room_Id FROM reservations WHERE check_In_Date < ? AND check_out_Date > ?  AND status !='canceled' )";

        Date CheckInDate =Date.valueOf(checkInDate);
        Date CheckOutDate = Date.valueOf(checkOutDate);
        
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setObject(1, roomType.toString());
            preparedStatement.setInt(2, numPeople);
            preparedStatement.setDate(3,  CheckInDate);
            preparedStatement.setDate(4,  CheckOutDate);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                
//                room.setId(rs.getInt("id"));
//                room.setRoomType(roomTypes.valueOf(rs.getString("room_type")));
//                room.setRate(rs.getDouble("price_per_night"));
//                room.setOccupancyLimit(rs.getInt("occupancylimit"));
//                room.setStatus(roomAvailability.valueOf(rs.getString("availability_status")));
//                room.setDescription(rs.getString("description"));

                 int id = rs.getInt("id");
                 
                 roomType = RoomType.valueOf(rs.getString("room_type"));
                 double rate = rs.getDouble("price_per_night");
                 numPeople = rs.getInt("occupancylimit");
                 RoomStatus roomAvail =RoomStatus.valueOf(rs.getString("availability_status"));
                 int hotelId = rs.getInt("hotel_id");
                 String description = rs.getString("Description");
                 
                 
                room = new Room(id, roomType,description, rate,numPeople, roomAvail, hotelId);
                rooms.add(room);

                
            }
        }

        return rooms;
    }

    @Override
    public List<Reservation> findReservationsByroomId(int roomId) throws SQLException {
       
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE room_Id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, roomId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(rs.getInt("user_Id"));
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(roomId);
                Date checkInDate = rs.getDate("check_In_Date");
                    if (checkInDate != null) {
                        reservation.setCheckInDate(checkInDate.toLocalDate());
                    }

                    Date checkOutDate = rs.getDate("check_out_Date");
                    if (checkOutDate != null) {
                        reservation.setCheckOutDate(checkOutDate.toLocalDate());
                    }
                    
                //reservation.setReservationTime(rs.getTimestamp("reservation_time"));
                reservation.setReservationStatus(reservationStatus.valueOf(rs.getString("status"))); // Assuming reservationStatus is an enum
                reservation.setDiningOptionId(rs.getInt("dinning_option_id"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }
        
    
    
    
   
        
  
}
