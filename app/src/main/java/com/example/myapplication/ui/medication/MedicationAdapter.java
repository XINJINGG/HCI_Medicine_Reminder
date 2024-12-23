package com.example.myapplication.ui.medication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MedicationAdapter extends RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder> {

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
            "For relieving mild pain and inflammation",
            "For my pain relief and to bring down inflammation",
            "When I need quick relief from pain or a fever but don’t want something that messes with my stomach",
            "If I’ve got a bacterial infection",
            "Manage my blood pressure",
            "Daily go-to for helping manage my blood sugar levels",
            "Keep my cholesterol in check.",
            "This one helps manage my cholesterol levels",
            "Replace the thyroid hormone",
            "When heartburn or acid reflux kicks in"
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

    private String[] Frequency = {
            "2 times a day", "Once a day", "2 times a day",
            "3 times a day", "3 times a day",
            "3 times a day", "3 times a day", "3 times a day",
            "3 times a day", "3 times a day"
    };


    private String[] pillsLeft = {
            "5 out of 10 pills left", "7 out of 20 pills left", "10 out of 30 pills left",
            "3 out of 15 pills left", "6 out of 12 pills left",
            "9 out of 25 pills left", "8 out of 40 pills left", "4 out of 10 pills left",
            "2 out of 5 pills left", "1 out of 8 pills left"
    };

    private List<Medication> medicationList;
    private OnMedicationClickListener onMedicationClickListener;

    public MedicationAdapter(OnMedicationClickListener listener) {
        this.onMedicationClickListener = listener;
        this.medicationList = new ArrayList<>();

        // Initialize with hardcoded data
        for (int i = 0; i < medicineNames.length; i++) {
            medicationList.add(new Medication(
                    medicineImages[i],
                    medicineNames[i],
                    medicineDetails[i],
                    medicineLocations[i],
                    medicineDosages[i],
                    pillsLeft[i]
            ));
        }
    }

    // Method to remove medication
    public void removeMedication(int position) {
        if (position >= 0 && position < medicationList.size()) {
            medicationList.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public MedicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_medication, parent, false);
        return new MedicationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationViewHolder holder, int position) {
        Medication medication = medicationList.get(position);
        holder.medicineName.setText(medication.getName());
        holder.medicineDetails.setText(medication.getDetails());
        holder.medicineLocation.setText(medication.getLocation());
        holder.medicineDosage.setText(medication.getDosage());
        holder.pillsLeft.setText(medication.getPillsLeft());

        // Set a default icon for demonstration; replace with actual resource if needed
        holder.medicineIcon.setImageResource(medicineImages[position]);

        // Set click listener for item
        holder.itemView.setOnClickListener(v -> {
            onMedicationClickListener.onMedicationClick(medication.getMedicineImage(), medication.getName(), medication.getDetails(), medication.getLocation(), medication.getDosage(), medication.pillsLeft);
        });
    }

    @Override
    public int getItemCount() {
        return medicationList.size();
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

    // Define the listener interface
    public interface OnMedicationClickListener {
//        void onMedicationClick(String name, String details);

        void onMedicationClick(int medicineImage, String name, String details, String location, String dosage, String pillsLeft);
    }

    // Medication class to hold data
    public static class Medication {
        private int medicineImage;
        private String name;
        private String details;
        private String location;
        private String dosage;
        private String pillsLeft;



        public Medication(int medicineImage, String name, String details, String location, String dosage, String pillsLeft) {
            this.medicineImage = medicineImage;
            this.name = name;
            this.details = details;
            this.location = location;
            this.dosage = dosage;
            this.pillsLeft = pillsLeft;
        }

        public int getMedicineImage() {
            return medicineImage;
        }

        public String getName() {
            return name;
        }

        public String getDetails() {
            return details;
        }

        public String getLocation() {
            return location;
        }

        public String getDosage() {
            return dosage;
        }

        public String getPillsLeft() {
            return pillsLeft;
        }
    }
}
