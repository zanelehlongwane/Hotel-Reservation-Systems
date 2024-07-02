package room.dao;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import reservation.model.Reservation;
import room.model.Room;
import room.model.RoomType;

public interface roomDao {
    public abstract List<Room> findAvailableRooms(LocalDate checkInDate,LocalDate checkOutDate, RoomType roomType, int numPeople) throws SQLException ;
      
  List<Reservation> findReservationsByroomId(int roomId) throws SQLException;
    
    
}
