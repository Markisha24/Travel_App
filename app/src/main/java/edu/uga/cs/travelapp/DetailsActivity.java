/**
 * This class and is responsible for displaying the tourist information of
 * the user's chosen country. The information and image displayed changes
 * based on the country chosen by the user.
 *
 * @author  Markisha Fuller
 * @since   2022-02-21
 */
package edu.uga.cs.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class DetailsActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "TravelApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //details activity
        TextView detailsTitle = findViewById(R.id.textView4);
        TextView countryDetails = findViewById(R.id.textView5);
        ImageView countryImage = findViewById(R.id.imageView2);

        //retrieving country from main activity
        Intent intent = getIntent();
        String selected_country = intent.getStringExtra("Country");

        //changing text color of title and details
        detailsTitle.setTextColor(Color.BLACK);
        countryDetails.setTextColor(Color.BLACK);

        //determines which information to display based on country chosen
        //Japan
        if(selected_country.equals("Japan")) {
            countryImage.setImageResource(R.drawable.osaka_castle );
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.japan_details );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryDetails.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryDetails.setText( "Error: can't show overview text." );
            }
        }

        //Italy
        else if(selected_country.equals("Italy")) {
            countryImage.setImageResource(R.drawable.vatican_city );
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.italy_details );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryDetails.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryDetails.setText( "Error: can't show overview text." );
            }
        }

        //Tanzania
        else if(selected_country.equals("Tanzania")) {
            countryImage.setImageResource(R.drawable.ngorongoro_conservation );
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.tanzania_details );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryDetails.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryDetails.setText( "Error: can't show overview text." );
            }
        }

        //Australia
        else if(selected_country.equals("Australia")) {
            countryImage.setImageResource(R.drawable.sydney_opera_house );
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.australia_details );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryDetails.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryDetails.setText( "Error: can't show overview text." );
            }
        }

        //Brazil
        else {
            countryImage.setImageResource(R.drawable.iguazu_falls );
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.brazil_details );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryDetails.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryDetails.setText( "Error: can't show overview text." );
            }
        }
    }
}