package com.foodrecipes.www.db;

import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.UserDataSource;
import com.foodrecipes.www.model.Food;
import com.foodrecipes.www.model.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class LocalUserDataSource implements UserDataSource {
    private final UserDao userDao;

    public LocalUserDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Single<String> getUserId(String password) {
        return userDao.getUserId(password);
    }

    @Override
    public Completable insertUser(User user) {
        return userDao.insertUser(user);
    }

}