package com.foodrecipes.www.ui.launcher;

import android.service.autofill.UserData;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.UserDataSource;

public class RegisterViewModelFactory implements ViewModelProvider.Factory {

    private final UserDataSource mDataSource;
    public RegisterViewModelFactory(UserDataSource mDataSource){
        this.mDataSource = mDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(RegisterViewModel.class)){
            return (T) new RegisterViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class");
    }
}
