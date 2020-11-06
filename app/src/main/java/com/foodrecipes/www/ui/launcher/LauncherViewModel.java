package com.foodrecipes.www.ui.launcher;

import androidx.lifecycle.ViewModel;

import com.foodrecipes.www.UserDataSource;
import com.foodrecipes.www.model.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class LauncherViewModel extends ViewModel {

    private final UserDataSource mDataSource;

    public LauncherViewModel(UserDataSource dataSource) {
        this.mDataSource = dataSource;
    }

    public Single<String> getUserId(String password) {
        return mDataSource.getUserId(password);
    }
}
