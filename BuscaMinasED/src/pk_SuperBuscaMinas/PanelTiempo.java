package pk_SuperBuscaMinas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelTiempo extends JPanel {

	private Timer timer = new Timer(); 
    private int segundos=0;
    private boolean contadorIniciado = false;
    
    private JLabel lblTiempo = new JLabel();
    private JLabel lblContadorSegundos = new JLabel("0");
   
    //Clase interna que funciona como contador
    class Contador extends TimerTask {
        public void run() {
            segundos++;
            lblContadorSegundos.setText(Integer.toString(segundos));
        }
    }
    
    public PanelTiempo() {
    	lblTiempo.setIcon(new ImageIcon("res/cronometro_38.png"));
    	lblContadorSegundos.setFont(new Font(lblContadorSegundos.getFont().getName(), Font.BOLD, 18));
    	
    	this.setSize(100, 50);
    	this.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));   	
    	
    	this.add(lblTiempo);
    	this.add(lblContadorSegundos);
    }
    
    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void contar()
    {
        this.segundos=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
        contadorIniciado = true;
    }
    
    //Detiene el contador
    public void detener() {
        timer.cancel();
    }
    
    //Metodo que retorna los segundos transcurridos
    public int getSegundos()
    {
        return this.segundos;
    }
    
	public boolean isContadorIniciado() {
		return contadorIniciado;
	}

	public void setContadorIniciado(boolean contadorIniciado) {
		this.contadorIniciado = contadorIniciado;
	}    
}