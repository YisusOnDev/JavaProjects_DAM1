package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Alumno;

public class AlumnoDAO extends AbstractDAO {

	/**
	 * Constructor for AlumnoDAO
	 */
	public AlumnoDAO() {
		super();
	}

	/**
	 * Method to get all existins alumnos from the db and return as an ArrayList of
	 * Alumnos
	 * 
	 * @return ArrayList<Alumno> with all alumns on the db
	 */
	public ArrayList<Alumno> getAll() {
		var lista = new ArrayList<Alumno>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			PreparedStatement stmt = this.conn.prepareStatement("select * from alumnos;");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Alumno alumn = new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("nota"));
				lista.add(alumn);
			}
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return lista;
	}

}
