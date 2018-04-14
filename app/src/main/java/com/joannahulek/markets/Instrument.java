package com.joannahulek.markets;

class Instrument {

    private final String instrumentName;
    private final String displayOffer;

    Instrument(String instrumentName, String displayOffer) {
        this.instrumentName = instrumentName;
        this.displayOffer = displayOffer;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }
}