package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection DBConnect = null;
	public static final String DBURL= "jdbc:mysql://localhost/Rec_Center_Mgmt_System?";
	public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    private static Connection connect = null;

    private DBConnection() {
    	if (connect == null) {
    		try {
        		connect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
        	} catch (SQLException ex) {
        		throw new RuntimeException("Error connecting to the database", ex);
        	}
    	}
    }
    
    public static DBConnection getConnectionFactoryInstance() {
    	if(DBConnect == null) {
    		DBConnect = new DBConnection();
    	}
    	return DBConnect;
    }
    // method to create MySQL connection
    public Connection getConnection() {
    	return connect;
    }
}