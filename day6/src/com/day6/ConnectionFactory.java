package com.day6;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//loose coupling ==>properties file contain all database info
public class ConnectionFactory {

	  private ConnectionFactory() {
	    }

	 

	    private static Connection connection = null;

	 

	    public static Connection getConnection() {
	        Properties properties = new Properties();
	        InputStream is = null;
	        try {
	            is = new FileInputStream("db.properties");
	            properties.load(is);
	            
	        } catch (FileNotFoundException e1) {
	            e1.printStackTrace();
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        }
	        try {
	            Class.forName(properties.getProperty("jdbc.driver"));
	            System.out.println("Driver loaded");

	 

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        try {
	            String url=properties.getProperty("jdbc.url");
	            String username=properties.getProperty("jdbc.username");
	            String password=properties.getProperty("jdbc.password");
	            connection = DriverManager.getConnection(url,username,password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
}
