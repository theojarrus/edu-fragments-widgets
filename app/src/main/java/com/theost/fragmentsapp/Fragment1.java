package com.theost.fragmentsapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.theost.fragmentsapp.databinding.FragmentOneBinding;

public class Fragment1 extends Fragment {

    private FragmentOneBinding binding;

    private NavigationHolder navigationHolder;

    public static Fragment1 newInstance() {
        return new Fragment1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOneBinding.inflate(getLayoutInflater());

        navigationHolder.doSomething("text");
        
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        navigationHolder = (NavigationHolder) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        navigationHolder = null;
    }
}
