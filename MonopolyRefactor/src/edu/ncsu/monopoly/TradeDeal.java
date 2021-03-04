package edu.ncsu.monopoly;

public class TradeDeal {
    private int amount;
    private int playerIndex;
    private String propertyName;

    public int getAmount() {
        return amount;
    }
    
    public int getPlayerIndex() {
        return playerIndex;
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public String makeMessage() {
        String message = GameMaster.instance().getCurrentPlayer() + 
        	" wishes to purchase " +
        	propertyName + " from " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	" for " + amount + ".  " + 
        	GameMaster.instance().getPlayer(playerIndex) +
        	", do you wish to trade your property?";
        return message;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    
    public void setSellerIndex(int playerIndex) {
        this.playerIndex = playerIndex;
    }
}
