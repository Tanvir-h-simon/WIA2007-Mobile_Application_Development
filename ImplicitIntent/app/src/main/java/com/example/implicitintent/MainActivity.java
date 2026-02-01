package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnDial, btnEmail, btnMsg, btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDial = findViewById(R.id.btnDial);
        btnEmail = findViewById(R.id.btnEmail);
        btnMsg = findViewById(R.id.btnMsg);
        btnShare = findViewById(R.id.btnShare);

        // Dial Button
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel:01700000000"));
                startActivity(iDial);
            }
        });

        // Message Button
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                iMsg.setData(Uri.parse("smsto:01700000000"));
                iMsg.putExtra("sms_body", "Hi, please solve this issue.");
                startActivity(iMsg);
            }
        });

        // Email Button
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SENDTO);
                iEmail.setData(Uri.parse("mailto:"));
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"benjaminharrison@myownpersonaldomain.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries about app");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Hi, please solve this issue");

                try {
                    startActivity(Intent.createChooser(iEmail, "Send Email"));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "No email app found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Share Button
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Hi, please solve this issue");
                startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });
    }
}