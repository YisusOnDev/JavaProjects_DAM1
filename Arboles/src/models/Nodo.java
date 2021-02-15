package models;

public class Nodo {

	private int valor;
	private Nodo papa;
	private Nodo nodoIzq;
	private Nodo nodoDer;

	public Nodo(int valor, Nodo papa) {
		super();
		this.valor = valor;
		this.papa = papa;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Nodo getPapa() {
		return papa;
	}

	public void setPapa(Nodo papa) {
		this.papa = papa;
	}

	public Nodo getNodoIzq() {
		return nodoIzq;
	}

	public void setNodoIzq(Nodo nodoIzq) {
		this.nodoIzq = nodoIzq;
	}

	public Nodo getNodoDer() {
		return nodoDer;
	}

	public void setNodoDer(Nodo nodoDer) {
		this.nodoDer = nodoDer;
	}

	public boolean esHoja() {
		return this.nodoIzq == null && this.nodoDer == null;
	}

	public void preOrden() {
		System.out.println(this.valor);

		if (!this.esHoja()) {
			if (nodoIzq != null)
				this.nodoIzq.preOrden();
			if (nodoDer != null)
				this.nodoDer.preOrden();
		} else {
			return;
		}
	}

	public void postOrden() {

		if (!this.esHoja()) {
			if (nodoIzq != null) {
				this.nodoIzq.postOrden();
			}
			if (nodoDer != null) {
				this.nodoDer.postOrden();
			}

			System.out.println(this.valor);

		} else {
			System.out.println(this.valor);
		}

	}

	public void inOrden() {

		if (!this.esHoja()) {
			if (nodoIzq != null) {
				this.nodoIzq.inOrden();
				System.out.println(this.valor);
			}

			if (nodoDer != null) {
				this.nodoDer.inOrden();
			}

		} else {
			System.out.println(this.valor);
		}

	}
	
	public void podarNodo(Nodo n) {
		
	}

}
