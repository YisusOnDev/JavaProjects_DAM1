package edu.ncsu.monopoly;

public class GameBoardRailRoad extends GameBoard {
	public GameBoardRailRoad() {
		super();
		PropertyCell blue1 = new PropertyCell();
		PropertyCell blue2 = new PropertyCell();
		PropertyCell green1 = new PropertyCell();
		PropertyCell green2 = new PropertyCell();
		JailCell jail = new JailCell();
		GoToJailCell goToJail = new GoToJailCell();
		FreeParkingCell freeParking = new FreeParkingCell();
		RailRoadCell rr1 = new RailRoadCell();
		RailRoadCell rr2 = new RailRoadCell();
		RailRoadCell rr3 = new RailRoadCell();
		RailRoadCell rr4 = new RailRoadCell();
		
		blue1.setName("Blue 1");
		blue2.setName("Blue 2");
		green1.setName("Green 1");
		green2.setName("Green 2");
		
		blue1.setColorGroup("blue");
		blue2.setColorGroup("blue");
		green1.setColorGroup("green");
		green2.setColorGroup("green");
		
		rr1.setName("Railroad A");
		rr2.setName("Railroad B");
		rr3.setName("Railroad C");
		rr4.setName("Railroad D");
		RailRoadCell.setPrice(200);
		RailRoadCell.setBaseRent(25);
		
		blue1.setPrice(100);
		blue2.setPrice(100);
		green1.setPrice(200);
		green2.setPrice(240);
		
		blue1.setRent(10);
		blue2.setRent(10);
		green1.setRent(20);
		green2.setRent(20);
		
		blue1.setHousePrice(50);
		blue2.setHousePrice(50);
		green1.setHousePrice(70);
		green2.setHousePrice(70);
		
		addCell(rr1);
		addCell(blue1);
		addCell(jail);
		addCell(rr2);
		addCell(blue2);
		addCell(freeParking);
		addCell(green1);
		addCell(rr3);
		addCell(goToJail);
		addCell(green2);
		addCell(rr4);
	}
}
