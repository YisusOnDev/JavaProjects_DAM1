package models;

import java.util.ArrayList;

public class Arbol {

	private Nodo raiz;

	/**
	 * Constructor de arbol
	 * 
	 * @param raiz el nodo raiz
	 */
	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}

	/**
	 * Metodo para saber si la raiz del arbol esta vacia
	 * 
	 * @return true si la raiz esta vacia, false si no.
	 */
	public boolean estaVacio() {
		return raiz == null;
	}

	/**
	 * Metodo para conseguir la raiz.
	 * 
	 * @return Nodo raiz
	 */
	public Nodo getRaiz() {
		return raiz;
	}

	/**
	 * Metodo para setear el nodo raiz del arbol.
	 * 
	 * @param raiz la raiz a setear
	 */
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	/**
	 * Metodo para conseguir el "preOrden" de un arbol entero.
	 * 
	 * @return ArrayList<Nodo> ordenado en PreOrden
	 */
	public ArrayList<Nodo> getPreOrden() {
		ArrayList<Nodo> arrayPreOrden = new ArrayList<Nodo>();
		doPreOrden(raiz, arrayPreOrden);
		return arrayPreOrden;
	}

	/**
	 * Metodo para conseguir el "PostOrden" de un arbol entero.
	 * 
	 * @return ArrayList<Nodo> ordenado en PostOrden
	 */
	public ArrayList<Nodo> getPostOrden() {
		ArrayList<Nodo> ArrayPostOrden = new ArrayList<Nodo>();
		doPostOrder(raiz, ArrayPostOrden);
		return ArrayPostOrden;
	}

	/**
	 * Metodo recursivo para construir el ArrayList<Nodo> en formato PreOrden.
	 * 
	 * @param nodo          nodo del cual sacar los hijos
	 * @param arrayPreOrden El ArrayList a ordena
	 */
	public void doPreOrden(Nodo nodo, ArrayList<Nodo> arrayPreOrden) {
		arrayPreOrden.add(nodo);
		for (Nodo hijo : nodo.getHijos()) {
			doPreOrden(hijo, arrayPreOrden);
		}
	}

	/**
	 * Metodo recursivo para construir el ArrayList<Nodo> en formato PostOrden.
	 * 
	 * @param nodo          nodo del cual sacar los hijos
	 * @param arrayPreOrden El ArrayList a ordena
	 */
	public void doPostOrder(Nodo nodo, ArrayList<Nodo> ArrayPostOrden) {
		for (Nodo hijo : nodo.getHijos()) {
			doPostOrder(hijo, ArrayPostOrden);
		}
		ArrayPostOrden.add(nodo);
	}

	/**
	 * Metodo para encontrar el nodo que contiene un valor
	 * 
	 * @param valor valor a buscar en el nodo
	 * @return el nodo que contiene dicho valor o null si ninguno lo tiene
	 */
	public Nodo buscarNodo(String valor) {
		return encontrarNodoValor(this.raiz, valor);
	}

	public Nodo encontrarNodoValor(Nodo nodo, String aBuscar) {
		if (nodo == null)
			return null;
		if (nodo.getValor().equals(aBuscar))
			return nodo;
		else {
			Nodo nodoGen = null;
			for (Nodo hijo : nodo.getHijos())
				if ((nodoGen = encontrarNodoValor(hijo, aBuscar)) != null)
					return nodoGen;
		}
		return null;
	}

	/**
	 * Metodo para insertar un nodo a un nodo padre (si el padre existe)
	 * 
	 * @param padre nodo padre
	 * @param valor valor a insertar
	 * @return Nodo insertado
	 */
	public Nodo insertarNodo(Nodo padre, String valor) {
		if (padre != null) {
			Nodo aInsertar = new Nodo(valor);
			padre.agregarHijo(aInsertar);
			return aInsertar;
		}

		return null;
	}

	/**
	 * Metodo para conseguir el path hacía "x" valor.
	 * 
	 * @param valor valor a buscar
	 * @return String del path
	 */
	public String path(String valor) {
		Nodo nodo = buscarNodo(valor);

		return nodo.getPathNodo();
	}

	/**
	 * Metodo para printear cada rama del arbol en formato path
	 */
	public void mostrarArbol() {
		System.out.println(raiz.getPathNodo());
		raiz.printHijos();
	}

}
