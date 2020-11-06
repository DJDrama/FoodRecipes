package com.foodrecipes.www.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private String userId;

    @ColumnInfo(name="password")
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
