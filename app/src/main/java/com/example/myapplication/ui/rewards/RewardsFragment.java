package com.example.myapplication.ui.rewards;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRewardsBinding;
import com.example.myapplication.ui.profile.ProfileFragment;

public class RewardsFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_rewards, container, false);

        CardView badge1 = root.findViewById(R.id.Badge1);
        CardView badge2 = root.findViewById(R.id.Badge2);
        CardView badge3 = root.findViewById(R.id.Badge3);
        Button findOutMoreButton = root.findViewById(R.id.buttonGuide);

        badge1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a bundle with specific data for Badge1
                Bundle bundle = new Bundle();
                bundle.putInt("imageResId", R.drawable.image1); // Image for Badge1
                bundle.putString("text", "1 Week Champion Badge"); // Text for Badge1
                bundle.putString("text2", "Have a 1 week streak to get this badge");
                bundle.putString("text3", "You need 7 more days!");

                NavHostFragment.findNavController(RewardsFragment.this)
                        .navigate(R.id.action_rewardFragment_to_claimablebadgeFragment, bundle);
            }
        });

        findOutMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the custom layout for the dialog
                LayoutInflater inflater = LayoutInflater.from(requireContext());
                View dialogView = inflater.inflate(R.layout.dialog_how_it_works, null);

                // Create the AlertDialog using the custom layout
                AlertDialog dialog = new AlertDialog.Builder(requireContext())
                        .setView(dialogView)
                        .create();

                // Set up the close button inside the dialog
                Button closeButton = dialogView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss(); // Close the dialog when the close button is clicked
                    }
                });

                // Show the dialog
                dialog.show();
            }
        });

        badge2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a bundle with specific data for Badge2
                Bundle bundle = new Bundle();
                bundle.putInt("imageResId", R.drawable.image2); // Image for Badge2
                bundle.putString("text", "Monthly Champion Badge"); // Text for Badge2
                bundle.putString("text2", "Have a 30 day streak to get this badge");
                bundle.putString("text3", "You need 23 more days!");

                // Navigate and pass the bundle
                NavHostFragment.findNavController(RewardsFragment.this)
                        .navigate(R.id.action_rewardFragment_to_claimablebadgeFragment, bundle);
            }
        });

        badge3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a bundle with specific data for Badge2
                Bundle bundle = new Bundle();
                bundle.putInt("imageResId", R.drawable.image3); // Image for Badge2
                bundle.putString("text", "Consisntency Champion"); // Text for Badge2
                bundle.putString("text2", "Have a 90 day streak to get this badge");
                bundle.putString("text3", "You need 87 more days!");

                // Navigate and pass the bundle
                NavHostFragment.findNavController(RewardsFragment.this)
                        .navigate(R.id.action_rewardFragment_to_claimablebadgeFragment, bundle);
            }
        });



        return root;
    }

}
