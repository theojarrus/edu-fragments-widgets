package com.theost.fragmentsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.theost.fragmentsapp.databinding.ActivityNavigationBottomBinding;

public class NavigationBottomActivity extends AppCompatActivity {

    private ActivityNavigationBottomBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, NavigationBottomActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationBottomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(view -> this.onBackPressed());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            onNavigationItemSelected(item);
            return true;
        });

        startFragment(Fragment1.newInstance());
    }

    @SuppressLint("NonConstantResourceId")
    private void onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigationOne:
                startFragment(Fragment1.newInstance());
                break;
            case R.id.navigationTwo:
                startFragment(Fragment2.newInstance());
                break;
            case R.id.navigationThree:
                startFragment(Fragment3.newInstance());
                break;
            case R.id.navigationFour:
                startFragment(Fragment3.newInstance());
                break;
            case R.id.navigationFive:
                startFragment(Fragment3.newInstance());
                break;
        }
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, null)
                .commit();
    }
}
