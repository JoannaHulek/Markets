package com.joannahulek.markets;

import android.support.annotation.NonNull;

class Instrument {

    private final String instrumentName;
    private final String displayOffer;

    Instrument(@NonNull String instrumentName, @NonNull String displayOffer) {
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