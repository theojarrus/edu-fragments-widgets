package com.theost.fragmentsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.tabs.TabLayoutMediator;
import com.theost.fragmentsapp.databinding.ActivityNavigationViewpagerBinding;

public class NavigationViewPagerActivity extends FragmentActivity {

    private ActivityNavigationViewpagerBinding binding;
    private PagerAdapter adapter;

    private String[] categories = {"Top", "Popular", "For you"};

    public static Intent newIntent(Context context) {
        return new Intent(context, NavigationViewPagerActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationViewpagerBinding.inflate(getLayoutInflater());
        binding.toolbar.setNavigationOnClickListener(view -> onBackPressed());
        setContentView(binding.getRoot());

        adapter = new PagerAdapter(this, categories);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> tab.setText(categories[position])).attach();
    }
}
