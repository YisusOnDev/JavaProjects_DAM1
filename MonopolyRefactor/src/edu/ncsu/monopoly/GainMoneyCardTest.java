package edu.ncsu.monopoly;

import junit.framework.TestCase;

public class GainMoneyCardTest extends TestCase {
    Card gainMoneyCard;
    GameMaster gameMaster;

    protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardCCGainMoney());
		gameMaster.setNumberOfPlayers(1);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
		gainMoneyCard = new MoneyCard("Get 50 dollars", 50, Card.TYPE_CC);
		gameMaster.getGameBoard().addCard(gainMoneyCard);
    }
    
    public void testGainMoneyCardAction() {
        int origMoney = gameMaster.getCurrentPlayer().getMoney();
		Card card = gameMaster.drawCCCard();
		assertEquals(gainMoneyCard, card);
		card.applyAction();
		assertEquals(origMoney + 50, gameMaster.getCurrentPlayer().getMoney());
    }
    
    public void testGainMoneyCardUI() {
        gameMaster.movePlayer(0, 1);
        assertTrue(gameMaster.getGUI().isDrawCardButtonEnabled());
        assertFalse(gameMaster.getGUI().isEndTurnButtonEnabled());
        gameMaster.btnDrawCardClicked();
        assertFalse(gameMaster.getGUI().isDrawCardButtonEnabled());
		assertTrue(gameMaster.getGUI().isEndTurnButtonEnabled());
    }
}
