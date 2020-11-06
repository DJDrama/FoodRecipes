package com.foodrecipes.www.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.foodrecipes.www.model.Food;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

@Dao
public interface FoodDao {

    @Query("SELECT * FROM food WHERE type=:type")
    Maybe<List<Food>> getFoodByType(int type);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertFoods(List<Food> foodList);
}
