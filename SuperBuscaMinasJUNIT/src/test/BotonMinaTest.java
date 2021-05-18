package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pk_SuperBuscaMinas.BotonMina;
import pk_SuperBuscaMinas.BotonMina.Estado;

@RunWith(Parameterized.class)
public class BotonMinaTest {
	static BotonMina button;
	private Estado status;

	public BotonMinaTest(Estado status) {
		this.status = status;
	}

	@Parameters
	public static List<Estado> estados() {
		return Arrays.asList(Estado.values());
	}

	@Before
	public void setUp() throws Exception {
		button = new BotonMina();
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("*************** Inicio Prueba BotonMina ***************");
	}

	@Test
	public void testCambiarAspecto() {
		System.out.println("Boton inicial: \t" + button);
		System.out.println("Nuevo estado: \t" + status);
		button.cambiarAspecto(status);
		System.out.println("Boton final: \t" + button + "\n");
		assertEquals(status, button.getEstado());
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		System.out.println("*************** Fin Prueba BotonMina ***************");
	}
}
