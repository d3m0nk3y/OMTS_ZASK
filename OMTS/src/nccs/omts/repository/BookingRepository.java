package nccs.omts.repository;

import java.sql.*;
import java.util.*;
import nccs.omts.*;
import nccs.omts.model.*;

public class BookingRepository {
	public List<Booking> getBooking() throws SQLException{
		Connection connection= DBconnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from booking");
		List<Booking> bookings=new ArrayList<>();
		
		while (rs.next()){
			Booking booking=new Booking(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			bookings.add(booking);
		}
		return bookings;
		
	}
		
	public void addToBooking(int booking_id, int show_id, int customer_id) throws SQLException{
			
		Connection connection= DBconnection.getConnection();
		Statement statement= connection.createStatement();
		statement.executeUpdate("Insert into booking("+ booking_id+"," + show_id +"," +customer_id+ ")");
	}
}
