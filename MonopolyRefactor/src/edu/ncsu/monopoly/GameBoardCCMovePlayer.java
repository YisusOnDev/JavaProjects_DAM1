package edu.ncsu.monopoly;


public class GameBoardCCMovePlayer extends GameBoard {
    public GameBoardCCMovePlayer() {
		super();
		PropertyCell blue1 = new PropertyCell();
		PropertyCell blue2 = new PropertyCell();
        CardCell cc1 = new CardCell(Card.TYPE_CC, "Community Chest 1");
        JailCell jail = new JailCell();
        CardCell chance1 = new CardCell(Card.TYPE_CHANCE, "Chance 1");
        
        Card ccCard1 = new MovePlayerCard("Blue 1" , Card.TYPE_CC);
        Card ccCard2 = new MovePlayerCard("Blue 2", Card.TYPE_CC);
        Card chanceCard1 = new MovePlayerCard("Blue 1", Card.TYPE_CHANCE);
		
		blue1.setName("Blue 1");
		blue2.setName("Blue 2");
		
		blue1.setColorGroup("blue");
		blue2.setColorGroup("blue");
		
		blue1.setPrice(100);
		blue2.setPrice(100);
		
		blue1.setRent(10);
		blue2.setRent(10);
		
		blue1.setHousePrice(50);
		blue2.setHousePrice(50);
		
		addCard(ccCard1);
		addCard(ccCard2);
		
		addCell(blue1);
		addCell(cc1);
		addCell(jail);
		addCell(blue2);
		addCell(chance1);
		
    }
}
