package fr.aston.temperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // déclaration des propriétés
    private EditText editTextCelsius, editTextFahrenheit;
    private Button buttonSave;
    private ListView listViewTemperature;

    private List<String> stringTemperature = new ArrayList<String>(); // pour enregistrer les valeurs Celsius / Fahrenheit
    private ArrayAdapter<String> adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.settings, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_delete:
                // TODO : effacer les données des 2 champs Celsius / Fahrenheit (editText)
                //editTextCelsius.setText(null);
                //editTextCelsius.setText("");
                editTextCelsius.getText().clear();
                editTextFahrenheit.getText().clear();

                // TODO : effacer les informations de la liste
                //stringTemperature.removeAll(stringTemperature);
                stringTemperature.clear();
                adapter.notifyDataSetChanged(); // rafrachissement de la liste

                // ou
                // adapter.clear();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // affichage du layout

        // récupération des Views
        editTextCelsius = findViewById(R.id.ediTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonSave = findViewById(R.id.buttonSave);
        listViewTemperature = findViewById(R.id.listViewTemperature);

        //buttonSave.setText("modifier du texte");

        editTextCelsius.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String valeur = editable.toString();
                // String valeur = editable; // ne fonctione pas

                /*if(!valeur.isEmpty()) { // la chaine n'est pas vide

                }*/

                if(valeur.length() > 0 && editTextCelsius.hasFocus() && TemperatureConverter.isNumeric(valeur)) { // la chaine a une taille > 0 caractères
                    String resultat = TemperatureConverter.fahrenheitFromCelcius(Double.valueOf(valeur));

                    editTextFahrenheit.setText(resultat);
                }
            }
        });

        editTextFahrenheit.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String valeur = editable.toString();

                if(valeur.length() > 0 && editTextFahrenheit.isFocused() && TemperatureConverter.isNumeric(valeur)) { // la chaine a une taille > 0 caractères
                    String resultat = TemperatureConverter.celsiusFromFahrenheit(Double.valueOf(valeur));

                    editTextCelsius.setText(resultat);
                }
            }
        });

        // gestion de l'enregistrement des données (Celsius / Fahrenheit)
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editTextCelsius.getText().toString().isEmpty() && !editTextFahrenheit.getText().toString().isEmpty()) {
                    // TODO : enregistrer les informations dans la stringTemperature
                    //stringTemperature.add(editTextCelsius.getText().toString()+"°C est égal à "
                    //        +editTextFahrenheit.getText().toString()+"°F");

                    stringTemperature.add(String.format(getString(R.string.main_convert_text),
                            editTextCelsius.getText().toString(),
                            editTextFahrenheit.getText().toString()));

                    // TODO : afficher les informations dans listViewTemperature
                    adapter.notifyDataSetChanged(); // demande de rafraichissement
                } else {
                    Toast.makeText(MainActivity.this, R.string.dialog_error_empty, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // création de l'adapter
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                stringTemperature);

        // lien entre la partie graphique (listViewTemperature) et les données (stringTemperature)
        listViewTemperature.setAdapter(adapter);

        // effacement d'un élément de la liste
        listViewTemperature.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO : effacer l'élément cliqué
                stringTemperature.remove(position); // effacement de l'élément
                adapter.notifyDataSetChanged(); // rafrachissement

                return false;
            }
        });

    }
}







