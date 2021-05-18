package models;

public class Usuario {

	private String username;
	private String password;

	/**
	 * Constructor for Usuario
	 * 
	 * @param username Usuario username
	 * @param password Usuario password
	 */
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Method that returns the user username
	 * 
	 * @return user username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Method that returns the user password
	 * 
	 * @return user password
	 */
	public String getPassword() {
		return password;
	}

}
