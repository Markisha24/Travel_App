/**
 * This class and is responsible for displaying the main overview of
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
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class OverviewActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "TravelApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        //overview activity
        TextView countryTitle = findViewById(R.id.textView2);
        TextView countryOverview = findViewById(R.id.textView3);
        ImageView countryFlag = findViewById(R.id.imageView);

        //retrieving country from main activity
        Intent intent = getIntent();
        String selected_country = intent.getStringExtra("Country");

        //changing text color of title and overview
        countryTitle.setTextColor(Color.BLACK);
        countryOverview.setTextColor(Color.BLACK);

        //determines which information to display based on country chosen
        //Japan
        if(selected_country.equals("Japan")) {
            countryTitle.setText("Japan Overview");
            countryFlag.setImageResource(R.drawable.japan_flag);
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.japan_overview );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryOverview.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryOverview.setText( "Error: can't show overview text." );
            }
        }

        //Italy
        else if(selected_country.equals("Italy")) {
            countryTitle.setText("Italy Overview");
            countryFlag.setImageResource(R.drawable.italy_flag);
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.italy_overview );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryOverview.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryOverview.setText( "Error: can't show overview text." );
            }
        }

        //Tanzania
        else if(selected_country.equals("Tanzania")) {
            countryTitle.setText("Tanzania Overview");
            countryFlag.setImageResource(R.drawable.tanzania_flag);
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.tanzania_overview );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryOverview.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryOverview.setText( "Error: can't show overview text." );
            }
        }

        //Australia
        else if(selected_country.equals("Australia")) {
            countryTitle.setText("Australia Overview");
            countryFlag.setImageResource(R.drawable.australia_flag);
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.australia_overview );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryOverview.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryOverview.setText( "Error: can't show overview text." );
            }
        }

        //Brazil
        else {
            countryTitle.setText("Brazil Overview");
            countryFlag.setImageResource(R.drawable.brazil_flag);
            try {
                // Gain access to the app's resources
                Resources res = getResources();
                // Open a rw resource (a file) for reading and read it's content into a byte array
                InputStream in_s = res.openRawResource( R.raw.brazil_overview );
                byte[] b = new byte[ in_s.available() ];
                in_s.read( b );
                // Display the content of the file as a TextView content
                countryOverview.setText( new String(b) );
            } catch (Exception e) {
                // e.printStackTrace();
                countryOverview.setText( "Error: can't show overview text." );
            }
        }
    }
}