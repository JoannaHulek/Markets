package com.joannahulek.markets;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MarketFragment extends Fragment {
    ViewGroup rootView;
    ListView listView;
    String currentMarket;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_market, container, false);
        assert getArguments() != null;
        currentMarket = (String) getArguments()
                .getSerializable("market");

        listView = rootView.findViewById(R.id.itemsListView);
        new LoadJsonTask().execute();
        return rootView;
    }

    private class LoadJsonTask extends AsyncTask<String, Void, List<Instrument>> {
        ProgressDialog dialog;

        protected void onPreExecute() {
            dialog = ProgressDialog.show(MarketFragment.this.getContext(), "Loading data", "Please wait");

        }

        @Override
        protected List<Instrument> doInBackground(String... strings) {
            return new HttpHandler().getMarket(currentMarket);
        }

        protected void onPostExecute(List<Instrument> instruments) {
            ArrayAdapter<Instrument> adapter =
                    new InstrumentsAdapter(rootView.getContext(), instruments);
            listView.setAdapter(adapter);
            dialog.dismiss();
        }
    }
}