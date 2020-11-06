package com.foodrecipes.www.ui.launcher;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.FoodDataSource;

public class SplashScreenViewModelFactory implements ViewModelProvider.Factory {

    private final FoodDataSource mDataSource;
    public SplashScreenViewModelFactory(FoodDataSource foodDataSource){
        this.mDataSource = foodDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(SplashScreenViewModel.class)){
            return (T) new SplashScreenViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
