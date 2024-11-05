package com.example.myapplication.ui.rewards;

import android.content.res.ColorStateList;
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
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
        boolean isBadge0 = false; // Default to false
        // Retrieve data from arguments
        if (getArguments() != null) {
            int imageResId = getArguments().getInt("imageResId");
            String text = getArguments().getString("text");
            String text2 = getArguments().getString("text2");
            String text3 = getArguments().getString("text3");
            isBadge0 = getArguments().getBoolean("isBadge0", false); // Retrieve flag

            // Set the image and text
            imageView.setImageResource(imageResId);
            textView.setText(text);
            textView1.setText(text2);
            textView2.setText(text3);
        }

        if (isBadge0) {
            unavailableButton.setOnClickListener(v -> {

                // Send result back to RewardsFragment to hide Badge0
                getParentFragmentManager().setFragmentResult("claimBadge0", new Bundle());
                Toast.makeText(getContext(), "Badge claimed successfully!", Toast.LENGTH_SHORT).show();
                // Navigate back to RewardsFragment
                NavHostFragment.findNavController(ClaimableBadges.this).popBackStack();




            });
        } else {
            // If the badge is not earned, disable the button and set the gray color
            unavailableButton.setEnabled(false);
            unavailableButton.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), android.R.color.darker_gray))); // Set to gray color
            unavailableButton.setOnClickListener(v ->
                    Toast.makeText(getContext(), "You have not earned this yet!", Toast.LENGTH_SHORT).show()
            );
        }
    }

}
