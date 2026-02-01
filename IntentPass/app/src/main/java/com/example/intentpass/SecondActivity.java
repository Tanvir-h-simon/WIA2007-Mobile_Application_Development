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

public class SecondActivity extends AppCompatActivity {
    private TextView secondTitle;
    private TextView studentName, studentID, studentDept, studentSem;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        secondTitle = findViewById(R.id.secondTitle);
        backBtn = findViewById(R.id.backButton);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        // Get the data from the Intent
        String name = intent.getStringExtra("Student name");
        String department = intent.getStringExtra("Department");
        int id = intent.getIntExtra("ID", 0);
        int semester = intent.getIntExtra("Semester", 0);
        boolean isEnrolled = intent.getBooleanExtra("isEnrolled", false);

        studentName = findViewById(R.id.studentName);
        studentID = findViewById(R.id.studentID);
        studentDept = findViewById(R.id.studentDept);
        studentSem = findViewById(R.id.studentSem);
        
        studentName.setText("Name: " + name);
        studentID.setText("ID: " + String.valueOf(id));
        studentDept.setText("Department: " + department);
        studentSem.setText("Semester: " + String.valueOf(semester));


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start MainActivity
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                // Start the MainActivity
                startActivity(intent);
            }
        });
    }
}