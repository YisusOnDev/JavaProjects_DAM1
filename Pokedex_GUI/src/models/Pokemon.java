package models;

import DAO.PokemonDAO;

public class Pokemon {
	protected int pId;
	protected String name;
	protected String description;
	protected float height;
	protected float weight;
	protected String category;
	protected String types[];
	protected String ability;
	protected String imageURL;
	protected String soundURL;

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

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setSoundURL(String soundURL) {
		this.soundURL = soundURL;
	}
	
	public void setTypes(String[] types) {
		this.types = types;
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

	public String getCategory() {
		return category;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
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

	public String[] getTypes() {
		return types;
	}

	public String getStringTypes() {
		String toReturn = "";
		for (int i = 0; i < types.length; i++) {
			if (i < types.length) {
				toReturn += types[i] + ", ";
			} else {
				toReturn += types[i];
			}
		}
		return toReturn;
	}

	public void updatePokemon(String name, String ability, float height, float weight, String category, String description, String imageUrl, String soundUrl, int[] nTypes, String[] sTypes) {
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

	public void insertNewPokemon(int[] nTypes) {
		new PokemonDAO().insertDBPokemon(this);
		new PokemonDAO().insertTypes(this.pId, nTypes);
		
	}

}