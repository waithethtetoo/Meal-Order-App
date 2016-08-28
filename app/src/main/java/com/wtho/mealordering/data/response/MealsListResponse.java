package com.wtho.mealordering.data.response;

import com.google.gson.annotations.SerializedName;
import com.wtho.mealordering.data.vo.MealVo;

import java.util.ArrayList;

/**
 * Created by WT on 8/20/2016.
 */
public class MealsListResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("meal_list")
    private ArrayList<MealVo> mealList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<MealVo> getMealsList() {
        return mealList;
    }
}
