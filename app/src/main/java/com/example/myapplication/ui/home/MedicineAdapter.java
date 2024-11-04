package com.example.myapplication.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import android.graphics.Color;
import android.graphics.PorterDuff;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private final Context context;
    private final List<Medicine> medicineList;
    private final OnItemClickListener listener;

    // Color constants
    private static final int RED_COLOR = Color.parseColor("#F08080"); // Light Coral
    private static final int GREEN_COLOR = Color.GREEN; // Standard green

    public interface OnItemClickListener {
        void onItemClick(Medicine medicine);
    }

    public MedicineAdapter(Context context, List<Medicine> medicineList, OnItemClickListener listener) {
        this.context = context;
        this.medicineList = medicineList;
        this.listener = listener;
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
                    listener.onItemClick(medicineList.get(position));
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

            // Change progress color based on percentage
            if (percentage < 30) {
                progressBar.getProgressDrawable().setColorFilter(RED_COLOR, PorterDuff.Mode.SRC_IN);
            } else {
                progressBar.getProgressDrawable().setColorFilter(GREEN_COLOR, PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
