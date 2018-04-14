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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_market, container, false);
        String currentMarket = (String) getArguments().getSerializable("market");

        ListView listView = rootView.findViewById(R.id.itemsListView);
        new LoadJsonTask(rootView, listView, currentMarket).execute();
        return rootView;
    }

    private static class LoadJsonTask extends AsyncTask<String, Void, List<Instrument>> {
        private ProgressDialog dialog;
        private ViewGroup rootView;
        private ListView listView;
        private String currentMarket;

        private LoadJsonTask(ViewGroup rootView,
                            ListView listView,
                            String currentMarket) {
            this.rootView = rootView;
            this.listView = listView;
            this.currentMarket = currentMarket;
        }

        protected void onPreExecute() {
            dialog = ProgressDialog.show(rootView.getContext(), "Loading data", "Please wait");
        }

        @Override
        protected List<Instrument> doInBackground(String... strings) {
            return new HttpHandler().getMarket(currentMarket);
        }

        protected void onPostExecute(List<Instrument> instruments) {
            ArrayAdapter<Instrument> adapter = new InstrumentsAdapter(rootView.getContext(), instruments);
            listView.setAdapter(adapter);
            dialog.dismiss();
        }
    }
}