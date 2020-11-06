package com.foodrecipes.www.ui.launcher;

import androidx.lifecycle.ViewModel;

import com.foodrecipes.www.Constants;
import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.R;
import com.foodrecipes.www.UserDataSource;
import com.foodrecipes.www.model.Food;
import com.foodrecipes.www.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;

public class RegisterViewModel extends ViewModel {

    private final UserDataSource mDataSource;

    public RegisterViewModel(UserDataSource dataSource) {
        this.mDataSource = dataSource;
    }

    public Completable insertUser(User user) {
        return mDataSource.insertUser(user);
    }
}
