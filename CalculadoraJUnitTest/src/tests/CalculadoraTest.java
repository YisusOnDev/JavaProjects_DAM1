package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import calculators.Calculadora;

public class CalculadoraTest {

	static Calculadora calc;

	@BeforeClass
	public static void beforeClassTest() {
		calc = new Calculadora();
	}

	@Before
	public void before() {
		System.out.println("Before()");
	}

	@Test
	public void testSuma() {
		int actual = calc.suma(2, 3);
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void testResta() {
		int actual = calc.resta(3, 2);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testMultiplicar() {
		int actual = Calculadora.multiplicar(3, 2);
		int expected = 6;
		assertEquals(expected, actual);
	}

	@Test
	public void testDividir() {	
		int actual = Calculadora.dividir(6, 2);
		int expected = 3;
		assertEquals(expected, actual);
	}

	@Test
	public void testEsPositivo() {
		boolean actual = Calculadora.esPositivo(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

}