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
import com.example.myapplication.databinding.FragmentMedicationBinding;
import com.example.myapplication.ui.medication.tracker.MedicineTrackerFragment;
import com.example.myapplication.ui.profile.ProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicationFragment extends Fragment {

    private FragmentMedicationBinding binding;
    private MedicationAdapter medicationAdapter;

    ImageButton medicationTrackerBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        medicationTrackerBtn = root.findViewById(R.id.medicationTrackerButton);
        // Set an OnClickListener to navigate to medicineTrackerFragment
        medicationTrackerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MedicationFragment.this)
                        .navigate(R.id.action_navigation_medication_to_navigation_medicationTracker);
            }
        });

        // Setup RecyclerView
        RecyclerView medicationList = binding.medicationList;
        medicationList.setLayoutManager(new LinearLayoutManager(getContext()));
        medicationAdapter = new MedicationAdapter();
        medicationList.setAdapter(medicationAdapter);

        // Setup FAB click listener
        FloatingActionButton addButton = binding.addMedicationButton;
        addButton.setOnClickListener(v -> {
            // TODO: Implement add medication dialog or navigation xd
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}