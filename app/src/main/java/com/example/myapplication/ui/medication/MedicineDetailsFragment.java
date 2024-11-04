package com.example.myapplication.ui.medication;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.home.Medicine;

public class MedicineDetailsFragment extends Fragment {

    private static final int RED_COLOR = Color.parseColor("#F08080"); // Light Coral
    private static final int GREEN_COLOR = Color.GREEN; // Standard green

    public MedicineDetailsFragment() {
        // Required empty public constructor
    }

    public static MedicineDetailsFragment newInstance() {
        return new MedicineDetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicine_details, container, false);

        // Initialize UI elements
        ProgressBar progressBar = view.findViewById(R.id.med_details_progress_bar);
        TextView percentageText = view.findViewById(R.id.med_details_progress_percentage);

        // Assuming you have a method getMedicine() to retrieve the medicine details
//        Medicine medicine = getMedicine(); // Replace with actual method to get medicine data
//
//        // Set the progress and percentage text
//        int percentage = medicine.getPercentage();
//        progressBar.setProgress(percentage);
//        percentageText.setText(percentage + "%");

        // Change progress color based on percentage
//        if (percentage < 30) {
//            progressBar.getProgressDrawable().setColorFilter(RED_COLOR, PorterDuff.Mode.SRC_IN);
//        } else {
//            progressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
//        }

        return view;
    }

    // Replace this with your actual method to fetch the medicine details
    private Medicine getMedicine() {
         // Example with 50% - replace with actual medicine data
        return null;
    }
}
