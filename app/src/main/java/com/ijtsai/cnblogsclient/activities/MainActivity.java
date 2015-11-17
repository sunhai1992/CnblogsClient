package com.ijtsai.cnblogsclient.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ijtsai.cnblogsclient.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.main_content)
    CoordinatorLayout mMainContent;
    @Bind(R.id.appbar)
    AppBarLayout mAppBar;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.nav_view)
    NavigationView mNaviView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        setUpViewPager(mViewPager);
//        mTabLayout.setupWithViewPager(mViewPager);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mNaviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //TODO
                return false;
            }
        });
    }

    private void setUpViewPager(ViewPager mViewPager) {
        //TODO
    }

}
