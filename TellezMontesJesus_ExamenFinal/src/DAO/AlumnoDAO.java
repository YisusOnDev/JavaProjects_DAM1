package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import models.Alumno;

public class AlumnoDAO {
	public static ArrayList<Alumno> getAll() {
		var lista = new ArrayList<Alumno>();
		
		try {
			//TODO devuelve una lista con todos los alumnos
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return lista;
	}
	private static Connection getConnectionFromFile() {
		//TODO esto lo has hecho ya en UsuarioDAO y probablemente lo hayas subido a una AbstractDAO...
		return null;
	}
	
	
}
