package com.example.myapplication.ui.medication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

        // Retrieve arguments
        if (getArguments() != null) {
            String medicineName = getArguments().getString("medicineName");
            String medicinePurpose = getArguments().getString("medicinePurpose");
            String medicineLocation = getArguments().getString("medicineSource");
            int dosage = getArguments().getInt("medicineDosage", 0); // Ensure you get dosage correctly
            int stockCount = getArguments().getInt("medicineStockCount", 0); // Ensure you get stock count correctly
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
            medDetailsPillsLeft.setText("Pills Left: " + pillsLeft); // Display pills left

            // Set progress bar and percentage text
            medDetailsProgressBar.setProgress(progressValue);
            medDetailsProgressPercentage.setText(progressValue + "%");

            // Change progress color based on percentage
            if (progressValue < 30) {
                medDetailsProgressBar.getProgressDrawable().setColorFilter(RED_COLOR, PorterDuff.Mode.SRC_IN);
            } else {
                medDetailsProgressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
            }
        }

        return view;
    }
}
