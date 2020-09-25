package com.day6;

import java.sql.*;

public class ShowAll {

	public static void main(String[] args) {
		// Loading the driver
		Connection connection = null;
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kr_demo?useSSL=false", "root",
                    //"root");
            connection = ConnectionFactory.getConnection();
            System.out.println("Connection established with database.");
            Statement stmt=connection.createStatement();
            ResultSet resultSet=stmt.executeQuery("select * from emp");
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1)+":"+resultSet.getString(2)+":"+resultSet.getString(3)+":"+resultSet.getString(4)+":"+resultSet.getDouble(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }	}

}
