package nccs.omts.repository;

import java.sql.*;
import java.util.*;
import nccs.omts.*;
import nccs.omts.model.*;

public class ShowRepository {
	public List<Shows> getShows() throws SQLException{
		Connection connection = DBconnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from shows");
		List<Shows> show1=new ArrayList<>();
		
		while (rs.next()) {
			Shows show = new Shows(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getInt(4));
			show1.add(show);
		}
		return show1;
	}
	public void addToShows(int show_id,int hall_id,int movie_id,int schedule_id) throws SQLException {
		Connection connection =DBconnection.getConnection();
		Statement statement =connection.createStatement();
		statement.executeUpdate("INSERT INTO shows values(" + show_id +"," + hall_id + "," + movie_id + "," + schedule_id +")");
	}
}
