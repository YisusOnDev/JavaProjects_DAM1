package edu.ncsu.monopoly;

public interface MonopolyGUI {
	public void enableEndTurnBtn(int playerIndex);
	public void enablePlayerTurn(int playerIndex);
	public void enablePurchaseBtn(int playerIndex);
	public int[] getDiceRoll();
    public boolean isDrawCardButtonEnabled();
    public boolean isEndTurnButtonEnabled();
	public boolean isGetOutOfJailButtonEnabled();
    public boolean isTradeButtonEnabled(int i);
	public void movePlayer(int index, int from, int to);
    public RespondDialog openRespondDialog(TradeDeal deal);
    public TradeDialog openTradeDialog();
    public void setBuyHouseEnabled(boolean b);
    public void setDrawCardEnabled(boolean b);
    public void setEndTurnEnabled(boolean enabled);
    public void setGetOutOfJailEnabled(boolean b);
    public void setPurchasePropertyEnabled(boolean enabled);
    public void setRollDiceEnabled(boolean b);
    public void setTradeEnabled(int index, boolean b);
    public void showBuyHouseDialog(Player currentPlayer);
    public void showMessage(String string);
	public int showUtilDiceRoll();
	public void startGame();
	public void update();
}
