package com.example.myapplication.ui.medication.tracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.medication.MedicationAdapter;
import com.example.myapplication.ui.medication.MedicationFragment;

public class MedicationTrackerAdapter extends RecyclerView.Adapter<MedicationTrackerAdapter.TrackerViewHolder> implements View.OnClickListener{
    @NonNull
    @Override
    public MedicationTrackerAdapter.TrackerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medicine_tracker, parent, false);
        return new TrackerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationTrackerAdapter.TrackerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onClick(View v) {

        //allow navigation to go into medication details
//        NavHostFragment.findNavController(MedicineTrackerFragment.this)
//                .navigate(R.id.action_navigation_medication_to_navigation_medicationTracker);

    }

    static class TrackerViewHolder extends RecyclerView.ViewHolder {
        TextView medicine_name;
        TextView medicine_location;
        TextView medicine_left_with;
        ImageView medicine_image;

        TrackerViewHolder(View itemView) {
            super(itemView);

            medicine_name = itemView.findViewById(R.id.MTName);
            medicine_location = itemView.findViewById(R.id.MTLocation);
            medicine_left_with = itemView.findViewById(R.id.MTLeftWith);
            medicine_image = itemView.findViewById(R.id.MTImage);
        }
    }
}
