package t2yt3_libro;

import java.util.Scanner;

public class ejer8 {
	// Ejercicio 5 y 6 del punto 3.4 del Libro.
	// El 7 y 8 y 9 y10 y 11 y 12... es más de lo mismo de lo anterior...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println(
					"Bienvenido selecciona la opción que más te convenga:");
			System.out.println(
					"1 --> calcular área de un rectángulo \n"
					+ "2 --> calcular área de un triángulo");
			
			String seleccion = sc.nextLine();
			
			if (seleccion.equals("1")) {
				System.out.println("Escribe el tamaño de la base del rectángulo");
				double base = Double.parseDouble(sc.nextLine());
				System.out.println("Escribe el tamaño de la altura del rectángulo");
				double altura = Double.parseDouble(sc.nextLine());
				double areaRectangulo = base * altura;
				System.out.println("El área del rectángulo es: " + areaRectangulo);
				
			} else if (seleccion.equals("2")) {
				System.out.println("Escribe el tamaño de la base del triángulo");
				double base = Double.parseDouble(sc.nextLine());
				System.out.println("Escribe el tamaño de la altura del triángulo");
				double altura = Double.parseDouble(sc.nextLine());
				double areaTriangulo = (base * altura) /2;
				System.out.println("El área del triángulo es: " + areaTriangulo);
				
			}else {
				System.out.println("ERROR: Vuelve a intentarlo.");
				
			}
		}
	}
}