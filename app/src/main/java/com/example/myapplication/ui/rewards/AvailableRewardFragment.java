package com.example.myapplication.ui.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class AvailableRewardFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_availablereward, container, false);

        Button unavailableButton = root.findViewById(R.id.buttonUnavailable);
        unavailableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a simple prompt when the button is clicked
                Toast.makeText(getContext(), "You have not earned this reward yet!", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

}
