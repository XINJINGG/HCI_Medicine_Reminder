package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

public class EditMedicationDetailsFragment extends Fragment {

    private EditText editMedName, editMedPurpose, editMedLocation, editMedDosage, editMedStockCount, editMedPillsLeft, editMedFrequency;
    private ImageView editMedImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_medication_details, container, false);

        // Initialize the TextInputLayouts and get their EditTexts
        TextInputLayout editMedNameLayout = view.findViewById(R.id.edit_med_name_layout);
        TextInputLayout editMedPurposeLayout = view.findViewById(R.id.edit_med_description_layout);
        TextInputLayout editMedLocationLayout = view.findViewById(R.id.edit_med_location_layout);
        TextInputLayout editMedDosageLayout = view.findViewById(R.id.edit_med_dosage_layout);
        TextInputLayout editMedStockCountLayout = view.findViewById(R.id.edit_med_stock_layout);
        TextInputLayout editMedPillsLeftLayout = view.findViewById(R.id.edit_med_pills_left_layout);
        TextInputLayout editMedFrequencyLayout = view.findViewById(R.id.edit_med_frequency_layout); // Frequency input field

        editMedName = editMedNameLayout.getEditText();
        editMedPurpose = editMedPurposeLayout.getEditText();
        editMedLocation = editMedLocationLayout.getEditText();
        editMedDosage = editMedDosageLayout.getEditText();
        editMedStockCount = editMedStockCountLayout.getEditText();
        editMedPillsLeft = editMedPillsLeftLayout.getEditText();
        editMedFrequency = editMedFrequencyLayout.getEditText(); // Frequency EditText
        editMedImage = view.findViewById(R.id.edit_med_img);

        // Retrieve and set the arguments
        if (getArguments() != null) {
            String medicineName = getArguments().getString("medicineName");
            String medicinePurpose = getArguments().getString("medicinePurpose");
            String medicineLocation = getArguments().getString("medicineLocation");
            int dosage = getArguments().getInt("medicineDosage", 0);
            String frequency = getArguments().getString("medicineFrequency", "Once a day"); // Retrieve frequency from Bundle
            int stockCount = getArguments().getInt("medicineStockCount", 100);
            int pillsLeft = getArguments().getInt("medicinePillsLeft", 0);
            int medicineImageResId = getArguments().getInt("medicineImageResId", -1);
            if (medicineImageResId == -1) {
                // Set a default image if the passed resource ID is invalid
                medicineImageResId = android.R.drawable.ic_menu_gallery;  // Set an appropriate default image resource
            }

            // Set the data to the fields
            if (editMedName != null) editMedName.setText(medicineName);
            if (editMedPurpose != null) editMedPurpose.setText(medicinePurpose);
            if (editMedLocation != null) editMedLocation.setText(medicineLocation);
            if (editMedDosage != null) editMedDosage.setText(String.valueOf(dosage));
            if (editMedStockCount != null) editMedStockCount.setText(String.valueOf(stockCount));
            if (editMedPillsLeft != null) editMedPillsLeft.setText(String.valueOf(pillsLeft));
            if (editMedFrequency != null) editMedFrequency.setText(String.valueOf(frequency)); // Set frequency
            editMedImage.setImageResource(medicineImageResId); // Set the image resource
        }

        // Find the Save button and set an OnClickListener
        Button saveButton = view.findViewById(R.id.edit_med_saveBtn);
        saveButton.setOnClickListener(v -> showConfirmationDialog(view));

        return view;
    }

    private void showConfirmationDialog(View view) {
        // Create an AlertDialog to show a confirmation message
        new AlertDialog.Builder(requireContext())
                .setTitle("Save Changes")
                .setMessage("The medication details have been successfully changed.")
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    // Navigate back to the previous page
                    Navigation.findNavController(view).popBackStack();
                })
                .show();
    }
}
