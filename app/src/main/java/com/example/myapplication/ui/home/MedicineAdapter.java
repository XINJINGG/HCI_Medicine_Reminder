package com.example.myapplication.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import android.graphics.Color;
import android.graphics.PorterDuff;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private final Context context;
    private final List<Medicine> medicineList;

    // Color constants for progress bar
    private static final int RED_COLOR = Color.parseColor("#F08080"); // Light Coral
    private static final int GREEN_COLOR = Color.GREEN; // Standard green

    public MedicineAdapter(Context context, List<Medicine> medicineList) {
        this.context = context;
        this.medicineList = medicineList;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_medicine, parent, false);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        Medicine medicine = medicineList.get(position);
        holder.bind(medicine);
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    public class MedicineViewHolder extends RecyclerView.ViewHolder {
        private final ImageView medicineIcon;
        private final TextView medicineName;
        private final TextView medicinePurpose;
        private final TextView medicineSource;
        private final TextView timeRemaining;
        private final ProgressBar progressBar;
        private final TextView percentageText;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineIcon = itemView.findViewById(R.id.medicineIcon);
            medicineName = itemView.findViewById(R.id.medicineName);
            medicinePurpose = itemView.findViewById(R.id.medicinePurpose);
            medicineSource = itemView.findViewById(R.id.medicineSource);
            timeRemaining = itemView.findViewById(R.id.timeRemaining);
            progressBar = itemView.findViewById(R.id.progress_bar);
            percentageText = itemView.findViewById(R.id.percentageText);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Medicine selectedMedicine = medicineList.get(position);

                    // Create a bundle to pass data to MedicineDetailsFragment
                    Bundle bundle = new Bundle();
                    bundle.putString("medicineName", selectedMedicine.getName());
                    bundle.putString("medicinePurpose", selectedMedicine.getPurpose());
                    bundle.putInt("medicineImageResId", selectedMedicine.getImageResId());
                    bundle.putString("medicineTimeRemaining", selectedMedicine.getTimeRemaining());
                    bundle.putString("medicineSource", selectedMedicine.getSource());
                    // Uncomment these lines if you need to pass these parameters as well
                    // bundle.putString("medicineDosage", selectedMedicine.getDosage());
                    // bundle.putString("medicineFrequency", selectedMedicine.getFrequency());
                    // bundle.putInt("medicineStockCount", selectedMedicine.getStockCount());
                    // bundle.putInt("medicinePillsLeft", selectedMedicine.getPillsLeft());
                    bundle.putInt("medicinePercentage", selectedMedicine.getPercentage()); // Pass percentage

                    // Navigate to MedicineDetailsFragment
                    Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_medicineDetailsFragment, bundle);
                }
            });
        }

        public void bind(Medicine medicine) {
            medicineIcon.setImageResource(medicine.getImageResId());
            medicineName.setText(medicine.getName());
            medicinePurpose.setText(medicine.getPurpose());
            medicineSource.setText(medicine.getSource());
            timeRemaining.setText(medicine.getTimeRemaining());

            // Set the progress and percentage text
            int percentage = medicine.getPercentage();
            progressBar.setProgress(percentage);
            percentageText.setText(percentage + "%");

            // Change progress bar color based on the percentage
            if (percentage < 30) {
                progressBar.getProgressDrawable().setColorFilter(RED_COLOR, PorterDuff.Mode.SRC_IN);
            } else {
                progressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
