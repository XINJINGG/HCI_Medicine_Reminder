package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;

public class AddAlarmsFragment extends Fragment {

    private Spinner medicineSpinner;

    private Button cancelBtn;
    private Button saveBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_addalarm, container, false);
        medicineSpinner = rootView.findViewById(R.id.medicine_spinner);
        cancelBtn = rootView.findViewById(R.id.cancelButton);
        saveBtn = rootView.findViewById(R.id.saveAlarmBtn);

        // Set up the adapter for the Spinner to populate data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.medicine_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicineSpinner.setAdapter(adapter);

        // cancel button logic
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AddAlarmsFragment.this)
                        .navigate(R.id.toAlarmFragment);
            }
        });

        // add alarm logic
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the AlertDialog
                new AlertDialog.Builder(requireContext())
                        .setTitle("Add alarm")
                        .setMessage("Are you sure you want to add alarm for this medicine?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Navigate to AlarmsFragment on confirmation
                            NavHostFragment.findNavController(AddAlarmsFragment.this)
                                    .navigate(R.id.toAlarmFragment);

                            AlarmsViewModel viewModel = new ViewModelProvider(requireActivity()).get(AlarmsViewModel.class);
                            viewModel.setAlarmAdded(true);
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Close the dialog without any action
                            dialog.dismiss();
                        })
                        .show();
            }
        });



        return rootView;
    }
}
