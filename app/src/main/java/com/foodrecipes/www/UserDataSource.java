package com.foodrecipes.www;

import com.foodrecipes.www.model.Food;
import com.foodrecipes.www.model.User;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface UserDataSource {
    Single<String> getUserId(String password);

    Completable insertUser(User user);
}
