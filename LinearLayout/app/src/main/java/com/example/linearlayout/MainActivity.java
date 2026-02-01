package com.example.linearlayout;

// Android core classes
import android.os.Bundle;
import android.view.View;

// UI widget classes
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

// AppCompat provides backward compatibility and lifecycle support
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    // Declare the UI variables
    EditText myEditText;
    Button myButton;
    TextView myTextView;
    RadioGroup myRadioGroup;
    SwitchCompat mySwitch;
    ToggleButton myToggleButton;
    Spinner mySpinner;
    AutoCompleteTextView myAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // onCreate() is called when the Activity is created.
        super.onCreate(savedInstanceState);

        // Set the layout for the activity (Connect the XML file to the activity)
        setContentView(R.layout.activity_main);

        // Connect XML views to Java objects
        // findViewById() searches the loaded layout for the given ID
        myTextView = findViewById(R.id.myTextView);
        myEditText = findViewById(R.id.myEditText);
        myButton = findViewById(R.id.myButton);
        myRadioGroup = findViewById(R.id.myRadioGroup);
        mySwitch = findViewById(R.id.mySwitch);
        myToggleButton = findViewById(R.id.myToggleButton);
        mySpinner = findViewById(R.id.mySpinner);
        myAutoComplete = findViewById(R.id.myAutoComplete);

        // Handle Button Click: setOnClickListener() defines what happens when button is pressed
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Read text from EditText
                String inputText = myEditText.getText().toString();
                // Update TextView with input
                myTextView.setText("Button Clicked! Input: " + inputText);
                // Show a toast(popup) message
                Toast.makeText(MainActivity.this,
                        "Button Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Handle RadioGroup selection
        myRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check if no radio button is selected
                if (checkedId == -1) return;

                // Convert selected ID into a RadioButton object
                RadioButton selectedRadioButton = findViewById(checkedId);
                // Read text from the selected RadioButton
                String selectedText = selectedRadioButton.getText().toString();
                // Show feedback using Toast
                Toast.makeText(MainActivity.this,
                        "Selected: " + selectedRadioButton.getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Switch state change
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Determine switch status
                String status = isChecked ? "Enabled" : "Disabled";

                // Show feedback using Toast
                Toast.makeText(MainActivity.this,
                        "Switch: " + status,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Handle ToggleButton state change
        myToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean on = myToggleButton.isChecked();
                Toast.makeText(MainActivity.this,
                        "Toggle: " + (on ? "ON" : "OFF"),
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Spinner selection
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get selected item from Spinner
                String selected = parent.getItemAtPosition(position).toString();
                // Show selected item using Toast
                Toast.makeText(MainActivity.this,
                        "Spinner: " + selected,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            // onNothingSelected() is called when no item is selected in the AdapterView.
        });

        // Load string array from strings.xml
        String[] suggestions = getResources().getStringArray(R.array.suggestions_array);
        // Create an ArrayAdapter using the string array and a default layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, suggestions);
        // Set the adapter for the AutoCompleteTextView
        myAutoComplete.setAdapter(adapter);
        // Set the threshold(minimum number of characters to type before showing suggestions) for the AutoCompleteTextView
        myAutoComplete.setThreshold(1);
    }
}