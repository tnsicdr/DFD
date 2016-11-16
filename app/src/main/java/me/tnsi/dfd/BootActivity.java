package me.tnsi.dfd;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot);
        new CountDownTimer(2000,1000) {
            @Override
            public void onFinish() {
                Intent intent = new Intent(BootActivity.this, LoginActivity.class);
                BootActivity.this.startActivity(intent);
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();



    }
}
