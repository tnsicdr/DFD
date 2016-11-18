package me.tnsi.dfd;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AboutActivity extends AppCompatActivity {

    private Button btnWeb, btnLegal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        btnLegal = (Button) findViewById(R.id.btnLegal);
        btnWeb = (Button) findViewById(R.id.btnWebsite);

        btnLegal.setOnClickListener(onLegalClickListener);
        btnWeb.setOnClickListener(onWebClickListener);
    }

    private View.OnClickListener onLegalClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
            builder.setMessage("Cohesive Unit Unincorporated is not responsible for" +
                    " any damages or injures occurred to any persons as part of the " +
                    "Deal Finding Activity. Be aware of your surroundings at all times. " +
                    "Not legal for use in the state of California.").setTitle("Legal");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    };

    private View.OnClickListener onWebClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cis.gvsu.edu/~grissom/"));
            startActivity(browserIntent);
        }
    };
}
