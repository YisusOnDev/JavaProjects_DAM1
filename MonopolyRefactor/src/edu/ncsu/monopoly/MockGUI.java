package edu.ncsu.monopoly;

public class MockGUI implements MonopolyGUI {
    private boolean btnDrawCardState, btnEndTurnState, btnGetOutOfJailState;
    private boolean[] btnTradeState = new boolean[2];

    public void enableEndTurnBtn(int playerIndex) {
    }

    public void enablePlayerTurn(int playerIndex) {
    }

    public void enablePurchaseBtn(int playerIndex) {
    }
	public int[] getDiceRoll() {
		int roll[] = new int[2];
		roll[0] = 2;
		roll[1] = 3;
		return roll;
	}

    public boolean isDrawCardButtonEnabled() {
        return btnDrawCardState;
    }

    public boolean isEndTurnButtonEnabled() {
        return btnEndTurnState;
    }
	
	public boolean isGetOutOfJailButtonEnabled() {
		return btnGetOutOfJailState;
	}

    public boolean isTradeButtonEnabled(int i) {
        return btnTradeState[i];
    }

    public void movePlayer(int index, int from, int to) {
    }

    public RespondDialog openRespondDialog(TradeDeal deal) {
        RespondDialog dialog = new MockRespondDialog(deal);
        return dialog;
    }

    public TradeDialog openTradeDialog() {
        TradeDialog dialog = new MockTradeDialog();
        return dialog;
    }

    public void setBuyHouseEnabled(boolean b) {
    }

    public void setDrawCardEnabled(boolean b) {
        btnDrawCardState = b;
    }

    public void setEndTurnEnabled(boolean enabled) {
        btnEndTurnState = enabled;
    }

    public void setGetOutOfJailEnabled(boolean b) {
    	this.btnGetOutOfJailState = b;
    }

    public void setPurchasePropertyEnabled(boolean enabled) {
    }

    public void setRollDiceEnabled(boolean b) {
    }

    public void setTradeEnabled(int index, boolean b) {
        this.btnTradeState[index] = b;
    }

    public void showBuyHouseDialog(Player currentPlayer) {
    }

    public void showMessage(String string) {
    }

	public int showUtilDiceRoll() {
//		int[] diceValues = GameMaster.instance().rollDice();
//		return diceValues[0] + diceValues[1];
		return 10;
	}

    public void startGame() {
    }

	public void update() {
	}
}
