package com.foodrecipes.www.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.foodrecipes.www.model.User;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    Completable insertUser(User user);

    @Query("SELECT user_id FROM user WHERE password = :password")
    Single<String> getUserId(String password);
}
