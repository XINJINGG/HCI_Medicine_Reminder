package com.example.myapplication.ui.medication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MedicationPageCard extends RecyclerView.Adapter<MedicationPageCard.MedicationViewHolder> {

    // Sample data arrays
    private int[] medicineImages = {
            R.drawable.aspirin, R.drawable.ibuprofen, R.drawable.paracetamol,
            R.drawable.amoxicillin, R.drawable.lisinopril,
            R.drawable.metformin, R.drawable.simvastatin, R.drawable.atorvastatin,
            R.drawable.levothyroxine, R.drawable.omeprazole
    };
    
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
        Log.d("MedicationAdapter", "Setting image resource: " + medicineImages[position]);

        holder.medicineImage.setImageResource(medicineImages[position]);
        holder.medicineName.setText(medicineNames[position]);
        holder.medicineDetails.setText(medicineDetails[position]);
        holder.pillsLeft.setText(pillsLeft[position]);

    }

    @Override
    public int getItemCount() {
        // Number of hardcoded items
        return medicineNames.length;
    }

    static class MedicationViewHolder extends RecyclerView.ViewHolder {

        TextView medicineName;
        TextView medicineDetails;
        TextView pillsLeft;
        ImageView medicineImage;

        MedicationViewHolder(View itemView) {
            super(itemView);
            medicineImage = itemView.findViewById(R.id.medicineIcon);
            medicineName = itemView.findViewById(R.id.medicineName);
            medicineDetails = itemView.findViewById(R.id.medicineDetails);
            pillsLeft = itemView.findViewById(R.id.pillsLeft); // Find the new TextView
        }
    }
}

