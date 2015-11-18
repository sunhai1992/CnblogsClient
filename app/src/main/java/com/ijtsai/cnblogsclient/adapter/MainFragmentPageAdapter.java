package com.ijtsai.cnblogsclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by JohnTsai on 15/11/18.
 */
public class MainFragmentPageAdapter extends FragmentPagerAdapter {

    private PagerModelFactory pagerModelFactory;

    public MainFragmentPageAdapter(FragmentManager fm, PagerModelFactory factory) {
        super(fm);
        this.pagerModelFactory = factory;
    }

    @Override
    public Fragment getItem(int position) {
        return this.pagerModelFactory.getItem(position);
    }

    @Override
    public int getCount() {
        return pagerModelFactory.getFragmentCount();
    }

    public void addFragment(Fragment fragment, String title) {
        pagerModelFactory.addFragment(fragment, title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (pagerModelFactory.hasTitles())
            return pagerModelFactory.getTitle(position);
        return super.getPageTitle(position);
    }
}
