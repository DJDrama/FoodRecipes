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

    @ColumnInfo(name = "specific_type")
    private int specificType;

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


    public Food(){

    }
    public Food(int type, int sType, String name, String mainIngredient, String subIngredient, String process, int image) {
        this.type = type;
        this.specificType = sType;
        this.name = name;
        this.mainIngredient = mainIngredient;
        this.subIngredient = subIngredient;
        this.process = process;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpecificType() {
        return specificType;
    }

    public void setSpecificType(int specificType) {
        this.specificType = specificType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainIngredient() {
        return mainIngredient;
    }

    public void setMainIngredient(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    public String getSubIngredient() {
        return subIngredient;
    }

    public void setSubIngredient(String subIngredient) {
        this.subIngredient = subIngredient;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
