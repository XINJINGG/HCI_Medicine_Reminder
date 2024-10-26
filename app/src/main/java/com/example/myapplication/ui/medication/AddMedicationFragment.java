package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentAddMedicationBinding;

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
            // In a real app, you would save the data here
            Toast.makeText(getContext(), "Medication saved", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
