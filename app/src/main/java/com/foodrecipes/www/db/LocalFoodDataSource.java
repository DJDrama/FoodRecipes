package com.foodrecipes.www.db;

import com.foodrecipes.www.model.Food;
import com.foodrecipes.www.FoodDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class LocalFoodDataSource implements FoodDataSource {
    private final FoodDao foodDao;

    public LocalFoodDataSource(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    public Maybe<List<Food>> getFoodByType(int type) {
        return foodDao.getFoodByType(type);
    }

    @Override
    public Completable insertFoodList(List<Food> foodList) {
        return foodDao.insertFoods(foodList);
    }
}
