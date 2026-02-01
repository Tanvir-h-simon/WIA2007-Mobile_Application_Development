package com.example.navigationdrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if (getArguments() != null) {
            String message = getArguments().getString("message");
            int number = getArguments().getInt("number");
            
            Log.d("HomeFragment", "Message: " + message);
            Log.d("HomeFragment", "Number: " + number);

            TextView textView = view.findViewById(R.id.fragment_text);
            if (textView != null) {
                textView.setText(message + " " + number);
            }
        }
        return view;
    }
}