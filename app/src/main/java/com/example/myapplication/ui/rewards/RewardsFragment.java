package com.example.myapplication.ui.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentRewardsBinding;
import com.example.myapplication.ui.profile.ProfileFragment;

public class RewardsFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_rewards, container, false);

        CardView myCardView = root.findViewById(R.id.cardViewNTUC);
        CardView myCardView1 = root.findViewById(R.id.cardViewWatsons);

        myCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RewardsFragment.this)
                        .navigate(R.id.action_rewardFragment_to_claimablerewardFragment);
            }
        });

        myCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RewardsFragment.this)
                        .navigate(R.id.action_rewardFragment_to_availablerewardFragment);
            }
        });

        return root;
    }

}
