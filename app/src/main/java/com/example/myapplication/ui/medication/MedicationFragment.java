package com.example.myapplication.ui.medication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;

import com.example.myapplication.databinding.FragmentMedicationBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MedicationFragment extends Fragment implements MedicationAdapter.OnMedicationClickListener {

    private FragmentMedicationBinding binding;
    private MedicationAdapter medicationAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMedicationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


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
    public void onMedicationClick(String name, String details, String location, String dosage, String pillsLeft) {
        // Handle the click: pass the clicked medication's data to the next fragment
        Bundle bundle = new Bundle();
        bundle.putString("medicineName", name);
        bundle.putString("medicineDetails", details);
        bundle.putString("medicineLocations", location);
        bundle.putString("medicineDosage", dosage);
        bundle.putString("pillsLeft", pillsLeft);// Pass other data as needed

        // Navigate to the MedicationDetailsFragment with the data
        NavHostFragment.findNavController(MedicationFragment.this)
                .navigate(R.id.action_navigation_medication_to_medicineDetailsFragment, bundle);
    }



}
