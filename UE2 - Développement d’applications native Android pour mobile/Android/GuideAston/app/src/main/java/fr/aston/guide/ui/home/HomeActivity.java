package fr.aston.guide.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import fr.aston.guide.AppActivity;
import fr.aston.guide.ui.listing.ListingActivity;
import fr.aston.guide.R;

public class HomeActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showRestaurant(View view) {

        Intent intentRestaurant = new Intent(HomeActivity.this, ListingActivity.class);

        // TODO : envoyer un paramètre
        intentRestaurant.putExtra("isRestaurant", true);

        Log.e("home", "restaurant");

        startActivity(intentRestaurant);
    }

    public void showHotel(View view) {
        Intent intentHotel = new Intent(HomeActivity.this, ListingActivity.class);

        // TODO : envoyer un paramètre
        intentHotel.putExtra("isRestaurant", false);
        Log.e("home", "hotel");

        startActivity(intentHotel);
    }
}
