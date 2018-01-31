package fr.aston.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int i = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // affichage du template activity_main
        setContentView(R.layout.activity_main);

        Log.e("Main", "passage dans la méthode onCreate "+i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        i++;

        Log.e("Main", "passage dans onStart "+i);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("Main", "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Main", "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Main", "on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Main", "on destroy");
    }
}
