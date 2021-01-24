package models;

public class PokemonTeam {
	protected int uid; // unique id from database
	protected String user; // username that owns the team
	protected int pokeId; // id of the pokemon
	protected int lvl; // level of the pokemon
	protected String mote; // "mote" of the pokemon
	protected Pokemon obj; // the pokemon itself

	/**
	 * Constructor (1) for PokemonTeam
	 * 
	 * @param uid
	 * @param user
	 * @param pokeId
	 * @param lvl
	 * @param mote
	 * @param pokemon
	 */
	public PokemonTeam(int uid, String user, int pokeId, int lvl, String mote, Pokemon pokemon) {
		super();
		this.uid = uid;
		this.user = user;
		this.pokeId = pokeId;
		this.lvl = lvl;
		this.mote = mote;
		this.obj = pokemon;
	}

	/**
	 * Constructor (2) for PokemonTeam
	 * 
	 * @param user
	 * @param pokeId
	 * @param lvl
	 * @param mote
	 * @param pokemon
	 */
	public PokemonTeam(String user, int pokeId, int lvl, String mote, Pokemon pokemon) {
		super();
		this.user = user;
		this.pokeId = pokeId;
		this.lvl = lvl;
		this.mote = mote;
		this.obj = pokemon;
	}

	/**
	 * Method to get uid
	 * 
	 * @return uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * Method to set uid
	 * 
	 * @param uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * Method to get the username
	 * 
	 * @return username
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Method to set the username
	 * 
	 * @param username
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Method to get pokeId
	 * 
	 * @return pokeId
	 */
	public int getPokeId() {
		return pokeId;
	}

	/**
	 * Method to set pokeId
	 * 
	 * @param pokeId
	 */
	public void setPokeId(int pokeId) {
		this.pokeId = pokeId;
	}

	/**
	 * Method to get level
	 * @return lvl int
	 */
	public int getLvl() {
		return lvl;
	}
	
	/**
	 * Method to set level
	 * @param lvl int
	 */
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	
	/**
	 * Method to get the mote
	 * @return mote
	 */
	public String getMote() {
		return mote;
	}
	
	/**
	 * Method to set pokemon mote
	 * @param mote
	 */
	public void setMote(String mote) {
		this.mote = mote;
	}
	
	/**
	 * Method to get Pokemon object (full)
	 * @return Pokemon obj
	 */
	public Pokemon getObj() {
		return obj;
	}

}