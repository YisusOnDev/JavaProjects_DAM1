package especialEjercicioInterfacesPOO;

public class CalculadoraTest {

	public static void main(String[] args) {

		CalculadoraDecimal c = new CalculadoraDecimal();
		CalculadoraBinario cb = new CalculadoraBinario();
		System.out.println(c.suma(1, 11));
		System.out.println(cb.suma(1, 11));
	}

}
