package com.example.myapplication.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R; // Adjust package name accordingly

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private final Context context;
    private final List<Medicine> medicineList;

    // Constructor
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

    // ViewHolder class to hold the views for each item
    public static class MedicineViewHolder extends RecyclerView.ViewHolder {
        private final ImageView medicineIcon;
        private final TextView medicineInfo;
        private final TextView timeRemaining;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineIcon = itemView.findViewById(R.id.medicineIcon);
            medicineInfo = itemView.findViewById(R.id.medicineInfo);
            timeRemaining = itemView.findViewById(R.id.timeRemaining);
        }

        public void bind(Medicine medicine) {
            medicineIcon.setImageResource(medicine.getImageResId());
            medicineInfo.setText(medicine.getSource()+"\n"+medicine.getName() + "\n" + medicine.getPurpose());
            timeRemaining.setText(medicine.getTimeRemaining());
        }
    }
}
