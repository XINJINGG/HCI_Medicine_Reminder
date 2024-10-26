package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class EditAlarmsFragment extends Fragment {

    private Spinner timingSpinner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_edit_alarms, container, false);

        // Initialize the Spinner
        timingSpinner = rootView.findViewById(R.id.timing_spinner);

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

        return rootView; // Return the inflated view
    }
}
