package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private Nodo papa;
	private ArrayList<Nodo> hijos;

	/**
	 * Nodo constructor con valor
	 * 
	 * @param valor
	 */
	public Nodo(String valor) {
		this.valor = valor;
		this.hijos = new ArrayList<>();
	}

	/**
	 * Nodo constructor nodo
	 * 
	 * @param nodo
	 */
	public Nodo(Nodo nodo) {
		this.valor = nodo.getValor();
		hijos = new ArrayList<>();
	}

	/**
	 * Getter de valor (string)
	 * 
	 * @return String del valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Setter de valor (string)
	 * 
	 * @param valor String a setear
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo para agregar un hijo a otro nodo
	 * 
	 * @param hijo Nodo a insertar
	 */
	public void agregarHijo(Nodo hijo) {
		hijo.setPapa(this);
		hijos.add(hijo);
	}

	/**
	 * Metodo para borrar un nodo hijo
	 * 
	 * @param hijo el nodo a borrar
	 */
	public void eliminarHijo(Nodo hijo) {
		hijos.remove(hijo);
	}

	/**
	 * Metodo para conseguir todos los hijos de un nodo
	 * 
	 * @return ArrayList<Nodo> de todos los hijos
	 */
	public ArrayList<Nodo> getHijos() {
		return this.hijos;
	}

	/**
	 * Metodo para saber si un nodo tiene, o no hijos
	 * 
	 * @return true si tiene hijos, false si no
	 */
	public boolean hasHijos() {
		if (hijos != null) {
			return hijos.size() != 0;
		}

		return false;
	}

	/**
	 * Metodo para printear por pantalla los hijos de un nodo.
	 */
	public void printHijos() {
		if (hasHijos()) {
			for (Nodo nodo : hijos) {
				System.out.println(nodo.getPathNodo());
				nodo.printHijos();
			}
		}
	}

	/**
	 * Metodo para conseguir el nodo padre de un nodo
	 * 
	 * @return nodo padre si tiene, null si no
	 */
	public Nodo getPapa() {
		if (this.hasPapa()) {
			return papa;
		}

		return null;
	}

	/**
	 * Metodo para settear un nodo padre
	 * 
	 * @param papa nodo padre a setear
	 */
	public void setPapa(Nodo papa) {
		this.papa = papa;
	}

	/**
	 * Metodo para saber si un nodo tiene padre o no
	 * 
	 * @return true si tiene, false si no
	 */
	public boolean hasPapa() {
		return papa != null;
	}

	/**
	 * Metodo para conseguir el formato path (String) de un nodo
	 * 
	 * @return path del nodo en formato string
	 */
	public String getPathNodo() {
		String toReturn = valor + "/";
		Nodo currentNode = this;

		if (currentNode.hasPapa()) {
			toReturn = "/" + toReturn;
		}

		while (currentNode.hasPapa()) {
			currentNode = currentNode.getPapa();
			if (currentNode.hasPapa()) {
				toReturn = "/" + currentNode.getValor() + toReturn;
			} else {
				toReturn = currentNode.getValor() + toReturn;
			}

		}

		return toReturn;
	}

}
