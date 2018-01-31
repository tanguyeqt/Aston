package fr.aston.guide.ui.main;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fr.aston.guide.AppActivity;
import fr.aston.guide.ui.home.HomeActivity;
import fr.aston.guide.R;

public class MainActivity extends AppActivity {

    private Timer myTimer = null; // déclaration
    private long time = 2000; // sinon = 0 par défaut

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTimer = new Timer(); // instance de classe

        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                // TODO : lancer HomeActivity
                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                //myIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(myIntent); // démarrage
                //finish(); // ou noHistory="true" dans le manifest

            }
        }, time); // time = 2000 = durée d'attente


    }
}
