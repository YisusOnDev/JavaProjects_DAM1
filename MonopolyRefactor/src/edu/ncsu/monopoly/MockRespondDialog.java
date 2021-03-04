package edu.ncsu.monopoly;

public class MockRespondDialog implements RespondDialog {
    public MockRespondDialog(TradeDeal deal) {
    }

    public boolean getResponse() {
        return true;
    }
}
