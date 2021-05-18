package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pk_SuperBuscaMinas.BotonMina;
import pk_SuperBuscaMinas.BotonMina.Estado;
import pk_SuperBuscaMinas.BotonMina.Valor;
import pk_SuperBuscaMinas.Coordenadas;
import pk_SuperBuscaMinas.MatrizBotones;
import pk_SuperBuscaMinas.Util.Posicion;

public class MatrizBotonesTest {
	static MatrizBotones matrix;
	static List<Coordenadas> listaMinas;
	
	@BeforeClass
	public static void generateMatrix() {
		//Init Message
		System.out.println("*************** Inicio Prueba MatrizBotones ***************\n");
		// Init matrix var
		matrix = new MatrizBotones(5,5);
		// Init mines
		matrix.getBoton(0, 0).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(0, 0));
		
		matrix.getBoton(0, 1).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(0, 1));
		
		matrix.getBoton(0, 2).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(0, 2));

		matrix.getBoton(1, 0).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(1, 0));

		matrix.getBoton(4, 0).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(4, 0));

		matrix.getBoton(4, 1).setValor(Valor.MINA);
		matrix.getListaPosicionMinas().add(new Coordenadas(4, 1));
		
		listaMinas = matrix.getListaPosicionMinas();
		System.out.println("Matriz de prueba 5x5 con 6 minas");
		matrix.imprimir();
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("*************** Fin Prueba MatrizBotones ***************");
	}
	
	@Test
	public void testHayBoton() {
		System.out.println("Método hayBoton");
		
		BotonMina button = new BotonMina();
		
		button = matrix.getBoton(0, 0);
		System.out.println("Boton superior izq");
		assertTrue(matrix.hayBoton(button, Posicion.DER));
		assertTrue(matrix.hayBoton(button, Posicion.INF));
		assertTrue(matrix.hayBoton(button, Posicion.INF_DER));
		assertFalse(matrix.hayBoton(button, Posicion.INF_IZQ));
		assertFalse(matrix.hayBoton(button, Posicion.IZQ));
		assertFalse(matrix.hayBoton(button, Posicion.SUP));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_DER));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_IZQ));
		
		button = matrix.getBoton(0, 4);
		System.out.println("Boton superior der");
		assertFalse(matrix.hayBoton(button, Posicion.DER));
		assertTrue(matrix.hayBoton(button, Posicion.INF));
		assertFalse(matrix.hayBoton(button, Posicion.INF_DER));
		assertTrue(matrix.hayBoton(button, Posicion.INF_IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.IZQ));
		assertFalse(matrix.hayBoton(button, Posicion.SUP));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_DER));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_IZQ));
		
		button = matrix.getBoton(2, 2);
		System.out.println("Boton central");
		assertTrue(matrix.hayBoton(button, Posicion.DER));
		assertTrue(matrix.hayBoton(button, Posicion.INF));
		assertTrue(matrix.hayBoton(button, Posicion.INF_DER));
		assertTrue(matrix.hayBoton(button, Posicion.INF_IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.SUP));
		assertTrue(matrix.hayBoton(button, Posicion.SUP_DER));
		assertTrue(matrix.hayBoton(button, Posicion.SUP_IZQ));
		
		button = matrix.getBoton(4, 0);
		System.out.println("Boton inferior izq");
		assertTrue(matrix.hayBoton(button, Posicion.DER));
		assertFalse(matrix.hayBoton(button, Posicion.INF));
		assertFalse(matrix.hayBoton(button, Posicion.INF_DER));
		assertFalse(matrix.hayBoton(button, Posicion.INF_IZQ));
		assertFalse(matrix.hayBoton(button, Posicion.IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.SUP));
		assertTrue(matrix.hayBoton(button, Posicion.SUP_DER));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_IZQ));
		
		button = matrix.getBoton(4, 4);
		System.out.println("Boton inferior der\n");
		assertFalse(matrix.hayBoton(button, Posicion.DER));
		assertFalse(matrix.hayBoton(button, Posicion.INF));
		assertFalse(matrix.hayBoton(button, Posicion.INF_DER));
		assertFalse(matrix.hayBoton(button, Posicion.INF_IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.IZQ));
		assertTrue(matrix.hayBoton(button, Posicion.SUP));
		assertFalse(matrix.hayBoton(button, Posicion.SUP_DER));
		assertTrue(matrix.hayBoton(button, Posicion.SUP_IZQ));
	}
	
	@Test
	public void testMuestraMinas() {
		System.out.println("Método MuestraMinas");
		for (Coordenadas coords : listaMinas) {
			// Seteamos el estado a mina debido a que nunca ponemos un estado.
			matrix.getBoton(coords).setEstado(Estado.MINA); 
			assertEquals(Valor.MINA, matrix.getBoton(coords).getValor());
		}
		matrix.imprimir();
	}
 	
	@Test
	public void testRecursivoDestapaBotonesAdyacentes() {
		System.out.println("Método RecursivoDestapaBotonesAdyacente");
		matrix.getBoton(2, 0).cambiarAspecto(Estado.NUMERO);
		matrix.recursivoDestapaBotonesAdyacentes(matrix.getBoton(2, 0));
		matrix.getBoton(3, 3).cambiarAspecto(Estado.PULSADO);
		matrix.recursivoDestapaBotonesAdyacentes(matrix.getBoton(3, 3));
		matrix.imprimir();
	}
}
