package edu.ncsu.monopoly.gui;

import edu.ncsu.monopoly.lOwner;

public class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(lOwner cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
