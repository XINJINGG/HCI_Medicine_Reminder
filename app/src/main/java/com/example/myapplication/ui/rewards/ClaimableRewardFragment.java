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

public class ClaimableRewardFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_claimablereward, container, false);

        Button claimButton = root.findViewById(R.id.buttonClaim);
        claimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a simple prompt when the button is clicked
                Toast.makeText(getContext(), "Reward Claimed!", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

}
