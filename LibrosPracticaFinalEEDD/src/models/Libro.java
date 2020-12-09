package models;

public class Libro {
	private String titulo;
	private String isbn;
	private String autor;
	private boolean enStock;
	private Double precio;
	
	public Libro() {

	}

	/**
	 * Constructor de la clase Libro
	 * @param titulo
	 * @param isbn
	 * @param autor
	 * @param enStock
	 * @param precio
	 */
	public Libro(String titulo, String isbn, String autor, boolean enStock, double precio) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.enStock = enStock;
		this.precio = precio;
	}

	
	/**
	 * Metodo toString de Libro
	 */
	public String toString() {
		return "Titulo: " + titulo + "\n" +
				"ISBN: " + isbn + "\n" +
				"Autor: " + autor + "\n" +
				"Precio: " + precio + "\n";
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isEnStock() {
		return enStock;
	}

	public void setEnStock(boolean enStock) {
		this.enStock = enStock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}