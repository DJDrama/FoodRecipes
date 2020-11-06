package com.foodrecipes.www.ui.main;

import androidx.lifecycle.ViewModel;

import com.foodrecipes.www.FoodDataSource;
import com.foodrecipes.www.model.Food;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class FoodListViewModel extends ViewModel {

    private final FoodDataSource mDataSource;
    private Food mFood;

    public FoodListViewModel(FoodDataSource dataSource) {
        this.mDataSource = dataSource;
    }


    public Maybe<List<Food>> getFoodList(int type){
        return mDataSource.getFoodByType(type);
    }
}
