package com.example.myapplication.ui.medication.tracker;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.ui.medication.MedicationAdapter;

public class MedicineTrackerFragment extends Fragment {
    private MedicationTrackerAdapter medicineTrackerAdapter;
    private RecyclerView recyclerView;

    public static MedicineTrackerFragment newInstance(String param1, String param2) {
        MedicineTrackerFragment fragment = new MedicineTrackerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medicine_tracker, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the RecyclerView
        recyclerView = view.findViewById(R.id.med_tracker_list);

        // Setup RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        medicineTrackerAdapter = new MedicationTrackerAdapter();
        recyclerView.setAdapter(medicineTrackerAdapter);
    }
}
