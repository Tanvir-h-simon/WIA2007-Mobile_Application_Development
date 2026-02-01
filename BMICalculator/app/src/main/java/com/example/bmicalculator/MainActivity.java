package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    private EditText weightInput, heightFtInput, heightInInput;
    private Button calculateButton;
    private MaterialCardView resultCard;
    private TextView bmiResult, bmiCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weight_input);
        heightFtInput = findViewById(R.id.height_ft_input);
        heightInInput = findViewById(R.id.height_in_input);
        calculateButton = findViewById(R.id.calculate_button);
        resultCard = findViewById(R.id.result_card);
        bmiResult = findViewById(R.id.bmi_result);
        bmiCategory = findViewById(R.id.bmi_category);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        float weight = Float.parseFloat(weightStr);
        String feetStr = heightFtInput.getText().toString();
        String inchesStr = heightInInput.getText().toString();

        if (weightStr.isEmpty() || feetStr.isEmpty() || inchesStr.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }


        int feet = Integer.parseInt(feetStr);
        int inches = Integer.parseInt(inchesStr);

        // Convert height to meters: (feet * 12 + inches) * 0.0254
        float totalInches = (feet * 12) + inches;
        float heightInMeters = totalInches * 0.0254f;

        if (heightInMeters > 0) {
            float bmi = weight / (heightInMeters * heightInMeters);
            displayResult(bmi);
        } else {
            Toast.makeText(this, "Invalid height", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayResult(float bmi) {
        resultCard.setVisibility(View.VISIBLE);
        bmiResult.setText(String.format("%.1f", bmi));

        String category;
        int color;

        if (bmi < 18.5) {
            category = "Underweight";
            color = R.color.colorUnderweight;
        } else if (bmi < 25) {
            category = "Healthy";
            color = R.color.colorHealthy;
        } else if (bmi < 30) {
            category = "Overweight";
            color = R.color.colorOverweight;
        } else {
            category = "Obese";
            color = R.color.colorObese;
        }

        bmiCategory.setText(category);
        resultCard.setCardBackgroundColor(ContextCompat.getColor(this, color));
    }
}