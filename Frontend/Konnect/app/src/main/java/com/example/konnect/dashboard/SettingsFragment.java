package com.example.konnect.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.konnect.ChoosehobbiesActivity;
import com.example.konnect.ProfileEditActivity;
import com.example.konnect.R;
import com.example.konnect.ReportActivity;
import com.example.konnect.entry.MainActivity;

public class SettingsFragment extends Fragment {
    @SuppressLint("ApplySharedPref")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dashboard_fragment_settings, container, false);
        Button editProfileButton = view.findViewById(R.id.Profile_Edit_Button);
        Button chooseHobbiesButton = view.findViewById(R.id.ChooseHobbies_Button);
        Button reportButton = view.findViewById(R.id.Report_Button);
        Button logoutButton = view.findViewById(R.id.Logout_Button);

        editProfileButton.setOnClickListener(v -> startActivity(new Intent(v.getContext(), ProfileEditActivity.class)));
        chooseHobbiesButton.setOnClickListener(v -> startActivity(new Intent(v.getContext(), ChoosehobbiesActivity.class)));
        reportButton.setOnClickListener(v -> startActivity(new Intent(v.getContext(), ReportActivity.class)));
        logoutButton.setOnClickListener(v -> {
            v.getContext().getSharedPreferences("USERDATA", 0).edit().clear().commit();
            startActivity(new Intent(v.getContext(), MainActivity.class));
            requireActivity().finish();
        });


        return view;
    }
}