package calculators;

public class CalculadoraCientifica {

	private int ans;

	public CalculadoraCientifica() {
		ans = 0;
	}

	public int sum(int n1, int n2) {
		return ans = n1 + n2;
	}

	public int substract(int n1, int n2) {
		return ans = n1 - n2;
	}

	public int sum(int n1) {
		return ans += n1;
	}

	public int substract(int n2) {
		return ans -= n2;
	}

	public int div(int n1, int n2) {
		if (n2 == 0) {
			throw new ArithmeticException("No se puede divir entre 0");
		}
		return ans = n1 / n2;
	}

	public void optOperation() {
		try {
			Thread.sleep(2000); // Wait 2000msec
		} catch (InterruptedException e) {
			System.out.println("Interrumped");
			e.printStackTrace(System.out);
		}
	}

	public int getAns() {
		return ans;
	}

	public void clear() {
		ans = 0;
	}

}
