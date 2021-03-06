package nccs.omts.repository;

import java.sql.*;
import java.util.*;
import nccs.omts.*;
import nccs.omts.model.*;

public class ScheduleRepository {
	public List<Schedule> getSchedule() throws SQLException{
		Connection connection = DBconnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * from schedule");
		List<Schedule> schedules=new ArrayList<>();
		
		while (rs.next()) {
			Schedule schedule = new Schedule(rs.getInt(1), rs.getString(2));
			schedules.add(schedule);
		}
		return schedules;
	}
}
