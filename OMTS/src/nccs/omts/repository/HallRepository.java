package nccs.omts.repository;

import java.sql.*;
import java.util.*;

import nccs.omts.DBconnection;
import nccs.omts.model.Hall;


public class HallRepository {
	public List<Hall> getHall() throws SQLException{
		Connection connection = DBconnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from hall");
		List<Hall> halls=new ArrayList<>();
		
		while (rs.next()) {
			Hall hall = new Hall(rs.getInt(1), rs.getString(2), rs.getInt(3));
			halls.add(hall);
		}
		return halls;
	}
	
	public  void addTohall(int hall_id, String hall_name, int seats) throws SQLException {

        Connection connection = DBconnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO hall values(" + hall_id + ", " + hall_name + ", " + seats + ")");
    }
}
