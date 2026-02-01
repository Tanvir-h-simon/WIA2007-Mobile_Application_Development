package com.example.database;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbhelper = new DBHelper(this);

        // Adding contacts
        dbhelper.addContact("Tanvir", "1234394556");
        dbhelper.addContact("Hossain", "4314394556");
        dbhelper.addContact("Simon", "54402340432");
        
        Log.d("Database", "Contacts added successfully");
    }
}