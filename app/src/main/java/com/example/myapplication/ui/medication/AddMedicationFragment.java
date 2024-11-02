package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddMedicationBinding;
import com.example.myapplication.ui.alarms.AddAlarmsFragment;
import com.example.myapplication.ui.alarms.AlarmsViewModel;

public class AddMedicationFragment extends Fragment {

    private FragmentAddMedicationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Back button click listener
        binding.backButton.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        // Save button click listener
        binding.saveButton.setOnClickListener(v -> {
            // Create the AlertDialog
            new AlertDialog.Builder(requireContext())
                    .setTitle("Add medication")
                    .setMessage("Are you sure you want to add this medicine?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Navigate to AlarmsFragment on confirmation
                        Toast.makeText(getContext(), "Medication saved", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(AddMedicationFragment.this)
                                .navigate(R.id.action_addMedicationFragment_to_medicationFragment);
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        // Close the dialog without any action
                        dialog.dismiss();
                    })
                    .show();


            // In a real app, you would save the data here

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
