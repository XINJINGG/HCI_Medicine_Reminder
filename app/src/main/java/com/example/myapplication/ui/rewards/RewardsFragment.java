package com.example.myapplication.ui.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentRewardsBinding;

public class RewardsFragment extends Fragment {
    private FragmentRewardsBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RewardsViewModel rewardsViewModel =
                new ViewModelProvider(this).get(RewardsViewModel.class);

        // Inflate the layout using the generated binding class
        binding = FragmentRewardsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Assuming you have a TextView in your fragment_rewards.xml with the ID textRewards
        final TextView textView = binding.textRewards;
        rewardsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
