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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView medicineRecyclerView;
    private RecyclerView missedMedicineRecyclerView;
    private MedicineAdapter medicineAdapter;
    private MedicineAdapter missedMedicineAdapter;
    private List<Medicine> medicineList;
    private List<Medicine> missedMedicineList; // List for missed medicines

    private TextView dateText; // For dynamic date
    private TextView greetingBanner; // For dynamic greeting


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        greetingBanner = binding.greetingBanner;
        greetingBanner.setText(getGreetingMessage()); // Set the dynamic greeting text

        // Initialize the RecyclerViews and their adapters
        medicineRecyclerView = binding.medicineList;
        missedMedicineRecyclerView = binding.missedMedicineList;

        // Set up the Medicine RecyclerView
        medicineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for the medicine list
        medicineList = new ArrayList<>();
        medicineList.add(new Medicine("Prospan Cough", "Cough",
                R.drawable.coughsyrup, "TO BE TAKEN IN: 2 hrs",
                "Woodland Watson", 80));
        medicineAdapter = new MedicineAdapter(getContext(), medicineList);
        medicineRecyclerView.setAdapter(medicineAdapter);

        // Set up the Missed Medication RecyclerView
        missedMedicineRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data for the missed medication list
        missedMedicineList = new ArrayList<>();
        missedMedicineList.add(new Medicine("Metformin", "Diabetes",
                R.drawable.metformin, "MISSED : 2 hrs ago",
                "Woodland Watson", 10));

        missedMedicineAdapter = new MedicineAdapter(getContext(), missedMedicineList);
        missedMedicineRecyclerView.setAdapter(missedMedicineAdapter);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dateText = view.findViewById(R.id.dateText);
        setCurrentDate();
    }

    private void setCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());
        dateText.setText(currentDate);
    }

    private String getGreetingMessage() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= 5 && hour < 12) {
            return "Good Morning, John!";
        } else if (hour >= 12 && hour < 17) {
            return "Good Afternoon, John!";
        } else {
            return "Good Evening, John!";
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
