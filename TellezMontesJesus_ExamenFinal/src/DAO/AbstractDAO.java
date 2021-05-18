package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import io.Read;

public abstract class AbstractDAO {
	protected Connection conn;

	public AbstractDAO() {
		doConnection(getConnectionFromFile());
	}

	/**
	 * Method that creates the connection to the database with a prepared conn
	 * 
	 * @param conn db driver connection
	 */
	private void doConnection(Connection conn) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that get MySQL connection config from a config file.
	 */
	private static Connection getConnectionFromFile() {
		final String filename = "config.txt";
		Connection testCon = null;
		try {
			List<String> cfgDetails = Read.getSqlConfig(filename);
			String dbName = cfgDetails.get(0);
			String dbUser = cfgDetails.get(1);
			String dbPwd = "";

			// In some cases for test purposes MySQL installation has no password.
			if (2 < cfgDetails.size())
				dbPwd = cfgDetails.get(2);

			testCon = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, dbUser, dbPwd);
			System.out.println(testCon);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return testCon;
	}
}
