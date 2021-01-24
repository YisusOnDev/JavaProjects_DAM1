package models;

import DAO.PokemonDAO;

public class Pokemon {
	protected int pId; // Pokemon' Pokedex ID
	protected String name; // Pokemon' name
	protected String description;// Pokemon' description
	protected float height; // Pokemon' height
	protected float weight; // Pokemon' weight
	protected String category; // Pokemon' category
	protected String types[]; // Pokemon' type(s)
	protected String ability; // Pokemon' ability
	protected String imageURL; // Pokemon' image URL
	protected String soundURL; // Pokemon' sound URL

	/**
	 * Constructor (1) for Pokemon
	 * 
	 * @param pId         Pokemon' Pokedex ID
	 * @param name        Pokemon' Name
	 * @param description Pokemon' Description
	 * @param height      Pokemon' Height
	 * @param weight      Pokemon' Weight
	 * @param ability     Pokemon' Ability
	 * @param category    Pokemon' Category
	 * @param imageURL    Pokemon' Image URL
	 * @param soundURL    Pokemon' Sound URL
	 */
	public Pokemon(int pId, String name, String description, float height, float weight, String ability,
			String category, String imageURL, String soundURL) {
		super();
		this.pId = pId;
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.category = category;
		this.ability = ability;
		this.imageURL = imageURL;
		this.soundURL = soundURL;
		this.types = new PokemonDAO().getPokeCategories(name);
	}

	/**
	 * Constructor (2) for Pokemon
	 * 
	 * @param pId         Pokemon' Pokedex ID
	 * @param name        Pokemon' Name
	 * @param description Pokemon' Description
	 * @param height      Pokemon' Height
	 * @param weight      Pokemon' Weight
	 * @param ability     Pokemon' Ability
	 * @param category    Pokemon' Category
	 * @param imageURL    Pokemon' Image URL
	 * @param soundURL    Pokemon' Sound URL
	 * @param types       Pokemon' Type(s)
	 */
	public Pokemon(int pId, String name, String description, float height, float weight, String ability,
			String category, String imageURL, String soundURL, String[] types) {
		super();
		this.pId = pId;
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.category = category;
		this.ability = ability;
		this.imageURL = imageURL;
		this.soundURL = soundURL;
		this.types = types;
	}

	/**
	 * Method to set pokemon' name
	 * 
	 * @param name pokemon' Name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to set pokemon' description
	 * 
	 * @param description pokemon' Description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method to set pokemon' height
	 * 
	 * @param height pokemon' Height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * Method to set pokemon' weight
	 * 
	 * @param weight pokemon' Weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * Method to set pokemon' category
	 * 
	 * @param category pokemon' Category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Method to set pokemon' ability
	 * 
	 * @param ability pokemon' Ability
	 */
	public void setAbility(String ability) {
		this.ability = ability;
	}

	/**
	 * Method to set pokemon¡ image URL
	 * 
	 * @param imageURL pokemon¡ Image URL
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * Method to set pokemon' sound URL
	 * 
	 * @param soundURL pokemon' Sound URL
	 */
	public void setSoundURL(String soundURL) {
		this.soundURL = soundURL;
	}

	/**
	 * Method to set pokemon' type(s)
	 * 
	 * @param types Type(s)
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}

	/**
	 * Method to get pokemon' name
	 * 
	 * @return the pokemon' name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to get pokemon' description
	 * 
	 * @return the pokemon' description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method to get pokemon' height
	 * 
	 * @return the pokemon' height
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Method to get pokemon' weight
	 * 
	 * @return the pokemon' weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Method to get pokemon' category
	 * 
	 * @return the pokemon' category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Method to get pokemon' pokedex id
	 * 
	 * @return the pokemon' pokedex id
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * Method to set pokemon' pokedex id
	 * 
	 * @param pId
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * Method to get pokemon' ability
	 * 
	 * @return the pokemon' ability
	 */
	public String getAbility() {
		return ability;
	}

	/**
	 * Method to get pokemon' image URL
	 * 
	 * @return the pokemon' image URL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * Method to get pokemon' sound URL
	 * 
	 * @return the pokemon' sound URL
	 */
	public String getSoundURL() {
		return soundURL;
	}

	/**
	 * Method to get pokemon' type(s)
	 * 
	 * @return the pokemon' type(s)
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * Method to get pokemon' type(s) but string formatted
	 * 
	 * @return pokemon' type(s) as string
	 */
	public String getStringTypes() {
		String toReturn = "";
		for (int i = 0; i < types.length; i++) {
			if (i == types.length - 1) {
				toReturn += types[i];
			} else {
				toReturn += types[i] + ", ";
			}
		}
		return toReturn;
	}

	/**
	 * Method that updates a pokemon in db
	 * 
	 * @param name        the pokemon' name
	 * @param ability     the pokemon' ability
	 * @param height      the pokemo'n height
	 * @param weight      the pokemon' weight
	 * @param category    the pokemo'n category
	 * @param description the pokemon' description
	 * @param imageUrl    the pokemon' image Url
	 * @param soundUrl    the pokemon' sound Url
	 * @param nTypes      the pokemon' types as int array
	 * @param sTypes      the pokemon' types as String array
	 */
	public void updatePokemon(String name, String ability, float height, float weight, String category,
			String description, String imageUrl, String soundUrl, int[] nTypes, String[] sTypes) {
		this.name = name;
		this.ability = ability;
		this.height = height;
		this.weight = weight;
		this.category = category;
		this.description = description;
		this.imageURL = imageUrl;
		this.soundURL = soundUrl;
		this.types = sTypes;

		new PokemonDAO().updateDBPokemon(this);
		new PokemonDAO().deleteCurrentTypes(this.pId);
		new PokemonDAO().insertTypes(this.pId, nTypes);
	}

	/**
	 * Method to insert a new pokemon
	 * 
	 * @param nTypes int array of new pokemon' types
	 */
	public void insertNewPokemon(int[] nTypes) {
		new PokemonDAO().insertDBPokemon(this);
		new PokemonDAO().insertTypes(this.pId, nTypes);

	}

}