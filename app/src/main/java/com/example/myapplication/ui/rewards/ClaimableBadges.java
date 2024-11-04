package com.example.myapplication.ui.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ClaimableBadges extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_claimablebadge, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageView = view.findViewById(R.id.imageViewBadge);
        TextView textView = view.findViewById(R.id.textViewBadge);
        TextView textView1 = view.findViewById(R.id.textViewBadgeinfo);
        TextView textView2 = view.findViewById(R.id.textViewBadgeDays);
        Button unavailableButton = view.findViewById(R.id.buttonClaim);


        // Retrieve data from arguments
        if (getArguments() != null) {
            int imageResId = getArguments().getInt("imageResId");
            String text = getArguments().getString("text");
            String text2 = getArguments().getString("text2");
            String text3 = getArguments().getString("text3");

            // Set the image and text
            imageView.setImageResource(imageResId);
            textView.setText(text);
            textView1.setText(text2);
            textView2.setText(text3);
        }

        // Set the button logic here
        unavailableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Example logic for the button click
                Toast.makeText(getContext(), "You have not earned this yet!", Toast.LENGTH_SHORT).show();

                // You can add more actions here, such as navigating to another fragment,
                // updating the UI, or performing other tasks as needed
            }
        });
    }

}
