package com.example.myapplication.ui.medication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

    // Sample data arrays
    private String[] medicineNames = {
            "Aspirin", "Ibuprofen", "Paracetamol", "Amoxicillin", "Lisinopril",
            "Metformin", "Simvastatin", "Atorvastatin", "Levothyroxine", "Omeprazole"
    };

    private String[] medicineDetails = {
            "500mg • Once a day", "400mg • Twice a day", "500mg • Every 8 hours",
            "250mg • Three times a day", "10mg • Once a day",
            "500mg • Twice a day", "20mg • Once a day", "10mg • Once a day",
            "50mcg • Once a day", "20mg • Once a day"
    };

    private String[] medicineLocations = {
            "Obtained from: Pharmacy", "Obtained from: Online", "Obtained from: Clinic",
            "Obtained from: Hospital", "Obtained from: Pharmacy",
            "Obtained from: Hospital", "Obtained from: Pharmacy", "Obtained from: Online",
            "Obtained from: Clinic", "Obtained from: Pharmacy"
    };

    private String[] medicineDosages = {
            "Dosage: 1 tablet", "Dosage: 2 tablets", "Dosage: 1 tablet",
            "Dosage: 3 tablets", "Dosage: 1 tablet",
            "Dosage: 2 tablets", "Dosage: 1 tablet", "Dosage: 2 tablets",
            "Dosage: 1 tablet", "Dosage: 1 tablet"
    };

    private String[] pillsLeft = {
            "5 out of 10 pills left", "7 out of 20 pills left", "10 out of 30 pills left",
            "3 out of 15 pills left", "6 out of 12 pills left",
            "9 out of 25 pills left", "8 out of 40 pills left", "4 out of 10 pills left",
            "2 out of 5 pills left", "1 out of 8 pills left"
    };

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medication, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        // Binding hardcoded values from the arrays
        holder.medicineName.setText(medicineNames[position]);
        holder.medicineDetails.setText(medicineDetails[position]);
        holder.medicineLocation.setText(medicineLocations[position]);
        holder.medicineDosage.setText(medicineDosages[position]);
        holder.pillsLeft.setText(pillsLeft[position]);
        // Set a default icon for demonstration; replace with actual resource if needed
        holder.medicineIcon.setImageResource(android.R.drawable.ic_menu_gallery);
    }

    @Override
    public int getItemCount() {
        // Number of hardcoded items
        return medicineNames.length;
    }

    static class MedicationViewHolder extends RecyclerView.ViewHolder {
        TextView medicineName;
        TextView medicineDetails;
        TextView medicineLocation;
        TextView medicineDosage;
        TextView pillsLeft;
        ImageView medicineIcon;

        MedicationViewHolder(View itemView) {
            super(itemView);
            medicineName = itemView.findViewById(R.id.medicineName);
            medicineDetails = itemView.findViewById(R.id.medicineDetails);
            medicineLocation = itemView.findViewById(R.id.medicineLocation);
            medicineDosage = itemView.findViewById(R.id.medicineDosage);
            pillsLeft = itemView.findViewById(R.id.pillsLeft);
            medicineIcon = itemView.findViewById(R.id.medicineIcon);
        }
    }
}


