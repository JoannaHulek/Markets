package com.joannahulek.markets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InstrumentsAdapter extends ArrayAdapter<Instrument> {
    InstrumentsAdapter(Context context, List<Instrument> instruments) {
        super(context, 0, instruments);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Instrument instrument = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.instrument_list_item, parent, false);
        }

        TextView instrumentNameTV = convertView.findViewById(R.id.instrumentNameTextView);
        TextView displayOfferTV = convertView.findViewById(R.id.displayOfferTextView);

        instrumentNameTV.setText(instrument.getInstrumentName());
        displayOfferTV.setText(instrument.getDisplayOffer());

        return convertView;
    }
}