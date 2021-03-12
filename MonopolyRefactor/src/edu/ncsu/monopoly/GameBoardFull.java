package edu.ncsu.monopoly;

public class GameBoardFull extends GameBoard {
    public GameBoardFull() {
        super();
        PropertyCell dp1 = new PropertyCell();
        CardCell cc1 = new CardCell(Card.TYPE_CC, "Community Chest 1");
        PropertyCell dp2 = new PropertyCell();
        PropertyCell dp3 = new PropertyCell();
        RailRoadCell rr1 = new RailRoadCell();
        PropertyCell lb1 = new PropertyCell();
        CardCell c1 = new CardCell(Card.TYPE_CHANCE, "Chance 1");
        PropertyCell lb2 = new PropertyCell();
        PropertyCell lb3 = new PropertyCell();
        JailCell jail = new JailCell();
        PropertyCell p1 = new PropertyCell();
        UtilityCell u1 = new UtilityCell();
        PropertyCell p2 = new PropertyCell();
        PropertyCell p3 = new PropertyCell();
        RailRoadCell rr2 = new RailRoadCell();
        PropertyCell o1 = new PropertyCell();
        CardCell cc2 = new CardCell(Card.TYPE_CC, "Community Chest 2");
        PropertyCell o2 = new PropertyCell();
        PropertyCell o3 = new PropertyCell();
        FreeParkingCell fp = new FreeParkingCell();
        PropertyCell r1 = new PropertyCell();
        CardCell c2 = new CardCell(Card.TYPE_CHANCE, "Chance 2");
        PropertyCell r2 = new PropertyCell();
        PropertyCell r3 = new PropertyCell();
        RailRoadCell rr3 = new RailRoadCell();
        PropertyCell y1 = new PropertyCell();
        PropertyCell y2 = new PropertyCell();
        UtilityCell u2 = new UtilityCell();
        PropertyCell y3 = new PropertyCell();
        GoToJailCell goToJail = new GoToJailCell();
        PropertyCell g1 = new PropertyCell();
        PropertyCell g2 = new PropertyCell();
        CardCell cc3 = new CardCell(Card.TYPE_CC, "Community Chest 3");
        PropertyCell g3 = new PropertyCell();
        RailRoadCell rr4 = new RailRoadCell();
        CardCell c3 = new CardCell(Card.TYPE_CHANCE, "Chance 3");
        PropertyCell db1 = new PropertyCell();
        PropertyCell db2 = new PropertyCell();
        PropertyCell db3 = new PropertyCell();
        

        dp1.setPrice(60);
        dp1.setColorGroup("purple");
        dp1.setHousePrice(50);
        dp1.setName("Mediterranean Avenue");
        dp1.setRent(2);
        
        dp2.setPrice(60);
        dp2.setColorGroup("purple");
        dp2.setHousePrice(50);
        dp2.setName("Baltic Avenue");
        dp2.setRent(4);
        
        dp3.setPrice(60);
        dp3.setColorGroup("purple");
        dp3.setHousePrice(50);
        dp3.setName("Sarah Avenue");
        dp3.setRent(4);
        
        lb1.setPrice(100);
        lb1.setColorGroup("aqua");
        lb1.setHousePrice(50);
        lb1.setName("Oriental Avenue");
        lb1.setRent(6);

        lb2.setPrice(100);
        lb2.setColorGroup("aqua");
        lb2.setHousePrice(50);
        lb2.setName("Vermont Avenue");
        lb2.setRent(6);

        lb3.setPrice(120);
        lb3.setColorGroup("aqua");
        lb3.setHousePrice(50);
        lb3.setName("Connecticut Avenue");
        lb3.setRent(8);
        
        p1.setPrice(140);
        p1.setColorGroup("fuchsia");
        p1.setHousePrice(100);
        p1.setName("St. Charles Place");
        p1.setRent(10);
        
        p2.setPrice(140);
        p2.setColorGroup("fuchsia");
        p2.setHousePrice(100);
        p2.setName("States Avenue");
        p2.setRent(10);
        
        p3.setPrice(160);
        p3.setColorGroup("fuchsia");
        p3.setHousePrice(100);
        p3.setName("Virginia Avenue");
        p3.setRent(12);
        
        o1.setPrice(180);
        o1.setColorGroup("maroon");
        o1.setHousePrice(100);
        o1.setName("St. James Avenue");
        o1.setRent(14);
        
        o2.setPrice(180);
        o2.setColorGroup("maroon");
        o2.setHousePrice(100);
        o2.setName("Tennessee Avenue");
        o2.setRent(14);
        
        o3.setPrice(200);
        o3.setColorGroup("maroon");
        o3.setHousePrice(100);
        o3.setName("New York Avenue");
        o3.setRent(16);
        
        r1.setPrice(220);
        r1.setColorGroup("red");
        r1.setHousePrice(150);
        r1.setName("Kentucky Avenue");
        r1.setRent(18);
        
        r2.setPrice(220);
        r2.setColorGroup("red");
        r2.setHousePrice(150);
        r2.setName("Indiana Avenue");
        r2.setRent(18);
        
        r3.setPrice(240);
        r3.setColorGroup("red");
        r3.setHousePrice(150);
        r3.setName("Illinois Avenue");
        r3.setRent(20);
        
        y1.setPrice(260);
        y1.setColorGroup("yellow");
        y1.setHousePrice(150);
        y1.setName("Atlantic Avenue");
        y1.setRent(22);
        
        y2.setPrice(260);
        y2.setColorGroup("yellow");
        y2.setHousePrice(150);
        y2.setName("Ventnor Avenue");
        y2.setRent(22);
        
        y3.setPrice(280);
        y3.setColorGroup("yellow");
        y3.setHousePrice(150);
        y3.setName("Marvin Gardens");
        y3.setRent(24);
        
        g1.setPrice(300);
        g1.setColorGroup("green");
        g1.setHousePrice(200);
        g1.setName("Pacific Avenue");
        g1.setRent(26);
        
        g2.setPrice(300);
        g2.setColorGroup("green");
        g2.setHousePrice(200);
        g2.setName("North Carolina Avenue");
        g2.setRent(26);
        
        g3.setPrice(320);
        g3.setColorGroup("green");
        g3.setHousePrice(200);
        g3.setName("Pennsylvania Avenue");
        g3.setRent(28);
        
        db1.setPrice(350);
        db1.setColorGroup("blue");
        db1.setHousePrice(200);
        db1.setName("Park Place");
        db1.setRent(35);
        
        db2.setPrice(350);
        db2.setColorGroup("blue");
        db2.setHousePrice(200);
        db2.setName("Dright Place");
        db2.setRent(35);
        
        db3.setPrice(400);
        db3.setColorGroup("blue");
        db3.setHousePrice(200);
        db3.setName("Boardwalk");
        db3.setRent(50);
        
        RailRoadCell.setBaseRent(50);
        RailRoadCell.setPrice(200);
        
        rr1.setName("Reading Railroad");
        rr2.setName("Pennsylvania Railroad");
        rr3.setName("B. & O. RailRoad");
        rr4.setName("Short Line");
        
        UtilityCell.setPrice(150);
        
        u1.setName("Electric Company");
        u2.setName("Water Works");
        
        addCell(dp1);
        addCell(cc1);
        addCell(dp2);
        addCell(dp3);
        addCell(rr1);
        addCell(lb1);
        addCell(c1);
        addCell(lb2);
        addCell(lb3);
        addCell(jail);
        addCell(p1);
        addCell(u1);
        addCell(p2);
        addCell(p3);
        addCell(rr2);
        addCell(o1);
        addCell(cc2);
        addCell(o2);
        addCell(o3);
        addCell(fp);
        addCell(r1);
        addCell(c2);
        addCell(r2);
        addCell(r3);
        addCell(rr3);
        addCell(y1);
        addCell(y2);
        addCell(u2);
        addCell(y3);
        addCell(goToJail);
        addCell(g1);
        addCell(g2);
        addCell(cc3);
        addCell(g3);
        addCell(rr4);
        addCell(c3);
        addCell(db1);
        addCell(db2);
        addCell(db3);
        
        addCard(new MoneyCard("Win $50", 50, Card.TYPE_CC));
        addCard(new MoneyCard("Win $20", 20, Card.TYPE_CC));
        addCard(new MoneyCard("Win $10", 10, Card.TYPE_CC));
        addCard(new MoneyCard("Lose $100", -100, Card.TYPE_CC));
        addCard(new MoneyCard("Lose $50", -50, Card.TYPE_CC));
        addCard(new JailCard(Card.TYPE_CC));
        addCard(new MovePlayerCard("St. Charles Place", Card.TYPE_CC));
        addCard(new MovePlayerCard("Boardwalk", Card.TYPE_CC));

        addCard(new MoneyCard("Win $50", 50, Card.TYPE_CHANCE));
        addCard(new MoneyCard("Win $20", 20, Card.TYPE_CHANCE));
        addCard(new MoneyCard("Win $10", 10, Card.TYPE_CHANCE));
        addCard(new MoneyCard("Lose $100", -100, Card.TYPE_CHANCE));
        addCard(new MoneyCard("Lose $50", -50, Card.TYPE_CHANCE));
        addCard(new JailCard(Card.TYPE_CHANCE));
        addCard(new MovePlayerCard("Illinois Avenue", Card.TYPE_CHANCE));
    }
}
