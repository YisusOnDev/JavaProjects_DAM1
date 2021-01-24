package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;
import models.PokemonTeam;

public class TeamDAO {

	/**
	 * Method to get a username team pokemon'
	 * 
	 * @param username
	 * @return
	 */
	public ArrayList<PokemonTeam> getTeamPokemons(String username) {
		ArrayList<PokemonTeam> pokemons = new ArrayList<PokemonTeam>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM equipos WHERE idusuario = '" + username + "'")) {

			// loop through the result set
			while (rs.next()) {
				Pokemon pokemonObj = new PokemonDAO().getPokemonFromId(rs.getInt("idpokemon"));
				// create a pokemon and add to the arraylist for every result set
				PokemonTeam nextPokemon = new PokemonTeam(rs.getInt("id"), rs.getString("idusuario"),
						rs.getInt("idpokemon"), rs.getInt("nivel"), rs.getString("mote"), pokemonObj);

				pokemons.add(nextPokemon);

			}

			// return the arraylist with all pokemons
			return pokemons;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return null;
	}

	/**
	 * Method to add a pokemon to a user team
	 * 
	 * @param p Pokemon (object)
	 */
	public void addTeamPokemon(PokemonTeam p) {
		int uid = -1;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " INSERT INTO equipos (idusuario, idpokemon, nivel, mote)" + " VALUES ( ?, ?, ?, ?)";
			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			preparedStmt.setString(1, p.getUser());
			preparedStmt.setInt(2, p.getPokeId());
			preparedStmt.setInt(3, p.getLvl());
			preparedStmt.setString(4, p.getMote());

			preparedStmt.execute();

			ResultSet rs = preparedStmt.getGeneratedKeys();
			if (rs.next()) {
				uid = rs.getInt(1);
			}

			conn.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		p.setUid(uid);
	}

	/**
	 * Method to delete a pokemon of an username team
	 * 
	 * @param p Pokemon (object)
	 * @return true if deleted false if fails
	 */
	public boolean deleteTeamPokemon(PokemonTeam p) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = "DELETE FROM equipos WHERE id =" + p.getUid();
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return false;
	}

	/**
	 * Method to update a team pokemon details (mote or lvl)
	 * 
	 * @param p Pokemon (object)
	 */
	public void updateTeamPokemon(PokemonTeam p) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " UPDATE equipos SET idpokemon = ?, nivel = ?, mote = ?" + " WHERE id = '" + p.getUid()
					+ "'";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, p.getPokeId());
			preparedStmt.setInt(2, p.getLvl());
			preparedStmt.setString(3, p.getMote());

			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
