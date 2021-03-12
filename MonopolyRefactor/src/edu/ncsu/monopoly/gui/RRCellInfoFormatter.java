package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.Player;
import edu.ncsu.monopoly.RailRoadCell;
import edu.ncsu.monopoly.lOwner;

public class RRCellInfoFormatter implements CellInfoFormatter {
    public String format(lOwner cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
