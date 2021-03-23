package pk_SuperBuscaMinas;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalButtonUI;

// Clase que representa un botón Mina
public class BotonMina extends JButton {
	public static enum Estado {
		BANDERA, BOTON, PULSADO, MINA, NUMERO
	}
	
	public static enum Valor {
		MINA, VACIO, NUMERO
	}
	
	private int numMinasAdyacentes = 0;
	private Valor valor = Valor.VACIO;
	private Estado estado = Estado.BOTON;
	private int fil, col;
	

	/**
	 * Constructor de un BotonMina
	 * @param numMinasAdyacentes
	 * @param fil fila en la que encuentra el botón
	 * @param col columna en la que encuentra el botón
	 */
	public BotonMina(int fil, int col) {
		this.fil = fil;
		this.col = col;
		
		this.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.setMargin(new Insets(1,1,1,1));
	}
	
	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the valor
	 */
	public Valor getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Valor valor) {
		this.valor = valor;
	}

	/**
	 * Método que cambia el aspecto de un botón según el parámetro de entrada
	 * 
	 * @param estado <code><ul>
	 * <li>MINA: Muestra mina</li>
	 * <li>BLANCO: Deja el botón inactivo. (No hay nada))</li>
	 * <li>BANDERA: Muestra Bandera</li>
	 * <li>&nbsp1: Muestra <b>1</b></li>
	 * </ul>
	 * </code>
	 */
	public void cambiarAspecto(Estado estado) {
		switch (estado) {
			case BANDERA:
				setText("");
				setIcon(new ImageIcon("res/flag_38.png"));
				setHorizontalTextPosition(SwingConstants.CENTER);
				setEstado(estado);
				break;
			case MINA:
				setText("");
				setIcon(new ImageIcon("res/mine_38.png"));
				setHorizontalTextPosition(SwingConstants.CENTER);
				setEstado(estado);
				break;
			case PULSADO:
				setText("");
				setEnabled(false);
				setValor(Valor.VACIO);
				setEstado(estado);
				break;
			case BOTON:
				setText("");
				setIcon(null);
				setEnabled(true);
				setEstado(estado);
				break;
			case NUMERO:
				muestraAdyacentes();
				break;
		}		
	}

	/**
	 * Método que cambia el aspecto de un botón según el número de minas adyacentes que haya
	 */	
	private void muestraAdyacentes() {
		switch (numMinasAdyacentes) {
		case 1: 
			setNumero(Color.BLUE);		break;
		case 2: 
			setNumero(Color.GREEN);		break;
		case 3: 
			setNumero(Color.RED);		break;
		case 4:
			setNumero(Color.MAGENTA);	break;
		case 5:
			setNumero(Color.CYAN);		break;
		case 6:
			setNumero(Color.DARK_GRAY);	break;
		case 7:
			setNumero(Color.PINK);		break;
		case 8:
			setNumero(Color.YELLOW);	break;
		}
	}


	/**
	 * Método para mostrar un número de un color concreto en el botón.
	 * <br>El estado del botón pasa a ser NUMERO
	 * @param numero el numero
	 * @param c el color
	 */
	private void setNumero(Color c) {
		setText(String.valueOf(numMinasAdyacentes));
		setForeground(c);
		setEstado(Estado.NUMERO);
		setUI(new MetalButtonUI() {
		    protected Color getDisabledTextColor() {
		        return c;
		    }
		});
		setEnabled(false);
	}
	
	/**
	 * @return the fil
	 */
	public int getFil() {
		return fil;
	}

	/**
	 * @param fil the fil to set
	 */
	public void setFil(int fil) {
		this.fil = fil;
	}

	/**
	 * @return the col
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @param col the col to set
	 */
	public void setCol(int col) {
		this.col = col;
	}

	/**
	 * @param valorInt the valorInt to set
	 */
	public void setNumMinasAdyacentes(int valorInt) {
		this.numMinasAdyacentes = valorInt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BotonMina [valor=" + valor + ", estado=" + estado + "]";
	}
	
}
