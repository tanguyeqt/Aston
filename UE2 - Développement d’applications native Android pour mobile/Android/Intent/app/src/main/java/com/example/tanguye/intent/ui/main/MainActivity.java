package com.example.tanguye.intent.ui.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tanguye.intent.R;
import com.example.tanguye.intent.service.MyService;
import com.example.tanguye.intent.ui.form.FormActivity;
import com.example.tanguye.intent.utils.Constant;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_FORM = 123;
    private TextView textViewFirstname;
    private ReceiverMessage myReceiverMessage;

    private class ReceiverMessage extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, intent.getStringExtra(Constant.INTENT_MESSAGE), Toast.LENGTH_SHORT).show();

            textViewFirstname.setText(intent.getStringExtra(Constant.INTENT_MESSAGE));

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewFirstname = findViewById(R.id.textViewFirstName);

        myReceiverMessage = new  ReceiverMessage();
    }


    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(myReceiverMessage, new IntentFilter(Constant.BROADCAST_MESSAGE));

        //registerReceiver()
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(myReceiverMessage);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode == REQUEST_CODE_FORM && resultCode == RESULT_OK){

            textViewFirstname.setText(data.getStringExtra(Constant.INTENT_FIRSTNAME));



        }
    }

    public void showForm(View view) {

        Intent myIntent = new Intent(MainActivity.this, FormActivity.class);

        startActivityForResult(myIntent, REQUEST_CODE_FORM);

    }

    public void launchService(View view) {
        startService(new Intent(MainActivity.this, MyService.class));


    }

    public void stopService(View view) {

        stopService(new Intent(MainActivity.this, MyService.class));
    }
}
