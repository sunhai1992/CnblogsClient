package com.ijtsai.cnblogsclient.activities;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ijtsai.cnblogsclient.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SplashActivity extends AppCompatActivity {

    Context context;

    private static final int DELAY_TIME = 2 * 1000;
    private static final int TO_MAIN = 1;

    @Bind(R.id.tv_appname)
    TextView mAppName;
    @Bind(R.id.tv_version)
    TextView mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        setContentView(R.layout.layout_splash);
        ButterKnife.bind(this);
        setAnimation();
        delayToMain();
    }

    private void setAnimation() {
        ObjectAnimator.ofFloat(mVersion, "alpha", 1f, 0.3f, 1f).setDuration(2000).start();

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(mAppName, "translationX", -mVersion.getWidth(), 0f,-mVersion.getWidth()/2,0f).setDuration(2000);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(mAppName, "alpha", 0f, 1f).setDuration(1000);
        animatorSet.playTogether(translationAnimator, alphaAnimator);
        animatorSet.start();
    }

    private void init() {
        context = this;
    }

    Handler delayHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TO_MAIN:
                    Intent intent = new Intent(context, MainActivity.class);
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
        delayHandler.sendEmptyMessageDelayed(TO_MAIN, DELAY_TIME);
    }
}
