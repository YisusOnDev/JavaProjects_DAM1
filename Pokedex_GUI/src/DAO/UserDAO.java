package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	/**
	 * Method to get all users of the database.
	 * 
	 * @return Console Print with usernames with theirs password.
	 */
	public boolean showAllUsers() {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM users;")) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("Username") + "\t" + rs.getString("Password"));
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return false;
	}

	/**
	 * Check if a username already exist
	 * 
	 * @param username the username to check
	 * @return if exist or not (true or false)
	 */
	public boolean checkUsername(String username) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE username = '" + username + "'")) {

			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return false;
	}

	/**
	 * Method to register a user
	 * 
	 * @param username
	 * @param password
	 */
	public void registerUser(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " INSERT INTO users (Username, Password)" + " values (?, ?)";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, username);
			preparedStmt.setString(2, password);

			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Method that check if an user has permission to access admin panel
	 * 
	 * @param username
	 * @return true or false
	 */
	public boolean havePermission(String username) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT * FROM users WHERE Username = '" + username + "'" + " AND IsAdmin = '" + 1 + "'")) {

			return rs.next();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return false;
	}

}
