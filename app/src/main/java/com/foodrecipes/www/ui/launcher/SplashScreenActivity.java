package com.foodrecipes.www.ui.launcher;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.Injection;
import com.foodrecipes.www.databinding.ActivitySplashScreenBinding;

import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SplashScreenActivity extends AppCompatActivity {
    private static final String TAG = SplashScreenActivity.class.getSimpleName();

    private ViewModelFactory mViewModelFactory;
    private SplashScreenViewModel mViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide Actionbar
        Objects.requireNonNull(getSupportActionBar()).setShowHideAnimationEnabled(false);
        getSupportActionBar().hide();

        ActivitySplashScreenBinding binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ViewModel
        mViewModelFactory = Injection.provideViewModelFactory(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(SplashScreenViewModel.class);

        //Ken Burns Effect
        binding.backgroundImage.resume();

        //1.5 seconds
//        int splashDisplayTime = 3000;
//        new Handler().postDelayed(this::navigateToLauncherActivity, splashDisplayTime);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDisposable.add(
                mViewModel.insertFoodList()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::navigateToLauncherActivity,
                                throwable -> Log.e(TAG, "Unable to Insert foodList", throwable)));
    }

    private void navigateToLauncherActivity() {
        Intent intent = new Intent(this, LauncherActivity.class);
        startActivity(intent);
        finish();
    }
}