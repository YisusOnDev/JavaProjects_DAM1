package mainapp;

import models.Arbol;
import models.Nodo;

public class MainApp {
	public static void main(String[] args) {

		// Creamos la raiz
		Nodo raiz = new Nodo(1, null);

		// Creamos nodos y sus papas
		Nodo nodo2 = new Nodo(2, raiz);
		Nodo nodo7 = new Nodo(7, raiz);
		Nodo nodo3 = new Nodo(3, nodo2);
		Nodo nodo4 = new Nodo(4, nodo2);
		Nodo nodo5 = new Nodo(5, nodo4);
		Nodo nodo6 = new Nodo(6, nodo4);
		Nodo nodo8 = new Nodo(8, nodo7);
		Nodo nodo9 = new Nodo(9, nodo7);

		// Establecemos los hijos de cada nodo
		raiz.setNodoIzq(nodo2);
		raiz.setNodoDer(nodo7);
		nodo2.setNodoIzq(nodo3);
		nodo2.setNodoDer(nodo4);
		nodo7.setNodoIzq(nodo8);
		nodo7.setNodoDer(nodo9);
		nodo4.setNodoIzq(nodo5);
		nodo4.setNodoDer(nodo6);

		Arbol arbolito = new Arbol(raiz);

		arbolito.preOrden();
		System.out.println("______________\n");
		arbolito.postOrden();
		System.out.println("______________\n");
		arbolito.inOrden();
	}
}
