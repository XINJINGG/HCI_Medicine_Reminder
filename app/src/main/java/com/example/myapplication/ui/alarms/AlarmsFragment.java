package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.profile.ProfileFragment;

public class AlarmsFragment extends Fragment {
    private Switch alarmSwitch;
    private Switch alarmSwitch2;
    private TextView coughAlarmTime;
    private TextView coughAlarmTime2;
    private TextView metforminAlarmTime;
    private ImageView rightArrowIcon;
    private AlarmsViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmSwitch = rootView.findViewById(R.id.alarmSwitch);
        alarmSwitch2 = rootView.findViewById(R.id.alarmSwitch2);
        coughAlarmTime = rootView.findViewById(R.id.coughsyrupAlarmTime1);
        coughAlarmTime2 = rootView.findViewById(R.id.coughsyrupAlarmTime2);
        metforminAlarmTime = rootView.findViewById(R.id.metforminAlarmTime1);
        rightArrowIcon = rootView.findViewById(R.id.rightArrowIcon); // Make sure to initialize the button

        // get shared view model
        viewModel = new ViewModelProvider(requireActivity()).get(AlarmsViewModel.class);

        // delete timing ui
        viewModel.getIsAlarmDeleted().observe(getViewLifecycleOwner(), isDeleted -> {
            // if status is deleted, then make the timing invisible
            if (isDeleted) {
                coughAlarmTime.setVisibility(View.GONE);
            }
        });

        // save timing ui
        viewModel.getIsAlarmSaved().observe(getViewLifecycleOwner(), isSaved -> {
            // if status is deleted, then make the timing invisible
            if (isSaved) {
                coughAlarmTime2.setText("14:00 PM");
            }
        });

        // Set up the click listener for the right arrow icon
        rightArrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AlarmsFragment.this)
                        .navigate(R.id.toEditAlarmFragment);
            }
        });

        // Set up the switch listener
        alarmSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Show a popup message when the switch is toggled
            if (isChecked) {
                Toast.makeText(getContext(), "Alarm for Prospan Cough Syrup Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Alarm for Prospan Cough Syrup Disabled", Toast.LENGTH_SHORT).show();
            }
        });

        alarmSwitch2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Show a popup message when the switch is toggled
            if (isChecked) {
                Toast.makeText(getContext(), "Alarm for Metformin Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Alarm for Metformin Disabled", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView; // Return the inflated view
    }
}
