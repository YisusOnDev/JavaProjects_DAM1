package model;

public class Student {
	
	private int num;
	private String name;
	private String group;
	
	public Student(int num, String nombre, String grupo) {
		this.num = num;
		this.name = nombre;
		this.group = grupo;
	}

	public String getNum() {
		return Integer.toString(num);
	}

	public String getName() {
		return name;
	}

	public String getGroup() {
		return group;
	}
	
}
