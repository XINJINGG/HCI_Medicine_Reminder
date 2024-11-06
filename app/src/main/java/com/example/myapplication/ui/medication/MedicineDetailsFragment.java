package com.example.myapplication.ui.medication;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.appcompat.app.AlertDialog;
import com.example.myapplication.R;

import java.util.Objects;

public class MedicineDetailsFragment extends Fragment {

    private ImageView medDetailsImg;
    private TextView medDetailsName, medDetailsDescription, medDetailsLocation;
    private TextView medDetailsDosage, medDetailsFrequency, medDetailsStockCount, medDetailsPillsLeft;

    // Color constants
    private static final int RED_COLOR = Color.parseColor("#F08080"); // Light Coral
    private static final int GREEN_COLOR = Color.GREEN; // Standard green

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_details, container, false);

        // Initialize views
        medDetailsImg = view.findViewById(R.id.med_details_img);
        medDetailsName = view.findViewById(R.id.med_details_name);
        medDetailsDescription = view.findViewById(R.id.med_details_description);
        medDetailsLocation = view.findViewById(R.id.med_details_location);
        medDetailsDosage = view.findViewById(R.id.med_details_dosage);
        medDetailsFrequency = view.findViewById(R.id.med_details_frequency);
        medDetailsStockCount = view.findViewById(R.id.med_details_stock_count);
        medDetailsPillsLeft = view.findViewById(R.id.med_details_pills_left);

        // Initialize ProgressBar and Percentage TextView
        ProgressBar medDetailsProgressBar = view.findViewById(R.id.med_details_progress_bar);
        TextView medDetailsProgressPercentage = view.findViewById(R.id.med_details_progress_percentage);

        // Initialize Edit button
        Button editButton = view.findViewById(R.id.med_details_edit_btn);

        // Initialize Delete button
        Button deleteButton = view.findViewById(R.id.med_details_delete_btn); // Assuming you've added a delete button in your layout

        // Retrieve arguments
        if (getArguments() != null) {

            String medicineName = getArguments().getString("medicineName");

            String medicinePurpose = getArguments().getString("medicinePurpose", "");
            if (Objects.equals(medicinePurpose, "")) {
               medicinePurpose = getArguments().getString("medicineDetails", "");
            }

            String medicineLocation = getArguments().getString("medicineSource", "");
            if (Objects.equals(medicineLocation, "")) {
                medicineLocation = getArguments().getString("medicineLocations", "");
            }
            // Check if medicineLocation contains a colon and extract the value after it
            if (medicineLocation.contains(":")) {
                medicineLocation = medicineLocation.split(":", 2)[1].trim(); // Get the text after the first colon and trim any whitespace
            }

            String dosage = getArguments().getString("medicineDetails", "500mg");
            if (Objects.equals(dosage, "0")) {
                dosage = getArguments().getString("medicineDetails", "500mg");
            }
            // Extract the number part before "mg"
            if (dosage.contains("mg")) {
                dosage = dosage.split("mg")[0]; // Get the part before the space (i.e., the number)
            }
            medDetailsDosage.setText("Dosage: " + dosage + " mg"); // Set the dosage without any extra space or characters


            String medicineFrequency = getArguments().getString("medicineDetails", "Once a day");
            // Check if the string contains the bullet character
            if (medicineFrequency != null && medicineFrequency.contains("\u2022")) {
                int bulletIndex = medicineFrequency.indexOf("\u2022");

                // If the bullet is found, get the substring after it
                if (bulletIndex != -1) {
                    medicineFrequency = medicineFrequency.substring(bulletIndex + 1).trim();
                }
            }
            medDetailsFrequency.setText(medicineFrequency);


            medDetailsFrequency.setText(medicineFrequency);



            String stockCount = getArguments().getString("pillsLeft", "100");
            // Check if stockCount contains "out of" and extract the value after it
            if (stockCount.contains(" out of ")) {
                stockCount = stockCount.split("out of ")[1].trim(); // Get the value after "out of"
                // Remove the last two words after trimming
                String[] words = stockCount.split(" ");
                if (words.length > 2) {
                    StringBuilder newStockCount = new StringBuilder();
                    for (int i = 0; i < words.length - 2; i++) {
                        newStockCount.append(words[i]).append(" ");
                    }
                    stockCount = newStockCount.toString().trim(); // Trim to remove any trailing space
                }
            }
            medDetailsStockCount.setText("Stock Count: " + stockCount);


            int medicineImage = getArguments().getInt("medicineImageResId", -1);
            if (medicineImage != -1) {
                medDetailsImg.setImageResource(medicineImage);
            } else {
                medDetailsImg.setImageResource(android.R.drawable.ic_menu_gallery); // Use a default image
            }


            int progressValue = getArguments().getInt("medicinePercentage", 0);

            String pillsLeft = getArguments().getString("pillsLeft", "0");
            // Check if pillsLeft contains "out of" and extract the number before it
            if (pillsLeft.contains(" out of ")) {
                pillsLeft = pillsLeft.split(" out of")[0].trim(); // Get the value before "out of"
            }
            // If pillsLeft is still "0", set it to the progressValue instead
            if (Objects.equals(pillsLeft, "0")) {
                pillsLeft = String.valueOf(progressValue);
            }

            medDetailsPillsLeft.setText("Pills Left: " + pillsLeft);

            try {
                // Parse pillsLeft and stockCount
                int pillsLeftValue = Integer.parseInt(pillsLeft);
                int stockCountValue = Integer.parseInt(stockCount);

                // Calculate progress if it's 0
                if (progressValue == 0 && stockCountValue > 0) {
                    progressValue = (int) ((double) pillsLeftValue / stockCountValue * 100);
                }

                // Set progress bar and percentage text
                medDetailsProgressBar.setProgress(progressValue);
                medDetailsProgressPercentage.setText(progressValue + "%");

                // Change progress color based on percentage
                if (progressValue < 30) {
                    medDetailsProgressBar.setIndeterminateTintList(ColorStateList.valueOf(RED_COLOR));
                } else {
                    medDetailsProgressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
                }

            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle any error if parsing fails (optional)
            }

            // Set data to views
            medDetailsName.setText(medicineName);
            medDetailsDescription.setText("Description: " + medicinePurpose);
            medDetailsLocation.setText("Obtained from: " + medicineLocation);
            medDetailsDosage.setText("Dosage: " + dosage + " mg");
            medDetailsFrequency.setText("Frequency: " + medicineFrequency);
            medDetailsStockCount.setText("Stock Count: " + stockCount);
            medDetailsPillsLeft.setText("Pills Left: " + pillsLeft);

            // Set progress bar and percentage text
            medDetailsProgressBar.setProgress(progressValue);
            medDetailsProgressPercentage.setText(progressValue + "%");


            // Change progress color based on percentage
            if (progressValue < 30) {
                medDetailsProgressBar.setIndeterminateTintList(ColorStateList.valueOf(RED_COLOR));
            } else {
                medDetailsProgressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
            }

            // Set up the click listener for the edit button
            editButton.setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                String nameValue = medDetailsName.getText().toString();
                String purposeValue = medDetailsDescription.getText().toString().split(": ")[1];
                String locationValue = medDetailsLocation.getText().toString().split(": ")[1];
                int dosageValue = Integer.parseInt(medDetailsDosage.getText().toString().split(" ")[1]);
                String frequency = medDetailsFrequency.getText().toString().split(": ")[1];
                int stockCountValue = Integer.parseInt(medDetailsStockCount.getText().toString().split(": ")[1]);
                int pillsLeftValue = Integer.parseInt(medDetailsPillsLeft.getText().toString().split(": ")[1]);

                bundle.putInt("medicineImageResId", medicineImage);
                bundle.putString("medicineName", nameValue);
                bundle.putString("medicinePurpose", purposeValue);
                bundle.putString("medicineLocation", locationValue);
                bundle.putInt("medicineDosage", dosageValue);
                bundle.putString("medicineFrequency",frequency);
                bundle.putInt("medicineStockCount", stockCountValue);
                bundle.putInt("medicinePillsLeft", pillsLeftValue);

                Navigation.findNavController(view).navigate(R.id.action_medicineDetailsFragment_to_editMedicationDetailsFragment, bundle);
            });

            // Set up the click listener for the delete button
            deleteButton.setOnClickListener(v -> showDeleteConfirmationDialog(view));

        }

        return view;
    }

    private void showDeleteConfirmationDialog(View view) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Delete Medication")
                .setMessage("Are you sure you want to delete this medication?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Perform the deletion operation here
                    // For example, if you're using an adapter for RecyclerView, call the remove method

                    // Show a notification
                    showDeletionNotification();

                    // Navigate back to the previous screen
                    Navigation.findNavController(view).popBackStack();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss()) // Close the dialog if No is clicked
                .show();
    }

    private void showDeletionNotification() {
        // You can use a Toast or Snackbar to show the notification
        Toast.makeText(getContext(), "Medication has been deleted", Toast.LENGTH_SHORT).show();
    }
}
