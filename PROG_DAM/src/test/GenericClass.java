package test;

public class GenericClass {

	protected GenericClass() {
		super();
	}
	
	public static <E> Number dividirMitad(E number) {
		if (number instanceof Integer) {
			return (Integer) number / 2;
		} else if (number instanceof Double) {
			return (Double) number / 2;
		} else if (number instanceof Float) {
			return (Float) number / 2;
		} else if (number instanceof Short) {
			return (Short) number / 2;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Number num = dividirMitad(1.5f);
		
		System.out.println(num);
	}
	
	
}
