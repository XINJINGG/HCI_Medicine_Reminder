package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddMedicationBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddMedicationFragment extends Fragment {

    private FragmentAddMedicationBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize Save button as disabled
        binding.saveButton.setEnabled(false);

        // Add TextWatchers to required fields
        addTextWatchers();

        // Back button click listener
        binding.backButton.setOnClickListener(v -> {
            getActivity().onBackPressed();
        });

        // Save button click listener
        binding.saveButton.setOnClickListener(v -> {
            // Confirm the action with AlertDialog
            new AlertDialog.Builder(requireContext())
                    .setTitle("Add medication")
                    .setMessage("Are you sure you want to add this medicine?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(getContext(), "Medication saved", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(AddMedicationFragment.this)
                                .navigate(R.id.action_addMedicationFragment_to_medicationFragment);
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        return root;
    }

    // Method to add TextWatchers to required fields
    private void addTextWatchers() {
        // Add TextWatchers for all relevant input fields
        binding.medicineNameInput.addTextChangedListener(textWatcher);
        binding.descriptionInput.addTextChangedListener(textWatcher);
        binding.locationInput.addTextChangedListener(textWatcher);
        binding.dosageInput.addTextChangedListener(textWatcher);
        binding.frequencyInput.addTextChangedListener(textWatcher);
        binding.pillsLeftInput.addTextChangedListener(textWatcher);
    }

    // TextWatcher to enable or disable the Save button based on field validation
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // Check all fields whenever there is a text change
            binding.saveButton.setEnabled(areAllFieldsValid());
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    // Helper method to check if a field is empty and set error message
    private boolean isFieldEmpty(TextInputLayout layout, String errorMessage) {
        TextInputEditText editText = (TextInputEditText) layout.getEditText();
        if (editText != null && editText.getText().toString().trim().isEmpty()) {
            layout.setError(errorMessage);
            return true;
        } else {
            layout.setError(null); // Clear error if valid
            return false;
        }
    }

    // Method to validate all fields
    private boolean areAllFieldsValid() {
        boolean isValid = true;

        // Validate all fields
        if (isFieldEmpty(binding.medicineNameInputLayout, "Medicine Name is required")) isValid = false;
        if (isFieldEmpty(binding.descriptionInputLayout, "Description is required")) isValid = false;
        if (isFieldEmpty(binding.locationInputLayout, "Location is required")) isValid = false;
        if (isFieldEmpty(binding.dosageInputLayout, "Dosage is required")) isValid = false;
        if (isFieldEmpty(binding.frequencyInputLayout, "Frequency is required")) isValid = false;
        if (isFieldEmpty(binding.pillsLeftInputLayout, "Pills Left is required")) isValid = false;

        return isValid;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


