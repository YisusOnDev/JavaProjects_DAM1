package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import calculators.CalculadoraCientifica;

public class CalculadoraCientificaTest {

	static CalculadoraCientifica calcCientifica;

	@BeforeClass
	public static void beforeClassTest() {
		calcCientifica = new CalculadoraCientifica();
	}

	@Before
	public void before() {
		calcCientifica.clear();
	}

	@After
	public void after() {
		System.out.println("@After");
	}

	@AfterClass
	public static void afterClassTest() {
		System.out.println("@AfterClass");
	}

	@Test
	public void testSuma() {
		int actual = calcCientifica.sum(5, 5);
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test
	public void divDiff0() {
		calcCientifica.div(5, 0);
	}

	@Test(expected = ArithmeticException.class) // Si no aparece excepción, falla.
	public void testDiffBy0() {
		calcCientifica.div(5, 0);
	}

	@Test(timeout = 1000) // Si no se completa en 1s, peta.
	public void testOperacionOptima() {
		calcCientifica.optOperation();
	}

	@Test
	public void testAnsSuma() {
		calcCientifica.sum(3, 2);

		int actual = calcCientifica.getAns();
		int expected = 5;
		assertEquals(expected, actual);
	}

}