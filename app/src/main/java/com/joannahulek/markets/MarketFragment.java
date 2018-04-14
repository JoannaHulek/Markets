package com.joannahulek.markets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_market, container, false);
        final String currentMarket = (String) getArguments()
                .getSerializable("market");
        ListView listView = rootView.findViewById(R.id.itemsListView);

        Instrument items[] = {new Instrument("name1", "offer1"),
                new Instrument("name2", "offer2")};


        List<Instrument> itemList = Arrays.asList(items);

        ArrayAdapter<Instrument> adapter = new InstrumentsAdapter(rootView.getContext(), itemList);
        listView.setAdapter(adapter);
        return rootView;
    }
}
