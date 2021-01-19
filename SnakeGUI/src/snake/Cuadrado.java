package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Cuadrado {
	//Constantes. Son las direcciones en las que nuestro cuadrado puede moverse
    static public final int ARRIBA = 1;
    static public final int ABAJO = 2;
    static public final int IZQ = 3;
    static public final int DER = 4;


    //Atributos -- Estado

    //Necesitamos la posición del cuadrado marcado por su esquina superior izq.
    private int posX;
    private int posY;
    
    //También necesitamos el lado del cuadrado
    private int lado;
    
    //Ahora el color
    private int colorCuadrado;


    //comportamiento

    //creación
    public Cuadrado(int pX,int pY,int l, int cc) {
        posX = pX;
        posY = pY;
        lado = l;
        colorCuadrado = cc;
    }

    //un cuadrado se mueve arriba, abajo, derecha e izquierda
    public void moverse(int iDireccion) {
        switch (iDireccion) {
            case Cuadrado.ARRIBA: posY -= lado;   // 1 es arriba
                    break;
            case Cuadrado.ABAJO: posY += lado;   // 2 es abajo
                    break;
            case Cuadrado.IZQ: posX -= lado;   // 3 es izquierda
                    break;
            case Cuadrado.DER: posX += lado;   // 4 es derecha

        }
    }

    //un cuadrado puede estar colisionando con otro
    public boolean estaEncimaDe(Cuadrado otroC) {
    	//en nuestro caso, sólo comprobamos la esquina superior izq 
    	//almacenada en las posiciones X e Y. No hay otra posibilidad.
        return (otroC.getX() == posX && otroC.getY() == posY);
    }

    //Métodos de obtención de datos
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
    public int getLado() {return lado;}
    
    public int getColor() {
    	return colorCuadrado;
    }

    //Un cuadrado tiene que saber pintarse
    public void pintarse(Graphics2D g) {
        
    	g.setColor(new Color(colorCuadrado));
    	//g.drawRect(posX, posY, lado, lado);
    	g.fillRect(posX, posY, lado, lado);
		//g.fillOval(posX, posY, lado, lado);
		
    }
}
