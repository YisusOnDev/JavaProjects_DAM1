package mainapp;

import models.Arbol;
import models.Nodo;

public class MainApp {

	public static void main(String[] args) {

		// Creamos la raiz
		Nodo raiz = new Nodo("~");

		// Creamos nodos y sus papas
		Nodo pollo = new Nodo("pollo");
		Nodo cerdo = new Nodo("cerdo");
		Nodo ternera = new Nodo("ternera");
		Nodo uno = new Nodo("uno");
		Nodo dos = new Nodo("dos");
		Nodo tres = new Nodo("tres");
		Nodo cuatro = new Nodo("cuatro");
		Nodo cinco = new Nodo("cinco");
		Nodo seis = new Nodo("seis");

		// Establecemos los hijos de cada nodo
		raiz.agregarHijo(pollo);
		raiz.agregarHijo(cerdo);
		raiz.agregarHijo(ternera);
		pollo.agregarHijo(uno);
		pollo.agregarHijo(dos);
		cerdo.agregarHijo(tres);
		ternera.agregarHijo(cuatro);
		dos.agregarHijo(cinco);
		cinco.agregarHijo(seis);
		Arbol arbol = new Arbol(raiz);

		// 4.1.- Nodo buscarNodo(String valor);
		System.out.println(arbol.buscarNodo("pollo") != null);

		// 4.2.- Nodo insertarNodo(Nodo padre, String valor);
		arbol.insertarNodo(pollo, "oasis");

		// 4.3.- String path(String valor);
		System.out.println(new String(arbol.path("oasis")));

		// 4.4.- void mostrarArbol();
		System.out.println();
		arbol.mostrarArbol();
	}

}
