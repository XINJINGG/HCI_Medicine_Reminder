package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;

public class EditAlarmsFragment extends Fragment {

    private Spinner timingSpinner;
    private Button cancelBtn;
    private Button deleteBtn;
    private Button deleteTimingBtn;
    private Button saveBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_alarms, container, false);

        // Initialize the Spinner
        timingSpinner = rootView.findViewById(R.id.timing_spinner);
        cancelBtn = rootView.findViewById(R.id.cancelButton); // Make sure to initialize the button
        saveBtn = rootView.findViewById(R.id.saveButton); // Make sure to initialize the button
        deleteBtn = rootView.findViewById(R.id.deleteButton); // Make sure to initialize the button
        deleteTimingBtn = rootView.findViewById(R.id.deleteTimingButton); // Make sure to initialize the button

        // Set up the adapter for the Spinner to populate data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.timing_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // connects array adapter to the timing spinner
        // timing spinner will use the adapter to populate items with values from the array in strings.xml
        timingSpinner.setAdapter(adapter);

        // cancel button logic
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(EditAlarmsFragment.this)
                        .navigate(R.id.toAlarmFragment);
            }
        });

        // delete button logic
        deleteTimingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the AlertDialog
                new AlertDialog.Builder(requireContext())
                        .setTitle("Confirm Deletion")
                        .setMessage("Are you sure you want to delete this alarm?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Navigate to AlarmsFragment on confirmation

                            NavHostFragment.findNavController(EditAlarmsFragment.this)
                                    .navigate(R.id.toAlarmFragment);

                            AlarmsViewModel viewModel = new ViewModelProvider(requireActivity()).get(AlarmsViewModel.class);
                            viewModel.setAlarmDeleted(true);
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Close the dialog without any action
                            dialog.dismiss();
                        })
                        .show();
            }
        });

        // save button logic
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the AlertDialog
                new AlertDialog.Builder(requireContext())
                        .setTitle("Confirm Changes")
                        .setMessage("Save changes made?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                            // Navigate to AlarmsFragment on confirmation
                            NavHostFragment.findNavController(EditAlarmsFragment.this)
                                    .navigate(R.id.toAlarmFragment);

                            AlarmsViewModel viewModel = new ViewModelProvider(requireActivity()).get(AlarmsViewModel.class);
                            viewModel.setAlarmSaved(true);
                        })
                        .setNegativeButton("No", (dialog, which) -> {
                            // Close the dialog without any action
                            dialog.dismiss();
                        })
                        .show();
            }
        });

        return rootView; // Return the inflated view
    }
}
