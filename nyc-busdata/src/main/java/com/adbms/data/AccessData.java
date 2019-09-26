package com.adbms.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.adbms.dto.Student;
import com.adbms.dto.Transport;
import com.mysql.cj.jdbc.MysqlDataSource;

public class AccessData {
		
	public static DataSource getMysqlDataSource() throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		
		dataSource.setServerName("127.0.0.1");
		//dataSource.setServerName("172.12.106.242");
		dataSource.setPortNumber(3306);
		dataSource.setDatabaseName("transport");
		dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerTimezone("UTC");
		return dataSource;
	}
	
	public List<Student> getAllStudents(){
		
		try {
			Connection con = getMysqlDataSource().getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("select * from students");
			
			List<Student> students = new ArrayList<Student>();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setUin(resultSet.getString("uin"));
				student.setName(resultSet.getString("name"));

				students.add(student);
			}
			
			return students;
			
		} catch(Exception exe) {
			exe.printStackTrace();
		}
		
		List<Student> students = new ArrayList<Student>();
				
		return students;
		
	}
	
	
	public static String returnData() {
		try {
			Connection con = getMysqlDataSource().getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("select * from students");
			
			String data = "";
			while (resultSet.next()) {
				data = data + "" + resultSet.getString("uin") + ", " + resultSet.getString("name");
			}
			
			return data;
			
		} catch(Exception exe) {
			exe.printStackTrace();
		}
		
		return "Howdy!";
	}

	public List<Student> getStudentDetails(String uin) {
			
		try {
			Connection con = getMysqlDataSource().getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("select * from students where uin = '" + uin + "'");
			
			List<Student> students = new ArrayList<Student>();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setUin(resultSet.getString("uin"));
				student.setName(resultSet.getString("name"));

				students.add(student);
			}
			
			return students;
			
		} catch(Exception exe) {
			exe.printStackTrace();
		}
		
		List<Student> students = new ArrayList<Student>();
				
		return students;
		
	}
	
	public List<Transport> getTrasnportDetails(){
		try {
			Connection con = getMysqlDataSource().getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet resultSet = stmt.executeQuery("select * from new_york_city_bus");
			
			List<Transport> transportDetails = new ArrayList<Transport>();
			
			while (resultSet.next()) {
				Transport transport = new Transport();
				transport.setOriginName(resultSet.getString("OriginName"));
				transport.setDestinationName(resultSet.getString("DestinationName"));
				transport.setNextStopPointName(resultSet.getString("NextStopPointName"));
				transport.setExpectedArrivalTime(resultSet.getString("ExpectedArrivalTime"));
				transport.setScheduledArrivalTime(resultSet.getString("ScheduledArrivalTime"));
				
				transportDetails.add(transport);
			}
			
			return transportDetails;
			
		} catch(Exception exe) {
			exe.printStackTrace();
		}
		
		List<Transport> transportDetails = new ArrayList<Transport>();
		return transportDetails;
	}
		
}
