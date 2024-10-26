package com.example.myapplication.ui.alarms;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class AlarmsFragment extends Fragment {
    private Switch alarmSwitch;
    private Switch alarmSwitch2;
    private TextView coughAlarmTime;
    private TextView metforminAlarmTime;


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

        // Create a strikethrough for the first alarm time
        SpannableString spannableString1 = new SpannableString(coughAlarmTime.getText());
        spannableString1.setSpan(new StrikethroughSpan(), 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        coughAlarmTime.setText(spannableString1);

        // Create a strikethrough for the second alarm time
        SpannableString spannableString2 = new SpannableString(metforminAlarmTime.getText());
        spannableString2.setSpan(new StrikethroughSpan(), 0, spannableString2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        metforminAlarmTime.setText(spannableString2);


        return rootView; // Return the inflated view
    }


}