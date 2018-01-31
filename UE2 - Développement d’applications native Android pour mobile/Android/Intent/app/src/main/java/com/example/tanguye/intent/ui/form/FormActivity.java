package com.example.tanguye.intent.ui.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tanguye.intent.R;
import com.example.tanguye.intent.utils.Constant;

public class FormActivity extends AppCompatActivity {

    private EditText editTextFirstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editTextFirstname = findViewById(R.id.editTextFirstName);
    }

    public void submit(View view) {

        Intent myIntent = new Intent();
        myIntent.putExtra(Constant.INTENT_FIRSTNAME, editTextFirstname.getText().toString());

        setResult(RESULT_OK, myIntent); //enregistrement du statut et transmission des données (intent)
        finish();//fermeture de l'activity courante


    }
}
