package com.joannahulek.markets;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MarketActivity extends AppCompatActivity {

    static final List<String> MARKETS = Arrays.asList("UK", "Germany", "France");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        MarketsFragmentAdapter adapter = new MarketsFragmentAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }
}
