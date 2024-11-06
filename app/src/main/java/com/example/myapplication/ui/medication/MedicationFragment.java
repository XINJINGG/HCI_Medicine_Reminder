package com.example.myapplication.ui.medication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMedicationBinding;
import com.example.myapplication.ui.medication.tracker.MedicineTrackerFragment;
import com.example.myapplication.ui.profile.ProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicationFragment extends Fragment implements MedicationAdapter.OnMedicationClickListener {

    private FragmentMedicationBinding binding;
    private MedicationAdapter medicationAdapter;

    ImageButton medicationTrackerBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Navigate to the medicine tracker fragment
        medicationTrackerBtn = root.findViewById(R.id.medicationTrackerButton);
        medicationTrackerBtn.setOnClickListener(v -> {
            NavHostFragment.findNavController(MedicationFragment.this)
                    .navigate(R.id.action_navigation_medication_to_navigation_medicationTracker);
        });

        // Setup RecyclerView
        RecyclerView medicationList = binding.medicationList;
        medicationList.setLayoutManager(new LinearLayoutManager(getContext()));
        medicationAdapter = new MedicationAdapter(this); // Pass 'this' as the listener
        medicationList.setAdapter(medicationAdapter);

        // Setup FAB click listener
        FloatingActionButton addButton = binding.addMedicationButton;
        addButton.setOnClickListener(v -> {
            NavHostFragment.findNavController(MedicationFragment.this)
                    .navigate(R.id.action_medicationFragment_to_addMedicationFragment);
        });

        return root;
    }

    @Override
    public void onMedicationClick(String name, String details) {
        // Handle the click: pass the clicked medication's data to the next fragment
        Bundle bundle = new Bundle();
        bundle.putString("medicineName", name);
        bundle.putString("medicineDetails", details); // Pass other data as needed

        // Navigate to the MedicationDetailsFragment with the data
        NavHostFragment.findNavController(MedicationFragment.this)
                .navigate(R.id.action_navigation_medication_to_medicineDetailsFragment, bundle);
    }
}
