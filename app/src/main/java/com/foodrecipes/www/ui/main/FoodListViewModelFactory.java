package com.foodrecipes.www.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.ui.launcher.SplashScreenViewModel;

public class FoodListViewModelFactory implements ViewModelProvider.Factory {

    private final FoodDataSource mDataSource;
    public FoodListViewModelFactory(FoodDataSource foodDataSource){
        this.mDataSource = foodDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(FoodListViewModel.class)){
            return (T) new FoodListViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
