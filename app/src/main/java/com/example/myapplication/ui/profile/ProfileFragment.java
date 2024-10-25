package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        // Find the button using findViewById
        Button editProfileButton = root.findViewById(R.id.buttonEdit);

        // Set an OnClickListener to navigate to EditProfileFragment
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profileFragment_to_editProfileFragment);
            }
        });

        return root;
    }
}
