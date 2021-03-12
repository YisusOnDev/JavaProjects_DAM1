package edu.ncsu.monopoly;

public class RailRoadCell extends Cell {
	static private int baseRent;
	static public String COLOR_GROUP = "RAILROAD";
	static private int price;

	public static void setBaseRent(int baseRent) {
		RailRoadCell.baseRent = baseRent;
	}

	public static void setPrice(int price) {
		RailRoadCell.price = price;
	}
	
	public int getPrice() {
		return RailRoadCell.price;
	}

	public int getRent() {
		return RailRoadCell.baseRent * (int)Math.pow(2, owner.numberOfRR() - 1);
	}
	
	public void playAction() {
		Player currentPlayer = null;
		if(!isAvailable()) {
			currentPlayer = GameMaster.instance().getCurrentPlayer();
			if(owner != currentPlayer) {
				currentPlayer.payRentTo(owner, getRent());
			}
		}
	}
}
