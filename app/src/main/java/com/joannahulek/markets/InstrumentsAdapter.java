package com.joannahulek.markets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class InstrumentsAdapter extends ArrayAdapter<Instrument> {
    public InstrumentsAdapter(Context context, List<Instrument> instruments) {
        super(context, 0, instruments);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Instrument instrument = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.instrument_list_item, parent, false);
        }

        TextView instrumentNameTV = convertView.findViewById(R.id.instrumentNameTextView);
        TextView displayOfferTV = convertView.findViewById(R.id.displayOfferTextView);

        instrumentNameTV.setText(instrument.getInstrumentName());
        displayOfferTV.setText(instrument.getDisplayOffer());


        // Lookup view for data population
        // TextView tvName =  convertView.findViewById(R.id.tvName);
        // TextView tvHome =  convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        // tvName.setText(user.name);
        // tvHome.setText(user.hometown);
        // // Return the completed view to render on screen
        return convertView;
    }
}

