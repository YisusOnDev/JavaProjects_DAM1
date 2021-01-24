package models;

public class PokemonTeam {
	protected int uid;
	protected String user;
	protected int pokeId;
	protected int lvl;
	protected String mote;
	protected Pokemon obj;

	public PokemonTeam(int uid, String user, int pokeId, int lvl, String mote, Pokemon pokemon) {
		super();
		this.uid = uid;
		this.user = user;
		this.pokeId = pokeId;
		this.lvl = lvl;
		this.mote = mote;
		this.obj = pokemon;
	}
	
	public PokemonTeam(String user, int pokeId, int lvl, String mote, Pokemon pokemon) {
		super();
		this.user = user;
		this.pokeId = pokeId;
		this.lvl = lvl;
		this.mote = mote;
		this.obj = pokemon;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPokeId() {
		return pokeId;
	}

	public void setPokeId(int pokeId) {
		this.pokeId = pokeId;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getMote() {
		return mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public Pokemon getObj() {
		return obj;
	}

}