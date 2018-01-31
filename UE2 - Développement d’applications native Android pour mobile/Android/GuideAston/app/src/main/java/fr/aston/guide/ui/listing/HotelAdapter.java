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
import fr.aston.guide.models.Hotel;
import fr.aston.guide.models.Restaurant;

public class HotelAdapter extends ArrayAdapter<Hotel>{

    private int resId;

    public HotelAdapter(@NonNull Context context, int resource, @NonNull List<Hotel> objects) {
        super(context, resource, objects);

        resId = resource; // R.layout.item_restaurant
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder myViewHolder = null; // déclaration = null

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resId, null);

            myViewHolder = new ViewHolder(); // instance de classe

            // récupération du titre et de la catégorie (Views)
            myViewHolder.textViewTitle = convertView.findViewById(R.id.textViewTitle);
            myViewHolder.textViewCategory = convertView.findViewById(R.id.textViewCategory);

            convertView.setTag(myViewHolder); // enregistrement de l'objet myViewHolder
        } else {
            myViewHolder = (ViewHolder) convertView.getTag(); // récupération de l'objet
        }

        Hotel item = getItem(position); // retourne un objet Restaurant

        // mise à jour des données
        myViewHolder.textViewTitle.setText(item.getName());
        myViewHolder.textViewCategory.setText(item.getCategory());

        return convertView;
    }

    private class ViewHolder {
        TextView textViewTitle;
        TextView textViewCategory;
    }

}
