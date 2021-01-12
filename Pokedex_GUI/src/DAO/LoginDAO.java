package DAO;

import java.sql.*;

public class LoginDAO {
	/**
	 * Method that search the received username and password on the database return
	 * true if exist and is correct, false if is incorrect or not exist
	 * 
	 * @param username the username that user typed
	 * @param password the password that user typed
	 * @return boolean true or falses
	 */
	public boolean login(String username, String password) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE Username = '" + username + "'"
						+ " AND Password = '" + password + "'")) {

			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return false;
	}
}
