package com.theost.fragmentsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.theost.fragmentsapp.databinding.ActivityNavigationDrawerBinding;

public class NavigationDrawerActivity extends AppCompatActivity {

    private ActivityNavigationDrawerBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, NavigationDrawerActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setNavigationOnClickListener(view -> binding.getRoot().open());

        binding.navigationDrawer.setNavigationItemSelectedListener(item -> {
            onNavigationItemSelected(item);
            return true;
        });

        binding.navigationDrawer.setCheckedItem(R.id.navigationOne);
        startFragment(Fragment1.newInstance());
    }

    @SuppressLint("NonConstantResourceId")
    private void onNavigationItemSelected(MenuItem item) {
        binding.getRoot().close();
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
        }
    }

    private void startFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, null)
                .commit();
    }
}
