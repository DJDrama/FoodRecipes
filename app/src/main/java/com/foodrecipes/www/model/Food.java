package com.foodrecipes.www.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.foodrecipes.www.R;

@Entity(tableName = "food")
public class Food {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "food_id")
    private int id;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "food_name")
    private String name;

    @ColumnInfo(name = "main_ingredient")
    private String mainIngredient;

    @ColumnInfo(name = "sub_ingredient")
    private String subIngredient;

    @ColumnInfo(name = "process")
    private String process;

    @ColumnInfo(name = "image")
    private int image;

    public Food(int type, String name, String mainIngredient, String subIngredient, String process, int image) {
        this.type = type;
        this.name = name;
        this.mainIngredient = mainIngredient;
        this.subIngredient = subIngredient;
        this.process = process;
        this.image = image;
    }
}
