package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import models.Usuario;

public class UsuarioDAO extends AbstractDAO {

	/**
	 * Constructor for UsuarioDAO
	 */
	public UsuarioDAO() {
		super();
	}

	/**
	 * Method that check if the username password and username exists
	 * 
	 * @param u Usuario
	 * @return true if exist, false if not
	 */
	public boolean login(Usuario u) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement stmt = this.conn
					.prepareStatement("select * from usuarios where username = ? and password = ?;");
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			var result = rs.next();
			conn.close();
			return result;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Method to insert a new username into the database
	 * 
	 * @param u Usuario
	 * @return true if has been inserted succesfully, false if not
	 */
	public boolean insert(Usuario u) {
		if (exists(u))
			return false;
		else {
			try {
				String query = " INSERT INTO usuarios (username, password)" + " values (?, ?)";

				PreparedStatement preparedStmt = this.conn.prepareStatement(query);
				preparedStmt.setString(1, u.getUsername());
				preparedStmt.setString(2, u.getPassword());

				preparedStmt.execute();

				conn.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return true;
		}
	}

	/**
	 * Method that checks if an username exist in the database
	 * 
	 * @param u Usuario
	 * @return true if exists, false if not
	 */
	private boolean exists(Usuario u) {
		try {
			Statement stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios WHERE username = '" + u.getUsername() + "'");
			return rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
