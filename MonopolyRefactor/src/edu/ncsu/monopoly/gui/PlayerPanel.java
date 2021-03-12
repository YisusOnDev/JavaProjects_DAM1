package edu.ncsu.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;
import javax.swing.border.BevelBorder;

import edu.ncsu.monopoly.*;
import edu.ncsu.monopoly.Card;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.Player;

public class PlayerPanel extends JPanel {

    private JButton btnBuyHouse;
    private JButton btnDrawCard;
    private JButton btnEndTurn;
    private JButton btnGetOutOfJail;
    private JButton btnPurchaseProperty;
    private JButton btnRollDice;
    private JButton btnTrade;
    
    private JLabel lblMoney;
    private JLabel lblName;
    
    private Player player;
    
    private JTextArea txtProperty;

    public PlayerPanel(Player player) {
        JPanel pnlAction = new JPanel();
        JPanel pnlInfo = new JPanel();
        btnRollDice = new JButton("Roll Dice");
        btnPurchaseProperty = new JButton("Purchase Property");
        btnEndTurn = new JButton("End Turn");
        btnBuyHouse = new JButton("Buy House");
        btnGetOutOfJail = new JButton("Get Out of Jail");
        btnDrawCard = new JButton("Draw Card");
        btnTrade = new JButton("Trade");
        this.player = player;
        lblName = new JLabel();
        lblMoney = new JLabel();
        txtProperty = new JTextArea(30, 70);

        txtProperty.setEnabled(false);

        JPanel pnlName = new JPanel();
        JPanel pnlProperties = new JPanel();

        pnlInfo.setLayout(new BorderLayout());
        pnlInfo.add(pnlName, BorderLayout.NORTH);
        pnlInfo.add(pnlProperties, BorderLayout.CENTER);

        pnlProperties.setLayout(new OverlayLayout(pnlProperties));

        pnlName.add(lblName);
        pnlName.add(lblMoney);
        pnlProperties.add(txtProperty);

        pnlAction.setLayout(new GridLayout(3, 3));
        pnlAction.add(btnBuyHouse);
        pnlAction.add(btnRollDice);
        pnlAction.add(btnPurchaseProperty);
        pnlAction.add(btnGetOutOfJail);
        pnlAction.add(btnEndTurn);
        pnlAction.add(btnDrawCard);
        pnlAction.add(btnTrade);

        pnlAction.doLayout();
        pnlInfo.doLayout();
        pnlName.doLayout();
        pnlProperties.doLayout();
        this.doLayout();

        setLayout(new BorderLayout());
        add(pnlInfo, BorderLayout.CENTER);
        add(pnlAction, BorderLayout.SOUTH);

        btnRollDice.setEnabled(false);
        btnPurchaseProperty.setEnabled(false);
        btnEndTurn.setEnabled(false);
        btnBuyHouse.setEnabled(false);
        btnGetOutOfJail.setEnabled(false);
        btnDrawCard.setEnabled(false);
        btnTrade.setEnabled(false);

        setBorder(new BevelBorder(BevelBorder.RAISED));

        btnRollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnRollDiceClicked();
            }
        });

        btnEndTurn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnEndTurnClicked();
            }
        });

        btnPurchaseProperty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnPurchasePropertyClicked();
            }
        });

        btnBuyHouse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnBuyHouseClicked();
            }
        });

        btnGetOutOfJail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnGetOutOfJailClicked();
            }
        });

        btnDrawCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Card card = GameMaster.instance().btnDrawCardClicked();
                JOptionPane
                        .showMessageDialog(PlayerPanel.this, card.getLabel());
                displayInfo();
            }
        });

        btnTrade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameMaster.instance().btnTradeClicked();
            }
        });
    }

    public void displayInfo() {
        lblName.setText(player.getName());
        lblMoney.setText("$ " + player.getMoney());
        StringBuffer buf = new StringBuffer();
        Cell[] cells = player.getAllProperties();
        for (int i = 0; i < cells.length; i++) {
            buf.append(cells[i] + "\n");
        }
        txtProperty.setText(buf.toString());
    }
    
    public boolean isBuyHouseButtonEnabled() {
        return btnBuyHouse.isEnabled();
    }

    public boolean isDrawCardButtonEnabled() {
        return btnDrawCard.isEnabled();
    }

    public boolean isEndTurnButtonEnabled() {
        return btnEndTurn.isEnabled();
    }
    
    public boolean isGetOutOfJailButtonEnabled() {
        return btnGetOutOfJail.isEnabled();
    }
    
    public boolean isPurchasePropertyButtonEnabled() {
        return btnPurchaseProperty.isEnabled();
    }
    
    public boolean isRollDiceButtonEnabled() {
        return btnRollDice.isEnabled();
    }

    public boolean isTradeButtonEnabled() {
        return btnTrade.isEnabled();
    }

    public void setBuyHouseEnabled(boolean b) {
        btnBuyHouse.setEnabled(b);
    }

    public void setDrawCardEnabled(boolean b) {
        btnDrawCard.setEnabled(b);
    }

    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurn.setEnabled(enabled);
    }

    public void setGetOutOfJailEnabled(boolean b) {
        btnGetOutOfJail.setEnabled(b);
    }

    public void setPurchasePropertyEnabled(boolean enabled) {
        btnPurchaseProperty.setEnabled(enabled);
    }

    public void setRollDiceEnabled(boolean enabled) {
        btnRollDice.setEnabled(enabled);
    }

    public void setTradeEnabled(boolean b) {
        btnTrade.setEnabled(b);
    }
}