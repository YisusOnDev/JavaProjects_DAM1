package especialEjercicioInterfacesPOO;

public class CalculadoraDecimal implements ICalculator {

	@Override
	/**
	 * Method that add two DECIMAL numbers
	 */
	public int add(int a, int b) {
		return (a + b);
	}
}
