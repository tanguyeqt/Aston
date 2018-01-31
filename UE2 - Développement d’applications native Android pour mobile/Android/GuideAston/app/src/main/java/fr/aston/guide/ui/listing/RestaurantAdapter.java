package fr.aston.guide.ui.listing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.aston.guide.R;
import fr.aston.guide.models.Restaurant;

public class RestaurantAdapter extends ArrayAdapter<Restaurant>{

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_restaurant, null);

        // récupération du titre et de la catégorie (Views)
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewCategory = convertView.findViewById(R.id.textViewCategory);

        Restaurant item = getItem(position); // retourne un objet Restaurant

        // mise à jour des données
        textViewTitle.setText(item.getName());
        textViewCategory.setText(item.getCategory());

        return convertView;
    }
}
