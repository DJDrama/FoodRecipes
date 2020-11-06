package com.foodrecipes.www;

import android.content.Context;

import com.foodrecipes.www.db.FoodDatabase;
import com.foodrecipes.www.db.LocalFoodDataSource;
import com.foodrecipes.www.ui.launcher.ViewModelFactory;

public class Injection {

    public static FoodDataSource provideFoodDataSource(Context context){
        FoodDatabase db = FoodDatabase.getInstance(context);
        return new LocalFoodDataSource(db.foodDao());
    }
    public static ViewModelFactory provideViewModelFactory(Context context){
        FoodDataSource ds = provideFoodDataSource(context);
        return new ViewModelFactory(ds);
    }
}
