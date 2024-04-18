package com.cs.assone;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ch1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch1);

        // Initialize views
        TextView userNameTextView = findViewById(R.id.user_name_textview);
        TextView chapterTextView = findViewById(R.id.chapter_textview);
        TextView chapterContentTextView = findViewById(R.id.chapter_content_textview);

        // Get data from Intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // Get user's name from Intent extras
            String userName = extras.getString("userName");
            if (userName != null && !userName.isEmpty()) {
                // Set welcome message with the user's name
                userNameTextView.setText("Welcome, " + userName + "!");
            }

            // Get selected chapter name from Intent extras
            String chapterName = extras.getString("chapter");
            if (chapterName != null && !chapterName.isEmpty()) {
                // Set selected chapter name
                chapterTextView.setText("Chapter: " + chapterName);
            }

            // Get additional information from SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
            String additionalInfo = sharedPreferences.getString("additionalInfo", "");
            if (!additionalInfo.isEmpty()) {
                // Set additional information
                chapterContentTextView.setText(additionalInfo);
            }
        }
    }
}
