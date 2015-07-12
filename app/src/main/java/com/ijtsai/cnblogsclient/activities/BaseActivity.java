package com.ijtsai.cnblogsclient.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ijtsai.cnblogsclient.R;

public class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolBar;
    protected int layoutResID = R.layout.activity_base;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layoutResID);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
    }
}
