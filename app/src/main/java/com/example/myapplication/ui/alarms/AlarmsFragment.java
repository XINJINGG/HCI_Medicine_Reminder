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
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.profile.ProfileFragment;

public class AlarmsFragment extends Fragment {
    private Switch alarmSwitch;
    private Switch alarmSwitch2;
    private TextView coughAlarmTime;
    private TextView metforminAlarmTime;
    private ImageView rightArrowIcon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);

        alarmSwitch = rootView.findViewById(R.id.alarmSwitch);
        alarmSwitch2 = rootView.findViewById(R.id.alarmSwitch2);
        coughAlarmTime = rootView.findViewById(R.id.coughsyrupAlarmTime1);
        metforminAlarmTime = rootView.findViewById(R.id.metforminAlarmTime1);
        rightArrowIcon = rootView.findViewById(R.id.rightArrowIcon); // Make sure to initialize the button

        // Set up the switch listeners and other UI elements as needed...

        // Set up the click listener for the right arrow icon
        rightArrowIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(AlarmsFragment.this)
                        .navigate(R.id.toEditAlarmFragment);
            }
        });

        return rootView; // Return the inflated view
    }
}
