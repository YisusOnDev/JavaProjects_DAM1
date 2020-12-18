package DAO;

import java.sql.*;
import java.util.ArrayList;

public class PokemonDAO {
	protected String name;
	protected String description;
	protected float height;
	protected float weight;
	protected String categories;
	protected String ability;
	protected String imageURL;
	protected String soundURL;
	protected static ArrayList<PokemonDAO> pokemons;

	protected PokemonDAO(String name, String description, float height, float weight, String ability, String imageURL, String soundURL) {
		super();
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.ability = ability;
		this.imageURL = imageURL;
		this.soundURL = soundURL;
		this.categories = getStringCategories(name);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public float getHeight() {
		return height;
	}

	public float getWeight() {
		return weight;
	}

	public String getAbility() {
		return ability;
	}

	public String getImageURL() {
		return imageURL;
	}
	
	public String getSoundURL() {
		return soundURL;
	}

	public static ArrayList<PokemonDAO> getAllPokemons() {
		pokemons = new ArrayList<PokemonDAO>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_prog1", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM pokemon;")) {

			// loop through the result set
			while (rs.next()) {
				PokemonDAO pokemon = new PokemonDAO(rs.getString("Nombre"), rs.getString("Descripcion"),
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
				toReturnCategories = toReturnCategories + rs.getString("tipo") + " ";
			}

			return toReturnCategories;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		// If SQL check failed
		return "Categories not found...";
	}

}