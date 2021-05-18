package especialEjercicioInterfacesPOO;

public class CalculadoraTest {

	public static void main(String[] args) {
		// Test for the two different "Calculators"
		CalculadoraDecimal c = new CalculadoraDecimal();
		CalculadoraBinario cb = new CalculadoraBinario();
		System.out.println(c.add(1, 11));
		System.out.println(cb.add(1, 11));
	}

}
