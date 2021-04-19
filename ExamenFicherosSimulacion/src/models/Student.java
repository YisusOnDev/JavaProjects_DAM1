package models;

public class Student {
	private String name, surname;
	private double calification;
	
	public Student(String name, String surname, double calification) {
		super();
		this.name = name;
		this.surname = surname;
		this.calification = calification;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the calification
	 */
	public double getCalification() {
		return calification;
	}

	/**
	 * @param calification the calification to set
	 */
	public void setCalification(double calification) {
		this.calification = calification;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", calification=" + calification + "]";
	}
	
	
	
	
	
}
