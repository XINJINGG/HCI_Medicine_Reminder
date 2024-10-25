package com.example.myapplication.ui.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;
import com.example.myapplication.ui.account.Login;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the edit profile button using findViewById
        Button editProfileButton = root.findViewById(R.id.buttonEdit);
        Button logoutButton = root.findViewById(R.id.buttonLogout); // Add this line

        // Set an OnClickListener to navigate to EditProfileFragment
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profileFragment_to_editProfileFragment);
            }
        });

        // Set an OnClickListener to handle logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear login status from SharedPreferences
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("UserPreferences", getContext().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                // Redirect to LoginActivity
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish(); // Close the current activity
            }
        });

        return root;
    }
}