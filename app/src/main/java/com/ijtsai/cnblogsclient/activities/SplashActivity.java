package com.ijtsai.cnblogsclient.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.ijtsai.cnblogsclient.R;



public class SplashActivity extends AppCompatActivity{

    Context context;

    private static final int DELAY_TIME = 3*1000;
    private static final int TO_MAIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        setContentView(R.layout.layout_splash);
        delayToMain();
    }

    private void init() {
        context = this;
    }

    Handler delayHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case TO_MAIN:
                    Intent intent = new Intent(context,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };
    /**
     * 延时2秒跳转主页面
     */
    private void delayToMain() {
        delayHandler.sendEmptyMessageDelayed(TO_MAIN,DELAY_TIME);
    }
}
