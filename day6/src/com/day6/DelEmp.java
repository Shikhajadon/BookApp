package com.day6;
import java.sql.*;
public class DelEmp {
  public static void main(String[] args) {
	  // Loading the driver
	  Connection connection = null;
      try {
          //connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kr_demo?useSSL=false", "root",
                  //"root");
          connection = ConnectionFactory.getConnection();
          System.out.println("Connection established with database.");
          
          // want to del a emp of id=1;
          
          PreparedStatement psmt = connection
                  .prepareStatement("delete from emp where id=?");
          psmt.setInt(1,3);
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
