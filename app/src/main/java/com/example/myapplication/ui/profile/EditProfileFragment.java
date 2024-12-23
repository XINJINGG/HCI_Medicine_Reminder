package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.medication.AddMedicationFragment;

public class EditProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_editprofile, container, false);

        Button cancelButton = root.findViewById(R.id.buttonCancel);
        Button saveButton = root.findViewById(R.id.buttonSave);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(EditProfileFragment.this)
                        .navigate(R.id.action_editProfileFragment_to_profileFragment);
            }


        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create the AlertDialog
                new AlertDialog.Builder(requireContext())
                        .setTitle("Edit Profile")
                        .setMessage("Save Changes?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            Toast.makeText(getContext(), "Saved!", Toast.LENGTH_SHORT).show();
                            NavHostFragment.findNavController(EditProfileFragment.this)
                                    .navigate(R.id.action_editProfileFragment_to_profileFragment);
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Close the dialog without any action
                            dialog.dismiss();
                        })
                        .show();

            }


        });



        // Enable the Up button in the toolbar
        setHasOptionsMenu(true);  // Enable fragment to add menu items

        return root;
    }

    // Handle the back arrow press in the ActionBar
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Enable the up button in the ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
