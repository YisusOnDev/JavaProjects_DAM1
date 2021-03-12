package edu.ncsu.monopoly;

public abstract class Cell {
	private boolean available = true;
	private String name;
	protected Player landlord;

	public String getName() {
		return name;
	}

	public Player getLandlord() {
		return landlord;
	}
	
	public int getPrice() {
		return 0;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public abstract void playAction();

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	void setName(String name) {
		this.name = name;
	}

	public void setLandlord(Player owner) {
		this.landlord = owner;
	}
    
    public String toString() {
        return name;
    }
}
