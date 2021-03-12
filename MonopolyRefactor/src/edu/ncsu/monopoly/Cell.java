package edu.ncsu.monopoly;

public abstract class Cell implements lOwner {
	private boolean available = true;
	private String name;
	protected Player owner;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Player getOwner() {
		return owner;
	}
	
	@Override
	public int getPrice() {
		return 0;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}
	
	@Override
	public abstract void playAction();

	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    @Override
	public String toString() {
        return name;
    }
}
