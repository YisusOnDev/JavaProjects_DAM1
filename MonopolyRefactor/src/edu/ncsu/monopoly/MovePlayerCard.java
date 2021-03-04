package edu.ncsu.monopoly;


public class MovePlayerCard extends Card {
    
    private String destination;
    private int type;

    public MovePlayerCard(String destination, int cardType) {
        this.destination = destination;
        this.type = cardType;
    }

    public void applyAction() {
        Player currentPlayer = GameMaster.instance().getCurrentPlayer();
        Cell currentPosition = currentPlayer.getPosition();
        int newCell = GameMaster.instance().getGameBoard().queryCellIndex(destination);
        int currentCell = GameMaster.instance().getGameBoard().queryCellIndex(currentPosition.getName());
        int diceValue = 0;
        if(currentCell > newCell) {
            diceValue = (GameMaster.instance().getGameBoard().getCellNumber() + 
                    (newCell - currentCell));
        }
        else if(currentCell <= newCell) {
            diceValue = newCell - currentCell;
        }
        System.out.println(diceValue);
        GameMaster.instance().movePlayer(currentPlayer, diceValue);
    }

    public int getCardType() {
        return type;
    }

    public String getLabel() {
        return "Go to " + destination;
    }

}
