package com.example.myapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class EditProfileFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout directly
        View root = inflater.inflate(R.layout.fragment_editprofile, container, false);



        // Enable the Up button in the toolbar
        setHasOptionsMenu(true);  // Enable fragment to add menu items

        return root;
    }

    // Handle the back arrow press in the ActionBar
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Enable the up button in the ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
