package com.example.myapplication.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;
import com.example.myapplication.ui.account.Login;
import com.example.myapplication.ui.medication.AddMedicationFragment;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the edit profile button using findViewById
        Button editProfileButton = root.findViewById(R.id.buttonEdit);

        ImageView imageViewBadge = root.findViewById(R.id.imageViewBadge);

        // Retrieve claim status from SharedPreferences
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("BadgePrefs", Context.MODE_PRIVATE);
        boolean badge0Claimed = sharedPreferences.getBoolean("badge0Claimed", false);


        // If badge0 is claimed, display the twoday image
        if (badge0Claimed) {
            imageViewBadge.setImageResource(R.drawable.twoday);
        }
        // Set an OnClickListener to navigate to EditProfileFragment
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profileFragment_to_editProfileFragment);
            }


        });

        // Handle Logout button
        Button logoutButton = root.findViewById(R.id.buttonLogout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(requireContext())
                        .setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Navigate to AlarmsFragment on confirmation
                            Toast.makeText(getContext(), "Logged out!", Toast.LENGTH_SHORT).show();
                            // Clear login status
                            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPreferences", getActivity().MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLoggedIn", false);
                            editor.apply();

                            // Start the Login Activity and clear the back stack so the user cannot return
                            Intent intent = new Intent(getActivity(), Login.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                            // Optionally, close the fragment's parent activity (if needed)
                            getActivity().finish();
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Close the dialog without any action
                            dialog.dismiss();
                        })
                        .show();

            }
        });



        return root;
    }
}