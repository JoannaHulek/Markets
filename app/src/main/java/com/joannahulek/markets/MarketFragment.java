package com.joannahulek.markets;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MarketFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_market, container, false);
        final String currentMarket = (String) getArguments()
                .getSerializable("market");
        ((TextView)rootView.findViewById(R.id.market_fragment_text)).setText(currentMarket);
    return rootView;
    }
}
