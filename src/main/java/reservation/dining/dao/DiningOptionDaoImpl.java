package reservation.dining.dao;

import reservation.dining.model.DiningOption;

import reservation.model.foodAvailability;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiningOptionDaoImpl implements DiningOptionDao {
    private String dbUser = "root";
    private String dbPassword = "Zahlo@5538";
    private String url = "jdbc:mysql://localhost:3306/hotel_system?useSSL=false";
    private Connection con;
    //private PreparedStatement prepStatements;
    //private ResultSet rs;
   
    public DiningOptionDaoImpl() {

        
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


    @Override
    public List<DiningOption> findAll() throws SQLException {
        List<DiningOption> diningOptions = new ArrayList<>();
        String sql = "SELECT * FROM dining_options";
        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DiningOption diningOption = new DiningOption();
                diningOption.setResId(rs.getInt("id"));
                diningOption.setHotelId(rs.getInt("hotel_id"));
                diningOption.setOptionName(rs.getString("option_name"));
                diningOption.setDescription(rs.getString("description"));
                diningOption.setPrice(rs.getDouble("price"));
                diningOption.setFoodAvalability(foodAvailability.valueOf(rs.getString("availability_status")));
                diningOptions.add(diningOption);
            }
        }
        return diningOptions;
    }
}
