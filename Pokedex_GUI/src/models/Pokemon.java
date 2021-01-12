package models;

import DAO.PokemonDAO;

public class Pokemon {
	protected int pId;
	protected String name;
	protected String description;
	protected float height;
	protected float weight;
	protected String categories;
	protected String ability;
	protected String imageURL;
	protected String soundURL;

	public Pokemon(int pId, String name, String description, float height, float weight, String ability, String imageURL, String soundURL) {
		super();
		this.pId = pId;
		this.name = name;
		this.description = description;
		this.height = height;
		this.weight = weight;
		this.ability = ability;
		this.imageURL = imageURL;
		this.soundURL = soundURL;
		this.categories = PokemonDAO.getStringCategories(name);
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

}