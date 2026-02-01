package com.example.listview;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView programmingLanguagesListView;
    private EditText searchEditText;
    private Button submitButton;
    private String[] languages = {"Java", "Kotlin", "Python", "C++", "JavaScript", "Swift", "Go", "Ruby", "Dart", "Rust"};
    private String selectedLanguage = "";
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        programmingLanguagesListView = findViewById(R.id.programmingLanguagesListView);
        submitButton = findViewById(R.id.submitButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, languages);
        programmingLanguagesListView.setAdapter(adapter);

        // Filter ListView as user types and show/hide list
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    programmingLanguagesListView.setVisibility(View.VISIBLE);
                    adapter.getFilter().filter(s);
                } else {
                    programmingLanguagesListView.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Set selected language on click and update EditText
        programmingLanguagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedLanguage = (String) parent.getItemAtPosition(position);
                searchEditText.setText(selectedLanguage);
                programmingLanguagesListView.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Clicked: " + selectedLanguage, Toast.LENGTH_SHORT).show();
            }
        });

        // Submit button action
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!selectedLanguage.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Submitted Language: " + selectedLanguage, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a language first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
