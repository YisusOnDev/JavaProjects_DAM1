package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import models.Pokemon;

public class PokemonDAO {
	
	public static ArrayList<Pokemon> getAllPokemons() {
		ArrayList<Pokemon>pokemons = new ArrayList<Pokemon>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon;")) {

			// loop through the result set
			while (rs.next()) {
				Pokemon pokemon = new Pokemon(rs.getInt("Numero"), rs.getString("Nombre"), rs.getString("Descripcion"),
						rs.getFloat("Altura"), rs.getFloat("Peso"), rs.getString("Habilidad"),
						rs.getString("ImagenURL"), rs.getString("SonidoURL"));
				pokemons.add(pokemon);
				System.out.println("Pokemon Added");
			}

			return pokemons;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return null;
	}

	public static String getStringCategories(String name) {
		String toReturnCategories = "";

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT p.numero, t.tipo from tipos t INNER JOIN pokemon_tipos pt ON pt.codigotipo = t.codTipo INNER JOIN pokemon p ON p.numero = pt.numero WHERE p.Nombre ='"
								+ name + "'")) {

			// loop through the result set
			while (rs.next()) {
				toReturnCategories = toReturnCategories + rs.getString("tipo") + "|";
			}

			return Arrays.asList(toReturnCategories.split("\\|")).toString();

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return "Categories not found...";
	}

}