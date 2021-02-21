package models;

import java.util.ArrayList;

public class Nodo {

	private String valor;
	private Nodo papa;
	private ArrayList<Nodo> hijos;

	public Nodo(String valor) {
		this.valor = valor;
		this.hijos = new ArrayList<>();
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void agregarHijo(Nodo hijo) {
		hijo.setPapa(this);
		hijos.add(hijo);
	}

	public void eliminarHijo(Nodo hijo) {
		hijos.remove(hijo);
	}

	public ArrayList<Nodo> getHijos() {
		return this.hijos;
	}

	public Nodo getPapa() {
		return papa;
	}

	public void setPapa(Nodo papa) {
		this.papa = papa;
	}

	/*
	 * public boolean esHoja() { return this.nodoIzq == null && this.nodoDer ==
	 * null; }
	 */

	/*
	 * public void preOrden() { System.out.println(this.valor);
	 * 
	 * if (!this.esHoja()) { if (nodoIzq != null) this.nodoIzq.preOrden(); if
	 * (nodoDer != null) this.nodoDer.preOrden(); } else { return; } }
	 * 
	 * public void postOrden() {
	 * 
	 * if (!this.esHoja()) { if (nodoIzq != null) { this.nodoIzq.postOrden(); } if
	 * (nodoDer != null) { this.nodoDer.postOrden(); }
	 * 
	 * System.out.println(this.valor);
	 * 
	 * } else { System.out.println(this.valor); }
	 * 
	 * }
	 */

}
