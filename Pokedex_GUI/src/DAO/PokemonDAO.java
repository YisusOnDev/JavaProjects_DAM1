package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import models.Pokemon;

public class PokemonDAO {

	/**
	 * Method to get all Pokemon info from db.
	 * 
	 * @return ArrayList<Pokemon> of All Pokemons w/ their info
	 */
	public ArrayList<Pokemon> getAllPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon;")) {

			// loop through the result set
			while (rs.next()) {
				// create a pokemon and add to the arraylist for every result set
				Pokemon pokemon = new Pokemon(rs.getInt("Numero"), rs.getString("Nombre"), rs.getString("Descripcion"),
						rs.getFloat("Altura"), rs.getFloat("Peso"), rs.getString("Habilidad"),
						rs.getString("Categoria"), rs.getString("ImagenURL"), rs.getString("SonidoURL"));
				pokemons.add(pokemon);
			}

			// return the arraylist with all pokemons
			return pokemons;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return null;
	}

	public Pokemon getPokemonFromId(int id) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon WHERE Numero = '" + id + "'")) {

			// loop through the result set
			if (rs.next()) {
				// create a pokemon and add to the arraylist for every result set
				Pokemon pokemon = new Pokemon(rs.getInt("Numero"), rs.getString("Nombre"), rs.getString("Descripcion"),
						rs.getFloat("Altura"), rs.getFloat("Peso"), rs.getString("Habilidad"),
						rs.getString("Categoria"), rs.getString("ImagenURL"), rs.getString("SonidoURL"));
				
				return pokemon;
				
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return null;
	}

	/**
	 * Method to get categories of a pokemon by his name
	 * 
	 * @param name pokemon name
	 * @return String Array with the strings of the categories
	 */
	public String[] getPokeCategories(String name) {
		ArrayList<String> typesToReturn = new ArrayList<String>();
		String[] toReturn;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT p.numero, t.tipo from tipos t INNER JOIN pokemon_tipos pt ON pt.codigotipo = t.codTipo INNER JOIN pokemon p ON p.numero = pt.numero WHERE p.Nombre ='"
								+ name + "'")) {

			// loop through the result set
			while (rs.next()) {
				// insert result set to ArrayList
				typesToReturn.add(rs.getString("tipo"));
			}
			toReturn = new String[typesToReturn.size()];

			// return all result set as array
			return typesToReturn.toArray(toReturn);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;

	}

	/**
	 * Method to all availables categories from db.
	 * 
	 * @return LinkedHashMap<String, Integer> with Category Name, Category Id
	 */
	public LinkedHashMap<String, Integer> getAvailableCategories() {
		LinkedHashMap<String, Integer> availableTypes = new LinkedHashMap<String, Integer>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from tipos")) {

			// loop through the result set
			while (rs.next()) {
				// insert result set to HashMap
				availableTypes.put(rs.getString("Tipo"), rs.getInt("codTipo"));
			}

			return availableTypes;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;

	}

	/**
	 * Method that insert a pokemon to db
	 * 
	 * @param pokemon the pokemon object itself
	 */
	public void insertDBPokemon(Pokemon pokemon) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " INSERT INTO pokemon (Numero, Nombre, Descripcion, Altura, Peso, Categoria, Habilidad, ImagenURL, SonidoURL)"
					+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);

			preparedStmt.setInt(1, pokemon.getpId());
			preparedStmt.setString(2, pokemon.getName());
			preparedStmt.setString(3, pokemon.getDescription());
			preparedStmt.setFloat(4, pokemon.getHeight());
			preparedStmt.setFloat(5, pokemon.getWeight());
			preparedStmt.setString(6, pokemon.getCategory());
			preparedStmt.setString(7, pokemon.getAbility());
			preparedStmt.setString(8, pokemon.getImageURL());
			preparedStmt.setString(9, pokemon.getSoundURL());

			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Method to update current pokemon in db
	 * 
	 * @param pokemon the pokemon object itself
	 */
	public void updateDBPokemon(Pokemon pokemon) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " UPDATE pokemon SET Nombre = ?, Descripcion = ?, Altura = ?, Peso = ?, Categoria = ?, Habilidad = ?, ImagenURL = ?, SonidoURL = ?"
					+ " WHERE Numero = '" + pokemon.getpId() + "'";

			// create the mysql insert prepared statement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, pokemon.getName());
			preparedStmt.setString(2, pokemon.getDescription());
			preparedStmt.setFloat(3, pokemon.getHeight());
			preparedStmt.setFloat(4, pokemon.getWeight());
			preparedStmt.setString(5, pokemon.getCategory());
			preparedStmt.setString(6, pokemon.getAbility());
			preparedStmt.setString(7, pokemon.getImageURL());
			preparedStmt.setString(8, pokemon.getSoundURL());

			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Method to delete a types of the pokemon id given
	 * 
	 * @param pId pokedex id of the pokemon
	 */
	public void deleteCurrentTypes(int pId) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " DELETE FROM pokemon_tipos WHERE Numero = " + pId;
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Method to insert types
	 * 
	 * @param pId  pokedex id of the pokemon
	 * @param type required type
	 */
	public void insertTypes(int pId, int[] type) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			for (int i = 0; i < type.length; i++) {
				String query = " INSERT INTO pokemon_tipos (Numero, CodigoTipo)" + " VALUES (?, ?)";

				// create the mysql insert prepared statement
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setInt(1, pId);
				preparedStmt.setInt(2, type[i] + 1);

				preparedStmt.execute();
			}

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	/**
	 * Method that deletes all info of a pokemon
	 * 
	 * @param getpId the pokedex id of the pokemon
	 * @return true if done properly, false if fails
	 */
	public boolean deleteCurrentPokemon(int getpId) {
		deleteCurrentTypes(getpId);

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = "DELETE FROM pokemon WHERE Numero =" + getpId;
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return false;
	}
}