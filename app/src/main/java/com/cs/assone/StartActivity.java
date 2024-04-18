package com.cs.assone;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private EditText editTextName;
    private ListView chaptersList;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Initialize views
        editTextName = findViewById(R.id.editText_name);
        chaptersList = findViewById(R.id.chapters_list);

        // Set welcome message with the user's name if available in SharedPreferences
        String userName = sharedPreferences.getString("userName", "User");
        TextView welcomeMessage = findViewById(R.id.welcome_message);
        welcomeMessage.setText("Welcome to Palestine History Hub, " + userName + "!");

        // Populate chapters list
        List<String> chapters = new ArrayList<>();
        chapters.add("1948 - The Palestinian Exodus");
        chapters.add("2002 - Second Intifada");
        chapters.add("2014 - Operation Protective Edge");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chapters);
        chaptersList.setAdapter(adapter);

        // Set item click listener for ListView
        chaptersList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected chapter
                String selectedChapter = chapters.get(position);

                // Save the user's name to SharedPreferences
                String userName = editTextName.getText().toString().trim();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("userName", userName);

                // Set additional information based on the selected chapter
                switch (position) {
                    case 0: // 1948 - The Palestinian Exodus
                        editor.putString("additionalInfo", "The year 1948 marks a significant event in the history of Palestine known as \"The Palestinian Exodus\" or \"Nakba\" in Arabic, which translates to \"catastrophe\". During this period, hundreds of thousands of Palestinians were displaced from their homes and became refugees due to the Arab-Israeli conflict and the establishment of the state of Israel.");
                        break;
                    case 1: // 2002 - Second Intifada
                        editor.putString("additionalInfo", "The Second Intifada, also known as the Al-Aqsa Intifada, was a period of intensified Palestinian-Israeli conflict that began in late September 2000 and lasted for several years, with one of its most intense phases occurring in 2002. The term \"Intifada\" translates to \"uprising\" in Arabic, and the Second Intifada was characterized by widespread violence, protests, and armed confrontations between Palestinians and Israelis.");
                        break;
                    case 2: // 2014 - Operation Protective Edge
                        editor.putString("additionalInfo", "In 2014, the Gaza-Israel conflict experienced a significant escalation, particularly during July and August, in an episode known as the Gaza War or Operation Protective Edge. Here are some key events and developments during that period:");
                        break;
                }

                editor.apply();

                // Start the DescriptionActivity and pass the selected chapter and user's name
                Intent intent = new Intent(StartActivity.this, ch1Activity.class);
                intent.putExtra("chapter", selectedChapter);
                intent.putExtra("userName", userName);
                startActivity(intent);
            }

        });
    }
}
