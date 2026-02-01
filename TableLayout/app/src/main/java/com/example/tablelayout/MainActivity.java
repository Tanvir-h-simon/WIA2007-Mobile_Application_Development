package com.example.tablelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText marks1, marks2, marks3;
    TextView totalMarksValue, averageValue;
    Button calcGrade;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marks1 = findViewById(R.id.marks1);
        marks2 = findViewById(R.id.marks2);
        marks3 = findViewById(R.id.marks3);

        totalMarksValue = findViewById(R.id.totalMarksValue);
        averageValue = findViewById(R.id.averageValue);
        calcGrade = findViewById(R.id.calcGrade);


        calcGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m1 = marks1.getText().toString();
                String m2 = marks2.getText().toString();
                String m3 = marks3.getText().toString();

                if (m1.isEmpty() || m2.isEmpty() || m3.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Enter all marks",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double mark1 = Double.parseDouble(m1);
                double mark2 = Double.parseDouble(m2);
                double mark3 = Double.parseDouble(m3);

                double totalMarks = mark1 + mark2 + mark3;
                double avg = totalMarks / 3;

                totalMarksValue.setText(String.valueOf(totalMarks));
                averageValue.setText(String.format("%.2f", avg));
            }
        });
    }
}