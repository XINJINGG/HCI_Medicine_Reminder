package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.FragmentMedicationBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicationFragment extends Fragment {

    private FragmentMedicationBinding binding;
    private MedicationAdapter medicationAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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