package t5_libro;
import java.util.Scanner;

public class ejer8 {

	public static void main(String[] args) {
		// Muestra la tabla de multiplicar de un número introducido por teclado.
		
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		int multiplier = 0;
		
		System.out.print("Introduce un número, te daré los resultados de su tabla de multiplicar:");
		n = Integer.parseInt(sc.nextLine());
		
		if(n == 0) {
			System.out.println("La tabla de 0 es 0 infinitamente...");
		} else {
			while(multiplier <= 10) {
				System.out.println(n + " por " + multiplier + " es igual a: " + n*multiplier);
				multiplier += 1;
			}
		}

	}

}
