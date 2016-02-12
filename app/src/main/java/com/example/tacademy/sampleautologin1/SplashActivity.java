package com.example.tacademy.sampleautologin1;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String userId = PropertyManager.getInstance().getUserId();

        if(!TextUtils.isEmpty(userId)){
            String password = PropertyManager.getInstance().getPassword();
            NetworkManager.getInstance().login(this, userId, password, new NetworkManager.OnResultListener() {
                @Override
                public void onSuccess(Object result) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }

                @Override
                public void onFailure(int code) {

                }
            });
        }else {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            },2000);
        }
    }

    Handler mHandler = new Handler(Looper.getMainLooper());
}
