package models;

public abstract class Animal {

	protected String animalName;
	protected boolean isAlive;

	/**
	 * Constructor for animal
	 * 
	 * @param name The name of the animal
	 */
	public Animal(String name) {
		super();
		this.animalName = name;
		this.isAlive = true;
	}

	/**
	 * Method to set the animal name
	 * 
	 * @param name Name to set
	 */
	public void setAnimalName(String name) {
		this.animalName = name;
	}

	/**
	 * Method (getter) to know if an animal is alive or not.
	 * 
	 * @return true if alive, false if dead
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * Method that just *kill* an animal
	 */
	public void kill() {
		this.isAlive = false;
	}

}
