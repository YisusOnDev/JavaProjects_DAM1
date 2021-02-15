package models;

public class Arbol {

	private Nodo raiz;

	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public void preOrden() 
	{
		this.raiz.preOrden();
	}
	
	public void postOrden() 
	{
		this.raiz.postOrden();
	}
	
	public void inOrden() 
	{
		this.raiz.inOrden();
	}

}
