package com.example.constraintlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText weightInput;
    private EditText heightInput;
    private Button calculateButton;
    private TextView bmiResult;
    private TextView bmiCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weight_input);
        heightInput = findViewById(R.id.height_input);
        calculateButton = findViewById(R.id.calculate_button);
        bmiResult = findViewById(R.id.bmi_result);
        bmiCategory = findViewById(R.id.bmi_category);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    public void calculateBMI() {
        String weightString = weightInput.getText().toString().trim();
        String heightString = heightInput.getText().toString().trim();

        if (weightString.isEmpty() || heightString.isEmpty()) {
            Toast.makeText(this,
                    "Please enter both weight and height",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float weight = Float.parseFloat(weightString);
            float heightCm = Float.parseFloat(heightString);

            if (heightCm <= 0 || weight <= 0) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            // Convert height from cm to meters
            float heightMeters = heightCm / 100;

            // BMI Formula: weight (kg) / [height (m)]^2
            float bmi = weight / (heightMeters * heightMeters);

            bmiResult.setText(String.format("BMI: %.2f", bmi));
            bmiCategory.setText(getBMICategory(bmi));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input format", Toast.LENGTH_SHORT).show();
        }
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}