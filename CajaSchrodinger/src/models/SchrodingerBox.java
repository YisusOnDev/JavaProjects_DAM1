package models;

public class SchrodingerBox<E extends Animal> {

	protected E someAnimal;

	public SchrodingerBox() {

	}

	/**
	 * Method to add an animal to the box
	 * 
	 * @param animal the animal
	 */
	public void addAnimal(E animal) {
		this.someAnimal = animal;
	}

	/**
	 * Method in order to "simulate the box" will randomly *kill* an animal or let
	 * him alive.
	 */
	public void checkAnimalStatus() {
		if (someAnimal != null) {
			boolean willDead = Math.random() > 0.5;
			System.out.println("¿ WIll dead?" + willDead);
			if (willDead) {
				someAnimal.kill();
			}
		} else {
			System.out.println("No animals on box.");
		}

	}
}
