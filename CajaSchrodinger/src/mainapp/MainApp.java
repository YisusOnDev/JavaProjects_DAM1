package mainapp;

import java.util.ArrayList;
import java.util.ListIterator;

import models.Animal;
import models.Cat;
import models.Dog;
import models.Monkey;
import models.SchrodingerBox;

public class MainApp {

	public static void main(String[] args) {
		// Alive animals counter
		int stillAlive = 0;

		SchrodingerBox<Animal> inspectionBox = new SchrodingerBox<Animal>();
		ArrayList<Animal> observationAnimals = new ArrayList<Animal>();

		Cat exampleCat = new Cat("Miau");
		Cat exampleCat2 = new Cat("Mishifu");
		Dog exampleDog = new Dog("Guau");
		Dog exampleDog2 = new Dog("Grrr");
		Monkey exampleMonkey = new Monkey("Weiki Weiki");

		observationAnimals.add(exampleCat);
		observationAnimals.add(exampleCat2);
		observationAnimals.add(exampleDog);
		observationAnimals.add(exampleDog2);
		observationAnimals.add(exampleMonkey);

		ListIterator<Animal> observationAnimalsIterator = observationAnimals.listIterator();

		while (observationAnimalsIterator.hasNext()) {
			Animal currentAnimal = observationAnimalsIterator.next();
			inspectionBox.addAnimal(currentAnimal);
			inspectionBox.checkAnimalStatus();

			if (currentAnimal.isAlive())
				stillAlive += 1;
		}
		
		for (Animal animal : observationAnimals) {
			if(animal.isAlive()) {
				System.out.println(animal.getAnimalName() + " is still alive.");
			} else {
				System.out.println(animal.getAnimalName() + " dead.");
			}
		}
		
		System.out.println("Animals alive in Schrodinger Box: " + stillAlive);

	}

}
