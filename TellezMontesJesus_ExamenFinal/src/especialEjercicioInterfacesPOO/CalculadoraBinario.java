package especialEjercicioInterfacesPOO;

public class CalculadoraBinario implements ICalculator {

	/**
	 * Method that add 2 binary numbers
	 * 
	 * @param input0 first binary number
	 * @param input1 second binary number
	 * @return the sum of the 2 params
	 */
	private String addBinary(String input0, String input1) {
		// Use as radix 2 because it's binary
		int number0 = Integer.parseInt(input0, 2);
		int number1 = Integer.parseInt(input1, 2);

		int sum = number0 + number1;
		return Integer.toBinaryString(sum); // returns the answer as a binary value;
	}

	@Override
	/**
	 * Method that return the sum of 2 BINARY numbers
	 */
	public int add(int a, int b) {
		return Integer.parseInt(addBinary(String.valueOf(a), String.valueOf(b)));
	}
}
