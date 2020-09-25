/**
 * 
 */
package com.day6;
import java.sql.*;
/**
 * @author shikha.jadon
 *
 */
public class TxMgt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection=ConnectionFactory.getConnection();
		
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt=connection.prepareStatement
					("update account set bal=bal-10 where id=?");
			pstmt.setInt(1,1);
			pstmt.executeUpdate();
			
			pstmt=connection.prepareStatement
					("update account set bal=bal+10 where id=?");
			pstmt.setInt(1,2);
			pstmt.executeUpdate();
			
			System.out.println("fund tra");
			connection.commit();
		}
		catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
