package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Usuario;

public class UsuarioDAO {
	public static boolean login(Usuario u) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = getConnectionFromFile();
			
			PreparedStatement stmt = con.prepareStatement("select * from usuarios where username = ? and password = ?;");
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			ResultSet rs = stmt.executeQuery();
			var result = rs.next();
			con.close();
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public static boolean insert(Usuario u) {
		if(exists(u)) return false;
		else {
			//TODO hacer que inserte el usuario.
			return true;
		}
	}
	
	private static boolean exists(Usuario u) {
		try {
			//TODO comprobar si un usuario (nombre de usuario) existe ya en la BD o no.
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	private static Connection getConnectionFromFile() {
		final String filename = "config.txt";
		try {
		//TODO leer fichero y extraer la info para construir la 
		//	Connection utilizando: DriverManager.getConnection("jdbc:mysql://localh...	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
