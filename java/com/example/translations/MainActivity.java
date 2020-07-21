package com.example.translations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {
    private NavController NavControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create textview object to that points to text view with specific id
        TextView numView = (TextView) findViewById(R.id.number_view);

        /* Add event listener to the textview object
         * Param: create a new View.OnClickListener() interface
         * Override/Change the current onClick method from the interface for customization
         */
        numView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numIntent);
            }

        });

        TextView famView = (TextView) findViewById(R.id.family_view);
        famView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent famIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(famIntent);
            }

        });

        TextView ColorsView = (TextView) findViewById(R.id.colors_view);
        ColorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ColorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(ColorsIntent);
            }

        });

        TextView PhrasesView = (TextView) findViewById(R.id.phrases_view);
        PhrasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PhrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(PhrasesIntent);
            }

        });
    }


}