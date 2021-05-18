package especialEjercicioInterfacesPOO;

public class CalculadoraBinario {

	public int suma(int op1, int op2) {
		return Integer.parseInt(addBinary(String.valueOf(op1), String.valueOf(op2)));
	}

	private String addBinary(String input0, String input1) {
		// Use as radix 2 because it's binary
		int number0 = Integer.parseInt(input0, 2);
		int number1 = Integer.parseInt(input1, 2);

		int sum = number0 + number1;
		return Integer.toBinaryString(sum); // returns the answer as a binary value;
	}
}
