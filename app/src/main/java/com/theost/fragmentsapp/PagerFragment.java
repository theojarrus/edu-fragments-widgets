package com.theost.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.theost.fragmentsapp.databinding.FragmentPagerBinding;

public class PagerFragment extends Fragment {

    private static final String ARG_CATEGORY = "key_category";

    private FragmentPagerBinding binding;

    public static PagerFragment newInstance(String category) {
        PagerFragment fragment = new PagerFragment();
        Bundle arguments = new Bundle();
        arguments.putString(ARG_CATEGORY, category);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPagerBinding.inflate(getLayoutInflater());
        binding.category.setText(getArguments() != null ? getArguments().getString(ARG_CATEGORY) : "error");
        return binding.getRoot();
    }
}
