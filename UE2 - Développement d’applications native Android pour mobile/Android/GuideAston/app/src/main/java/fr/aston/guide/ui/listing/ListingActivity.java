package fr.aston.guide.ui.listing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.aston.guide.AppActivity;
import fr.aston.guide.ui.details.DetailsActivity;
import fr.aston.guide.R;
import fr.aston.guide.models.Hotel;
import fr.aston.guide.models.Restaurant;

public class ListingActivity extends AppActivity {

    private TextView textViewTitle;
    private ListView listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        textViewTitle = findViewById(R.id.textViewTitle);
        listViewData = findViewById(R.id.listViewData);

        if(getIntent().getExtras() != null) { // on test la réception de données

            boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            if(isRestaurant) {
                textViewTitle.setText("Les Restaurants");

                List<Restaurant> restaurantList = new ArrayList<>(); // création d'une liste et initialisation
                restaurantList.add(new Restaurant("Mac Do", "Fast Food", "info@macdo.fr",
                        "0102030405", "http://www.macdo.fr", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/280px-McDonald%27s_Golden_Arches.svg.png"));

                restaurantList.add(new Restaurant("KFC", "Fast Food", "info@kfc.fr",
                        "0205060708", "http://www.kfc.fr", "https://kfcbd.com/wp-content/uploads/2016/11/kfc-logo.png"));

                restaurantList.add(new Restaurant("La crémaillère", "Gastronomique", "info@cremaillere.fr",
                        "0202030405", "http://www.cremaillere.fr", "https://medias.logishotels.com/property-images/1543/facade/retro/grand/hotel-la-cremaillere-facade-courseulles-sur-mer-481506.jpg"));

                //listViewData.setAdapter(new ArrayAdapter<Restaurant>(ListingActivity.this, R.layout.item_restaurant, restaurantList));

                listViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

            } else {
                textViewTitle.setText("Les Hôtels");

                final List<Hotel> hotelList = new ArrayList<>(); // création d'une liste et initialisation
                hotelList.add(new Hotel("La Crémaillère", "Mer", "info@cremaillere.fr", "02023323223", "http://www.creamaillere.fr", "3", "https://medias.logishotels.com/property-images/1543/facade/retro/grand/hotel-la-cremaillere-facade-courseulles-sur-mer-481506.jpg"));
                hotelList.add(new Hotel("La Crémaillère 2", "Mer", "info@cremaillere.fr", "02023323223", "http://www.creamaillere.fr", "3", "https://medias.logishotels.com/property-images/1543/facade/retro/grand/hotel-la-cremaillere-facade-courseulles-sur-mer-481506.jpg"));
                hotelList.add(new Hotel("La Crémaillère 3", "Mer", "info@cremaillere.fr", "02023323223", "http://www.creamaillere.fr", "3", "https://medias.logishotels.com/property-images/1543/facade/retro/grand/hotel-la-cremaillere-facade-courseulles-sur-mer-481506.jpg"));
                hotelList.add(new Hotel("La Crémaillère 4", "Mer", "info@cremaillere.fr", "02023323223", "http://www.creamaillere.fr", "3", "https://medias.logishotels.com/property-images/1543/facade/retro/grand/hotel-la-cremaillere-facade-courseulles-sur-mer-481506.jpg"));

                listViewData.setAdapter(new HotelAdapter(ListingActivity.this, R.layout.item_hotel, hotelList));

                listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // TODO : envoyer un objet Hotel
                        Intent intentHotel = new Intent(ListingActivity.this, DetailsActivity.class);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("hotel", hotelList.get(position));

                        intentHotel.putExtras(bundle);

                        startActivity(intentHotel);
                    }
                });

            }

        }


    }
}
