package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView medicineRecyclerView;
    private RecyclerView missedMedicineRecyclerView;
    private MedicineAdapter medicineAdapter;
    private MedicineAdapter missedMedicineAdapter;
    private List<Medicine> medicineList;
    private List<Medicine> missedMedicineList; // List for missed medicines

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.greetingBanner;
        // Set the greeting text directly without ViewModel
        textView.setText("Hello, User!"); // Set your desired greeting text here

        // Initialize the RecyclerViews and their adapters
        medicineRecyclerView = binding.medicineList; // Assuming you have defined this in your Fragment's layout
        missedMedicineRecyclerView = binding.missedMedicineList; // Assuming you defined this as well

        // Set up the Medicine RecyclerView
        medicineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for the medicine list
        medicineList = new ArrayList<>();
        medicineList.add(new Medicine("Amlodipine", "Blood pressure control",
                R.drawable.amlodipine, "1 hr",
                "Woodland Watson", 70));
        medicineList.add(new Medicine("Atorvastatin", "Cholesterol management",
                R.drawable.atorvastatin, "2 hrs",
                "Woodland Watson", 80));

        medicineAdapter = new MedicineAdapter(getContext(), medicineList);
        medicineRecyclerView.setAdapter(medicineAdapter);

        // Set up the Missed Medication RecyclerView
        missedMedicineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for the missed medication list
        missedMedicineList = new ArrayList<>();
        missedMedicineList.add(new Medicine("Metformin", "Diabetes management",
                R.drawable.metformin, "1 hr ago",
                "Woodland Watson", 20));
        missedMedicineList.add(new Medicine("Aspirin", "Cardiovascular health",
                R.drawable.aspirin, "1 hr ago",
                "Woodland Watson", 20));

        missedMedicineAdapter = new MedicineAdapter(getContext(), missedMedicineList);
        missedMedicineRecyclerView.setAdapter(missedMedicineAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
