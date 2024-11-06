package com.example.myapplication.ui.medication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.R;

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
        Button editButton = view.findViewById(R.id.med_details_edit_btn); // Assuming you've added an edit button in your layout


        // Retrieve arguments
        if (getArguments() != null) {
            String medicineName = getArguments().getString("medicineName");
            String medicinePurpose = getArguments().getString("medicinePurpose");
            String medicineLocation = getArguments().getString("medicineSource");
            int dosage = getArguments().getInt("medicineDosage", 0); // Ensure you get dosage correctly
            int stockCount = getArguments().getInt("medicineStockCount", 100); // Ensure you get stock count correctly
            int pillsLeft = getArguments().getInt("medicinePillsLeft", 0); // New variable for pills left
            int medicineImage = getArguments().getInt("medicineImageResId", -1);
            int progressValue = getArguments().getInt("medicinePercentage", 0); // Get the percentage value


            // Set data to views
            medDetailsImg.setImageResource(medicineImage); // Set image
            medDetailsName.setText(medicineName);
            medDetailsDescription.setText("Description: " + medicinePurpose);
            medDetailsLocation.setText("Obtained from: " + medicineLocation);
            medDetailsDosage.setText("Dosage: " + dosage + " mg"); // Assuming dosage is in mg
            medDetailsStockCount.setText("Stock Count: " + stockCount);
            medDetailsPillsLeft.setText("Pills Left: " + progressValue); // Display pills left

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
                // Create a bundle to pass data to the edit fragment
                Bundle bundle = new Bundle();

                // Extract values after the colon
                String nameValue = medDetailsName.getText().toString();
                String purposeValue = medDetailsDescription.getText().toString().split(": ")[1]; // Gets text after "Description:"
                String locationValue = medDetailsLocation.getText().toString().split(": ")[1];   // Gets text after "Obtained from:"
                int dosageValue = Integer.parseInt(medDetailsDosage.getText().toString().split(" ")[1]);
                int stockCountValue = Integer.parseInt(medDetailsStockCount.getText().toString().split(": ")[1]);
                int pillsLeftValue = Integer.parseInt(medDetailsPillsLeft.getText().toString().split(": ")[1]);

                // Populate bundle with cleaned values
                bundle.putString("medicineName", nameValue);
                bundle.putString("medicinePurpose", purposeValue);
                bundle.putString("medicineLocation", locationValue);
                bundle.putInt("medicineDosage", dosageValue);
                bundle.putInt("medicineStockCount", stockCountValue);
                bundle.putInt("medicinePillsLeft", pillsLeftValue);
                bundle.putInt("medicineImageResId", medicineImage);

                // Navigate to the edit fragment
                Navigation.findNavController(view).navigate(R.id.action_medicineDetailsFragment_to_editMedicationDetailsFragment, bundle);
            });

        }



        return view;
    }
}
