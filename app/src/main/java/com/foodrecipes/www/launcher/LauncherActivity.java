package com.foodrecipes.www.launcher;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.foodrecipes.www.databinding.ActivityLauncherBinding;

public class LauncherActivity extends AppCompatActivity {
    private ActivityLauncherBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("로그인");
       binding = ActivityLauncherBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

       binding.tvRegister.setOnClickListener(view -> {
           Intent intent = new Intent(LauncherActivity.this, RegisterActivity.class);
           startActivity(intent);
       });

    }
}
