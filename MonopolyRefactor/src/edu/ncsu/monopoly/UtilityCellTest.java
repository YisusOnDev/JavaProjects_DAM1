package edu.ncsu.monopoly;

import junit.framework.TestCase;

public class UtilityCellTest extends TestCase {
	GameMaster gameMaster;
	
	protected void setUp() {
		gameMaster = GameMaster.instance();
		gameMaster.setGameBoard(new GameBoardUtility());
		gameMaster.setNumberOfPlayers(2);
		gameMaster.reset();
		gameMaster.setGUI(new MockGUI());
	}
    
    public void testMonopoly() {
        int u1CellIndex = gameMaster.getGameBoard().queryCellIndex("Utility 1");
        gameMaster.movePlayer(0, u1CellIndex);
        gameMaster.getPlayer(0).purchase();
        int u2CellIndex = gameMaster.getGameBoard().queryCellIndex("Utility 2");
        gameMaster.movePlayer(0, u2CellIndex - u1CellIndex);
        gameMaster.getPlayer(0).purchase();
        assertFalse(gameMaster.getPlayer(0).canBuyHouse());
    }
	
	public void testPlayerAction() {
		UtilityCell cell =
			(UtilityCell) gameMaster.getGameBoard().queryCell("Utility 1");
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Utility 1");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		gameMaster.switchTurn();
		gameMaster.movePlayer(1, cellIndex);
		cell.playAction();
		int diceRoll = gameMaster.getUtilDiceRoll();
		assertEquals(
				1500 - cell.getRent(diceRoll),
				gameMaster.getPlayer(1).getMoney());
		assertEquals(
				1350 + cell.getRent(diceRoll),
				gameMaster.getPlayer(0).getMoney());
	}

	public void testPurchaseUtility() {
		assertEquals(0, gameMaster.getPlayer(0).numberOfUtil());
		int cellIndex = gameMaster.getGameBoard().queryCellIndex("Utility 1");
		gameMaster.movePlayer(0, cellIndex);
		gameMaster.getPlayer(0).purchase();
		assertEquals(1350, gameMaster.getPlayer(0).getMoney());
		assertEquals(1, gameMaster.getPlayer(0).numberOfUtil());
	}

	public void testRent() {
		UtilityCell u1 =
			(UtilityCell) gameMaster.getGameBoard().queryCell("Utility 1");
		int cellIndex1 = gameMaster.getGameBoard().queryCellIndex("Utility 1");
		gameMaster.movePlayer(0, cellIndex1);
		gameMaster.getPlayer(0).purchase();
		assertEquals(40, u1.getRent(10));

		UtilityCell u2 =
			(UtilityCell) gameMaster.getGameBoard().queryCell("Utility 2");
		int cellIndex2 = gameMaster.getGameBoard().queryCellIndex("Utility 2");
		gameMaster.movePlayer(0, cellIndex2 - cellIndex1);
		gameMaster.getPlayer(0).purchase();
		assertEquals(100, u1.getRent(10));
		assertEquals(100, u2.getRent(10));
	}
}
