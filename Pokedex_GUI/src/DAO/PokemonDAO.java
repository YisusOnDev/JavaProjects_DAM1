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

	public ArrayList<Pokemon> getAllPokemons() {
		ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon;")) {

			// loop through the result set
			while (rs.next()) {
				Pokemon pokemon = new Pokemon(rs.getInt("Numero"), rs.getString("Nombre"), rs.getString("Descripcion"),
						rs.getFloat("Altura"), rs.getFloat("Peso"), rs.getString("Habilidad"),
						rs.getString("Categoria"), rs.getString("ImagenURL"), rs.getString("SonidoURL"));
				pokemons.add(pokemon);
			}

			return pokemons;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return null;
	}

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
				typesToReturn.add(rs.getString("tipo"));
			}
			toReturn = new String[typesToReturn.size()];
			return typesToReturn.toArray(toReturn);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;

	}

	public LinkedHashMap<String, Integer> getAvailableCategories() {
		LinkedHashMap<String, Integer> availableTypes = new LinkedHashMap<String, Integer>();
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from tipos")) {

			// loop through the result set
			while (rs.next()) {
				availableTypes.put(rs.getString("Tipo"), rs.getInt("codTipo"));
			}
			
			return availableTypes;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return null;

	}
	
	public void insertDBPokemon(Pokemon pokemon) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			String query = " INSERT INTO pokemon (Numero, Nombre, Descripcion, Altura, Peso, Categoria, Habilidad, ImagenURL, SonidoURL)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

	public void deleteCurrentTypes(int pId) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				String query = " DELETE from pokemon_tipos WHERE Numero = " + pId;
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.execute();
			
	
				conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void insertTypes(int pId, int[] tipos) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
			for (int i = 0; i < tipos.length; i++) {
				String query = " INSERT INTO pokemon_tipos (Numero, CodigoTipo)" + " VALUES (?, ?)";

				// create the mysql insert prepared statement
				PreparedStatement preparedStmt = conn.prepareStatement(query);
				preparedStmt.setInt(1, pId);
				preparedStmt.setInt(2, tipos[i] + 1);

				preparedStmt.execute();
			}

			conn.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}