package reservation.dao;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import reservation.model.Reservation;
import reservation.model.reservationStatus;

public class ReservationDaoImpl implements ReservationDao {
    private String dbUser = "root";
    private String dbPassword = "Zahlo@5538";
    private String url = "jdbc:mysql://localhost:3306/hotel_system?useSSL=false";
    private Connection con;
    private ResultSet rs;

    public ReservationDaoImpl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Loaded...");
        } catch (ClassNotFoundException ex) {
            System.out.println("Couldn't load driver");
        }
        try {
            con = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (SQLException ex) {
            System.out.println("Connection failed");
        }
    }

    
    
    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(rs.getInt("user_Id"));
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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
                
        // Map other fields as needed
        return reservation;
    }
    
    //both
    @Override
    public boolean saveReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservations (user_Id, hotel_Id, room_Id, check_In_Date, check_out_Date, status, dinning_option_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prepareStatement = con.prepareStatement(sql)) {
            prepareStatement.setInt(1, reservation.getUserId());
            prepareStatement.setInt(2, reservation.getHotelId());
            prepareStatement.setInt(3, reservation.getRoomId());
            prepareStatement.setDate(4, Date.valueOf(reservation.getCheckInDate()));
            prepareStatement.setDate(5, Date.valueOf(reservation.getCheckOutDate()));
            prepareStatement.setString(6, reservation.getReservationStatus().name().toLowerCase()); // Assuming reservationStatus is an enum
            prepareStatement.setInt(7, reservation.getDiningOptionId());
            
            return prepareStatement.executeUpdate()>0;
        }
    }

    //both
    @Override
    public List<Reservation> findReservationsByUserId(int userId) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE user_Id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(userId);
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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

    
    //Admin and guest roles
    @Override
    public boolean cancelReservation(int userId) throws SQLException{
        
        String sql = "UPDATE reservations SET status = 'canceled' where user_Id =?";
        
        try(PreparedStatement statement = con.prepareStatement(sql)){
            
            statement.setInt(1, userId);
            
            return statement.executeUpdate()>0;
        }
        
    }
    
    //Admin roles
    @Override
     public boolean updateReservation(Reservation reservation) throws SQLException {
        String sql = "UPDATE reservations SET user_Id = ?, room_Id = ?, check_In_Date = ?, check_out_Date = ?, "
                   + "status = ?, dinning_option_id = ? WHERE ID = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, reservation.getUserId());
            statement.setInt(2, reservation.getRoomId());
            statement.setDate(3, Date.valueOf(reservation.getCheckInDate()));
            statement.setDate(4, Date.valueOf(reservation.getCheckOutDate()));
            statement.setString(5, reservation.getReservationStatus().toString());
            statement.setInt(6, reservation.getDiningOptionId());
            statement.setInt(7, reservation.getResId());
            
            
           return  statement.executeUpdate()>0;
        }
    }
     
     //Both admin and guest
      @Override
    public List<Reservation> getReservationsByDateRange(LocalDate checkInDate, LocalDate checkOutDate) throws SQLException {
           List<Reservation> reservations = new ArrayList<>();
           String sql = "SELECT * FROM reservations WHERE check_In_Date=? AND check_out_Date = ?";
           try (PreparedStatement statement = con.prepareStatement(sql)) {
               statement.setDate(1,Date.valueOf(checkInDate));
               statement.setDate(1,Date.valueOf(checkInDate));
               ResultSet resultSet = statement.executeQuery();
               while (resultSet.next()) {
                   Reservation reservation = mapResultSetToReservation(resultSet);
                   reservations.add(reservation);
               }
           }
           return reservations;
       }

    @Override
    public List<Reservation> upComingReservations() throws SQLException {
        
        
           List<Reservation> reservations = new ArrayList<>();
           String sql = "SELECT * FROM reservations WHERE check_In_Date >=Now()";
           try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(rs.getInt("user_Id"));
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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
    
    @Override
    public List<Reservation> reservationsHistory() throws SQLException {
        
        
    List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE  check_out_Date<Now()";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(rs.getInt("user_Id"));
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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

    @Override
    public List<Reservation> upComingReservationsById(int userId) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE user_Id = ? And check_In_Date>Now()";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(userId);
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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
    
    
    @Override
    public List<Reservation> allReservation() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations ";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(rs.getInt("user_Id"));
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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

    @Override
    public List<Reservation> reservationsHistoryById(int userId) throws SQLException {
        
        
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE user_Id = ? And check_out_Date<Now()";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("ID"));
                reservation.setUserId(userId);
                reservation.setHotelId(rs.getInt("hotel_Id"));
                reservation.setRoomId(rs.getInt("room_Id"));
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

    
    


        