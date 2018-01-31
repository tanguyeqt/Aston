package com.example.tanguye.meteo.ui.main;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tanguye.meteo.R;
import com.example.tanguye.meteo.models.OpenWeatherMap;
import com.example.tanguye.meteo.utils.Constant;
import com.example.tanguye.meteo.utils.FastDialog;
import com.example.tanguye.meteo.utils.Network;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCity;
    private Button buttonSubmit;
    private TextView textViewCity;
    private TextView textViewTemperature;
    private ImageView imageViewIcone;
    private Dialog dialog;


    public static final String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextCity = (EditText) findViewById(R.id.editTextCity);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        textViewCity = (TextView) findViewById(R.id.textViewCity);
        textViewTemperature = (TextView) findViewById(R.id.textViewTemperature);
        imageViewIcone = (ImageView) findViewById(R.id.imageViewIcone);
      dialog = FastDialog.showProgressDialog(MainActivity.this,"Chargement");

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextCity.getText().toString().length() > 0){

                    if(Network.isNetworkAvailable(MainActivity.this)){

                        dialog.show();
                        // Instantiate the RequestQueue.
                        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                        String url = String.format(Constant.URL, editTextCity.getText().toString());

                        // Request a string response from the provided URL.
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        Log.e(TAG, "json " + response);

                                        Gson myGson = new Gson();
                                        OpenWeatherMap owm = myGson.fromJson(response, OpenWeatherMap.class);

                                        if(owm.getCod().equals("200")){ //reponse valide

                                            textViewCity.setText(owm.getName());
                                            textViewTemperature.setText(owm.getMain().getTemp());
                                            Picasso.with(MainActivity.this).load(String.format(Constant.URL_IMAGE, owm.getWeather().get(0).getIcon())).into(imageViewIcone);

                                        }else{

                                        }



                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Log.e(TAG, "onErrorResponse " + error.getMessage());
                            }
                        });
                        // Add the request to the RequestQueue.
                        queue.add(stringRequest);


                    }else{

                        dialog.dismiss();

                        FastDialog.showDialog(MainActivity.this, FastDialog.SIMPLE_DIALOG, "Vous devez être connecté");
                    }

                }else{

                  FastDialog.showDialog(MainActivity.this, FastDialog.SIMPLE_DIALOG, "Vous devez renseigner une ville");

                }

            }
        });

    }
}
