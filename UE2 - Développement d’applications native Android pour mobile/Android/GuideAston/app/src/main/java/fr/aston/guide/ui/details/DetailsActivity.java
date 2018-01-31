package fr.aston.guide.ui.details;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import fr.aston.guide.AppActivity;
import fr.aston.guide.R;
import fr.aston.guide.models.Hotel;

public class DetailsActivity extends AppActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_CALL_PHONE = 1;
    private static final int REQUEST_CODE_CAMERA = 2;

    private ImageView imageViewPhoto;
    private TextView textViewTitle;
    private TextView textViewCategory;
    private Button buttonEmail;
    private Button buttonPhone;
    private Button buttonSite;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == REQUEST_CODE_CALL_PHONE) {
            if(permissions[0].equals(Manifest.permission.CALL_PHONE) && grantResults[0] == PackageManager.PERMISSION_GRANTED) { // au lieu de permissions[0] == Manifest.permission.CALL_PHONE
                // déclenchement de l'appel téléphonique
                buttonPhone.performClick();
            } else {
                Toast.makeText(DetailsActivity.this, "Fonctionnalitée désactivé", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonEmail:

                Intent intentEmail = new Intent(Intent.ACTION_SEND);

                if (Build.VERSION.SDK_INT <= 16) {
                    intentEmail.setType("message/rfc822"); // système de messagerie
                } else {
                    //Toast.makeText(this, "rfc2822", Toast.LENGTH_SHORT).show();
                    intentEmail.setType("message/rfc2822"); // système de messagerie
                }

                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "sujet du message");
                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{buttonEmail.getText().toString(), "mathieu.masset@vivaneo.fr"});
                intentEmail.putExtra(Intent.EXTRA_CC, new String[]{"mickael.masset@vivaneo.fr "});
                intentEmail.putExtra(Intent.EXTRA_BCC, new String[]{"info@vivaneo.fr "});

                intentEmail.putExtra(Intent.EXTRA_TEXT, "corps du message");

                startActivity(Intent.createChooser(intentEmail, "Messagerie :"));

                break;
            case R.id.buttonPhone:

                Intent intentPhone = new Intent(Intent.ACTION_CALL);
                intentPhone.setData(Uri.parse("tel:" + buttonPhone.getText().toString()));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] { Manifest.permission.CALL_PHONE }, REQUEST_CODE_CALL_PHONE);
                    }

                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intentPhone);

                break;
            case R.id.buttonSite:

                Intent intentSite = new Intent(Intent.ACTION_VIEW, Uri.parse(buttonSite.getText().toString()));
                startActivity(intentSite);
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonSite = (Button) findViewById(R.id.buttonSite);

        // add listeners
        buttonEmail.setOnClickListener(DetailsActivity.this);
        buttonPhone.setOnClickListener(DetailsActivity.this);
        buttonSite.setOnClickListener(DetailsActivity.this);

        if(getIntent().getExtras() != null) {
            if(getIntent().getExtras().get("hotel") instanceof Hotel) {

                Hotel hotel = (Hotel) getIntent().getExtras().get("hotel");

                textViewTitle.setText(hotel.getName());
                textViewCategory.setText(hotel.getCategory());
                buttonEmail.setText(hotel.getEmail());
                buttonPhone.setText(hotel.getPhone());
                buttonSite.setText(hotel.getSite());

                // TODO: afficher l'image avec une librairie
                Picasso.with(DetailsActivity.this).load(hotel.getImage()).into(imageViewPhoto);
            }
        }
    }

}
