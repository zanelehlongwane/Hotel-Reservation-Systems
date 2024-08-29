package reservation.dining.dao;

import reservation.dining.model.DiningOption;


import java.sql.SQLException;
import java.util.List;

public interface DiningOptionDao {
    List<DiningOption> findAll() throws SQLException;
}
