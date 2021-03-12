package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.Player;
import edu.ncsu.monopoly.UtilityCell;
import edu.ncsu.monopoly.lOwner;

public class UtilCellInfoFormatter implements CellInfoFormatter {

	public String format(lOwner cell) {
        UtilityCell c = (UtilityCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='olive'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
	}
}
