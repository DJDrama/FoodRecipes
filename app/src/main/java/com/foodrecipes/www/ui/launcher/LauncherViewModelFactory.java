package com.foodrecipes.www.ui.launcher;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.UserDataSource;

public class LauncherViewModelFactory implements ViewModelProvider.Factory {

    private final UserDataSource mDataSource;
    public LauncherViewModelFactory(UserDataSource mDataSource){
        this.mDataSource = mDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(LauncherViewModel.class)){
            return (T) new LauncherViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
