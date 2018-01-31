package fr.aston.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        LinearLayout ll1 = new LinearLayout(SecondActivity.this);
        ll1.setOrientation(LinearLayout.VERTICAL);

        TextView textView1 = new TextView(SecondActivity.this);
        textView1.setText("Mon texte 1");

        ll1.addView(textView1);

        setContentView(ll1);*/

        setContentView(R.layout.activity_second);
    }
}
