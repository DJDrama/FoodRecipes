package com.foodrecipes.www.ui.launcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SplashScreenActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide Actionbar
        Objects.requireNonNull(getSupportActionBar()).setShowHideAnimationEnabled(false);
        getSupportActionBar().hide();

        com.foodrecipes.www.databinding.ActivitySplashScreenBinding binding = com.foodrecipes.www.databinding.ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Ken Burns Effect
        binding.backgroundImage.resume();

        //1.5 seconds
        int splashDisplayTime = 3000;
        new Handler().postDelayed(this::navigateToLauncherActivity, splashDisplayTime);
    }

    private void navigateToLauncherActivity() {
        Intent intent = new Intent(this, LauncherActivity.class);
        startActivity(intent);
        finish();
    }
}