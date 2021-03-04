package edu.ncsu.monopoly.gui;

import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TestDiceRollDialog extends JDialog {
    private JButton btnOK, btnCancel;
    private JTextField txtDiceRoll;
    private int[] diceRoll;
    
    public TestDiceRollDialog(Frame parent) {
        super(parent);
        
        setTitle("Dice Roll Dialog");
        txtDiceRoll = new JTextField(2);
        btnOK = new JButton("OK");
        btnCancel = new JButton("Cancel");
        
        setModal(true);
             
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(2, 2));
        contentPane.add(new JLabel("Amount"));
        contentPane.add(txtDiceRoll);
        contentPane.add(btnOK);
        contentPane.add(btnCancel);
        
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                TestDiceRollDialog.this.hide();
                diceRoll = new int[2];
                diceRoll[0] = 0;
                diceRoll[1] = 0;
            }
        });
        
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int amount = 0;
                try{
                    amount = Integer.parseInt(txtDiceRoll.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(TestDiceRollDialog.this,
                            "Amount should be an integer", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(amount > 0) {
	                diceRoll = new int[2];
	                if((amount % 2) == 0) {
	                	diceRoll[0] = amount / 2;
	                	diceRoll[1] = amount / 2;
	                }
	                else {
	                	diceRoll[0] = amount / 2;
	                	diceRoll[1] = (amount / 2) + 1;
	                }
                }
                hide();
            }
        });
        
        this.pack();
    }

    public int[] getDiceRoll() {
        return diceRoll;
    }
}
