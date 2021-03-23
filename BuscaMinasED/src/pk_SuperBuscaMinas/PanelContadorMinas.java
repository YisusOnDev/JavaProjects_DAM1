package pk_SuperBuscaMinas;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelContadorMinas extends JPanel {

    private JLabel lblMinas = new JLabel();
    private JLabel lblContadorMinas;
    private int numMinas;
    
    
    public PanelContadorMinas(int numMinas) {
    	this.numMinas = numMinas;
    	lblContadorMinas = new JLabel(Integer.toString(this.numMinas));
    	lblContadorMinas.setFont(new Font(lblContadorMinas.getFont().getName(), Font.BOLD, 18));
    	
    	lblMinas.setIcon(new ImageIcon("res/mine_38.png"));
    	
    	this.setSize(100, 50);
    	this.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
    	
    	this.add(lblContadorMinas);
    	this.add(lblMinas);
    }
    
    public void setNumMinas(int numMinas) {
    	this.numMinas = numMinas;
    }
    
    public int getNumMinas() {
    	return numMinas;
    }
    
    public void decrementaNumMinas() {
    	if (numMinas>0) {
        	numMinas--;
        	lblContadorMinas.setText(Integer.toString(numMinas));    		
    	}
    }

    public void incrementaNumMinas() {
    	numMinas++;
    	lblContadorMinas.setText(Integer.toString(numMinas));
    }
}