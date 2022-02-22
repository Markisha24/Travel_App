/**
 * The Travel App allows users to view the main overview and important
 * tourist information for up to five different countries. Countries
 * include Japan, Italy, Brazil, Tanzania, and Australia. The user
 * will select a country using the drop-down menu (spinner) and press
 * the corresponding button to view that country's main overview or
 * tourist information. Users can go back to the selection screen by
 * using the back arrow found at the top of the app.
 *
 * This class is the main activity of the app and is responsible for
 * displaying the starting screen where the user chooses a country and
 * its information.
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "TravelApp";

    private TextView mainInfoView;
    private Button overviewButton;
    private Button detailsButton;
    private ImageView worldImage;
    public static String selected_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //main activity
        mainInfoView = findViewById(R.id.textView);
        overviewButton = findViewById(R.id.button);
        detailsButton = findViewById(R.id.button2);
        worldImage = findViewById(R.id.imageView4);

        //showing app overview
        try {
            // Gain access to the app's resources
            Resources res = getResources();
            // Open a rw resource (a file) for reading and read it's content into a byte array
            InputStream in_s = res.openRawResource( R.raw.app_overview );
            byte[] b = new byte[ in_s.available() ];
            in_s.read( b );
            // Display the content of the file as a TextView content
            worldImage.setImageResource(R.drawable.world_map);
            mainInfoView.setTextSize(25);
            mainInfoView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            mainInfoView.setTextColor(Color.BLACK);
            mainInfoView.setText( new String(b) );
        } catch (Exception e) {
            // e.printStackTrace();
            mainInfoView.setText("Error: can't show info text.");
        }


        //setting button listeners
        overviewButton.setOnClickListener(new OverviewClickListener());
        detailsButton.setOnClickListener(new DetailsClickListener());

    }

    /**
     * This method runs whenever the user presses the Overview button for a
     * country. The MainActivity will change to the OverviewActivity and display
     * the appropriate information. This method also passes the country selected
     * in the form of a String to the OverviewActivity so the OverviewActivity
     * is able to determine which country's information is displayed.
     */
    private class OverviewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), OverviewActivity.class);
            final Spinner countrySpinner = (Spinner) findViewById(R.id.spinner);
            //getting selected country
            TextView country_sel = (TextView) countrySpinner.getSelectedView();
            String selected_country = country_sel.getText().toString();
            intent.putExtra("Country", selected_country);
            startActivity(intent);

        }
    }

    /**
     * This method runs whenever the user presses the Overview button for a
     * country. The MainActivity will change to the DetailsActivity and display
     * the appropriate information. This method also passes the country selected
     * in the form of a String to the DetailsActivity so the DetailsActivity
     * is able to determine which country's information is displayed.
     */
    private class DetailsClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), DetailsActivity.class);
            final Spinner countrySpinner = (Spinner) findViewById(R.id.spinner);
            //getting selected country
            TextView country_sel = (TextView) countrySpinner.getSelectedView();
            String selected_country = country_sel.getText().toString();
            intent.putExtra("Country", selected_country);
            startActivity(intent);

        }
    }
}