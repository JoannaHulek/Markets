package com.joannahulek.markets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.joannahulek.markets.MarketActivity.MARKETS;

public class MarketsFragmentAdapter extends FragmentPagerAdapter {

    public MarketsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("market", MARKETS.get(position));
        MarketFragment marketFragment = new MarketFragment();
        marketFragment.setArguments(bundle);
        return marketFragment;
    }

    @Override
    public int getCount() {
        return MARKETS.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MARKETS.get(position);
    }
}
