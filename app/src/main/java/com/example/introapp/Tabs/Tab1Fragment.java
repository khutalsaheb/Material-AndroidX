package com.example.introapp.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introapp.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.customdialog, container, false);
    }


}