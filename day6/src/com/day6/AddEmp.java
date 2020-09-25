package com.day6;

import java.sql.*;

public class AddEmp {
	public static void main(String[] args) {
		// Loading the driver
		Connection connection = null;
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kr_demo?useSSL=false", "root",
                    //"root");
            connection = ConnectionFactory.getConnection();
			System.out.println("Connection established with database.");
			PreparedStatement psmt = connection
					.prepareStatement("insert into emp(name,dept,phone,salary) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, "Sunil");
			psmt.setString(2, "Marketing");
			psmt.setString(3, "10101010");
			psmt.setDouble(4, 15000.0);
			int rowsAffected = psmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
            if (rowsAffected > 0) {
                ResultSet rs = psmt.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
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
		}
	}
}
