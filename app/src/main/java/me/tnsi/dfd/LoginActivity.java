package me.tnsi.dfd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import static android.R.attr.id;

public class LoginActivity extends AppCompatActivity {

    private Button btnFacebook, btnTwitter, btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnFacebook = (Button) findViewById(R.id.btn_facebook);
        btnTwitter = (Button) findViewById(R.id.btn_twitter);
        btnGoogle = (Button) findViewById(R.id.btn_google);
        btnFacebook.setOnClickListener(onClickListener);
        btnTwitter.setOnClickListener(onClickListener);
        btnGoogle.setOnClickListener(onClickListener);


    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent intent = new Intent(LoginActivity.this, MapActivity2.class);
            LoginActivity.this.startActivity(intent);
        }
    };

    @Override
    public void onBackPressed() {
        // nothing happens here, nothing
    }


}
