package com.foodrecipes.www.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.foodrecipes.www.model.Food;
import com.foodrecipes.www.model.User;

@Database(entities = {Food.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract FoodDao foodDao();
    public abstract UserDao userDao();


    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "food.db").build();
                }
            }
        }
        return INSTANCE;
    }

}
