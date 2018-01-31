package fr.aston.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import fr.aston.guide.ui.home.HomeActivity;

public class AppActivity extends AppCompatActivity{

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home: // correspond à l'identifiant de la flèche de retour (en haut à gauche)
                finish(); // fermeture de l'activité courante
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null) { // permet de vérifier la présence de l'ActionBar
            if(!(this instanceof HomeActivity)) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true); // afficher la flèche de retour
            }
        }

    }
}
