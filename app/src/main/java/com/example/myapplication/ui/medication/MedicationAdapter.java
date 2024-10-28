package com.example.myapplication.ui.medication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medication, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        // In a real app, you would bind data from a list here
        holder.medicineName.setText("Sample Medicine " + (position + 1));
        holder.medicineDetails.setText("500mg • Once a day");
    }

    @Override
    public int getItemCount() {
        // Hardcoded to show 3 items
        // Hardcoded to show 10 now xdddddddddddddd
        return 10;
    }

    static class MedicationViewHolder extends RecyclerView.ViewHolder {
        TextView medicineName;
        TextView medicineDetails;

        MedicationViewHolder(View itemView) {
            super(itemView);
            medicineName = itemView.findViewById(R.id.medicineName);
            medicineDetails = itemView.findViewById(R.id.medicineDetails);
        }
    }
}
