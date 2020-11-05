package com.foodrecipes.www;

import com.foodrecipes.www.model.Food;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public interface FoodDataSource {

    Flowable<List<Food>> getFoodByType(int type);

    Completable insertFoodList(List<Food> foodList);
}
