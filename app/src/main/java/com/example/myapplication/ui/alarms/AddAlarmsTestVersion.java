package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;

public class AddAlarmsTestVersion extends Fragment {

    private Spinner medicineSpinner;
    private CalendarView calendarView;
    private Button cancelBtn;
    private Button saveBtn;
    private long selectedDateInMillis;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alarm_test_version, container, false);

        // Bind UI components
        medicineSpinner = rootView.findViewById(R.id.medicine_spinner);
        cancelBtn = rootView.findViewById(R.id.cancelButton);
        saveBtn = rootView.findViewById(R.id.saveAlarmBtn);
        calendarView = rootView.findViewById(R.id.calendarView);

        // Set up the adapter for the medicine spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.medicine_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicineSpinner.setAdapter(adapter);

        // Set the default selected date to the current date
        selectedDateInMillis = calendarView.getDate();

        // CalendarView listener to capture the selected date
        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectedDateInMillis = getDateInMillis(year, month, dayOfMonth);
        });

        // Cancel button logic
        cancelBtn.setOnClickListener(v -> NavHostFragment.findNavController(AddAlarmsTestVersion.this)
                .navigate(R.id.toAlarmFragment));

        saveBtn.setOnClickListener(v -> {
            new AlertDialog.Builder(requireContext())
                    .setTitle("Add Alarm")
                    .setMessage("Are you sure you want to add an alarm for this medicine on the selected date?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // Navigate to the AlarmsFragment
                        NavHostFragment.findNavController(AddAlarmsTestVersion.this)
                                .navigate(R.id.toAlarmFragment);

                        AlarmsViewModel viewModel = new ViewModelProvider(requireActivity()).get(AlarmsViewModel.class);
                        viewModel.setTestAlarmAdded(true);

                        // Show the first confirmation Toast
                        Toast.makeText(requireContext(), "Alarm set successfully for " + medicineSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

                        // Show second dialog confirming the alarm added to the calendar
                        new AlertDialog.Builder(requireContext())
                                .setTitle("Alarm Added")
                                .setMessage("The alarm has been successfully added to the calendar!")
                                .setPositiveButton("OK", (dialog1, which1) -> dialog1.dismiss()) // Close the dialog
                                .show();
                    })
                    .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                    .show();
        });


        return rootView;
    }

    /**
     * Utility method to convert date components into milliseconds
     */
    private long getDateInMillis(int year, int month, int dayOfMonth) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month, dayOfMonth, 0, 0, 0);
        calendar.set(java.util.Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
}
