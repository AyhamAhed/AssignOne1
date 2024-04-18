package com.cs.assone;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Start" button by its ID
        Button startButton = findViewById(R.id.start_button);
        // Set a click listener for the "Start" button
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the activity you want to go to
                Intent intent = new Intent(MainActivity.this, StartActivity.class);
                // Start the activity
                startActivity(intent);
            }
        });

        // Find the "Description" button by its ID
        Button descriptionButton = findViewById(R.id.description_button);
        // Set a click listener for the "Description" button
        descriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate to the activity you want to go to
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                // Start the activity
                startActivity(intent);
            }
        });
    }
}
