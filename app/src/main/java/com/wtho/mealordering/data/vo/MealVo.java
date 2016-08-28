package com.wtho.mealordering.data.vo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.wtho.mealordering.MealOrderingApp;
import com.wtho.mealordering.utils.MealsConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WT on 8/19/2016.
 */
public class MealVo {

    private int id;
    private String name;
    private String desc;
    private String image_url;
    private String price;
    private String[] ingredients;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getPrice() {
        return price;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }


}
