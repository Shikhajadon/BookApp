package com.day6;
import java.sql.*;
public class UpdateEmp {
	public static void main(String[] args) {
        // Loading the driver
		
		// simple  factory design pattern to hide the connection
		
       /*try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        // Connection is used to interact with database
        Connection connection = null;
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kr_demo?useSSL=false", "root",
                    //"root");
            connection = ConnectionFactory.getConnection();
            System.out.println("Connection established with database.");
            PreparedStatement psmt = connection.prepareStatement("update emp set salary = ? where id = ?");

 

            psmt.setDouble(1, 30000);
            psmt.setInt(2, 1);
            System.out.println("Rows affected: " + psmt.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
