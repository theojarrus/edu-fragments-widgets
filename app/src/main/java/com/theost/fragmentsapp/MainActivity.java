package com.theost.fragmentsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.theost.fragmentsapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationHolder {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.openNavigationBottom.setOnClickListener(view -> startActivity(NavigationBottomActivity.newIntent(this)));
        binding.openNavigationDrawer.setOnClickListener(view -> startActivity(NavigationDrawerActivity.newIntent(this)));
        binding.openViewPager.setOnClickListener(view -> startActivity(NavigationViewPagerActivity.newIntent(this)));
    }

    public void doSomething(String text) {
        System.out.println(text);
    }
}
