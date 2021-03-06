package nccs.omts.repository;

import java.sql.*;
import java.util.*;
import nccs.omts.*;
import nccs.omts.model.*;

public class TicketRepository {
	public List<Tickets> getTicket() throws SQLException{
		Connection connection = DBconnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from tickets");
		List<Tickets> tickets=new ArrayList<>();
		
		while (rs.next()) {
			Tickets ticket = new Tickets(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			tickets.add(ticket);
		}
		return tickets;
	}

	public void addToTicket(int ticket_id,int no_of_tickets,int price)throws SQLException{
		Connection connection=DBconnection.getConnection();
		Statement statement=connection.createStatement();
		statement.executeUpdate("INSERT INTO ticket values("+ticket_id+","+no_of_tickets+","+price+")");
	}
}
