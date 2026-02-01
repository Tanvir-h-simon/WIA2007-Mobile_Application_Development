package com.example.relativelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    // Declare UI components
    private TextView usernameLabel;
    private EditText usernameInput;
    private EditText passwordLabel;
    private EditText passwordInput;
    private Button loginButton;
    private CheckBox rememberMeCheckbox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

        // Initialize UI components
        usernameLabel = findViewById(R.id.usernameLabel);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginButton);
        rememberMeCheckbox = findViewById(R.id.rememberMeCheckbox);

        // Handle login button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                boolean rememberMe = rememberMeCheckbox.isChecked();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter valid username and password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this,
                        "Username: " + username + "\n" +
                                "Password: " + password + "\n" +
                                "Remember Me: " + (rememberMe ? "Yes" : "No"),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}