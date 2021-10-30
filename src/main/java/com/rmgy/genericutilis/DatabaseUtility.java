package com.rmgy.genericutilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 *  this class contains generic methods to access database
 * @author shubh
 *
 */
public class DatabaseUtility {
	Driver driverref;
	Connection con;
	ResultSet result;
	
	/**
	 * this method will get connection to database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(IpathConstants.DbUrl, IpathConstants.DbUsername, IpathConstants.DbPassword);
	}
	
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws SQLException {
		boolean flag = false;
		result = con.createStatement().executeQuery(query);
		while(result.next()) {
			String actData = result.getString(columnIndex);
			if(actData.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData + " data verified successfully");
			return expData;
		}
		else {
			System.out.println(expData + " data is not verified");
			return "";
		}
	}
	
	/**
	 * this method will close database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
}
