package com.foodrecipes.www;

import android.content.Context;
import android.service.autofill.UserData;

import com.foodrecipes.www.db.AppDatabase;
import com.foodrecipes.www.db.LocalFoodDataSource;
import com.foodrecipes.www.db.LocalUserDataSource;
import com.foodrecipes.www.ui.launcher.LauncherViewModelFactory;
import com.foodrecipes.www.ui.launcher.RegisterViewModelFactory;
import com.foodrecipes.www.ui.launcher.SplashScreenViewModelFactory;
import com.foodrecipes.www.ui.main.FoodListViewModelFactory;

public class Injection {

    public static FoodDataSource provideFoodDataSource(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        return new LocalFoodDataSource(db.foodDao());
    }

    public static UserDataSource provideUserDataSource(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        return new LocalUserDataSource(db.userDao());
    }

    public static SplashScreenViewModelFactory provideSplashScreenViewModelFactory(Context context){
        FoodDataSource ds = provideFoodDataSource(context);
        return new SplashScreenViewModelFactory(ds);
    }
    public static FoodListViewModelFactory provideFoodListViewModelFactory(Context context){
        FoodDataSource ds = provideFoodDataSource(context);
        return new FoodListViewModelFactory(ds);
    }

    public static LauncherViewModelFactory provideLauncherViewModelFactory(Context context){
        UserDataSource ds = provideUserDataSource(context);
        return new LauncherViewModelFactory(ds);
    }

    public static RegisterViewModelFactory provideRegisterViewModelFactory(Context context){
        UserDataSource ds = provideUserDataSource(context);
        return new RegisterViewModelFactory(ds);
    }
}
