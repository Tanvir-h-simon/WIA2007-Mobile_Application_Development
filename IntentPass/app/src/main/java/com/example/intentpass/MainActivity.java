package com.example.intentpass;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView mainTitle, welcomeTxt;
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainTitle = findViewById(R.id.mainTitle);
        welcomeTxt = findViewById(R.id.welcomeTxt);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start SecondActivity
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Put data into the Intent
                intent.putExtra("Student name", "Tanvir Hossain")
                        .putExtra("Department", "AI")
                        .putExtra("ID", 23121478)
                        .putExtra("Semester", 3)
                        .putExtra("isEnrolled", true);

                // Start the SecondActivity
                startActivity(intent);
            }
        });
    }
}