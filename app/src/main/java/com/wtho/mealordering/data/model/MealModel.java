package com.wtho.mealordering.data.model;

import android.content.IntentFilter;

import com.google.gson.reflect.TypeToken;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.event.DataEvent;
import com.wtho.mealordering.utils.CommonInstances;
import com.wtho.mealordering.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by WT on 8/19/2016.
 */
public class MealModel {

    private static MealModel objInstance;

    private List<MealVo> mMealList;

    private MealModel() {
//        MealModel.getInstance().getmMealList();
        mMealList = new ArrayList<>();

    }


    public static MealModel getInstance() {
        if (objInstance == null) {
            objInstance = new MealModel();
        }
        return objInstance;
    }

    public List<MealVo> getmMealList() {
        return mMealList;
    }

    public MealVo getMealsByName(String mealName) {
        for (MealVo mealVo : mMealList) {
            if (mealVo.getName().equals(mealName))
                return mealVo;
        }
        return null;
    }

    public void notifyMealsLoaded(List<MealVo> mealVoList) {
        //Notify that the data is ready - using LocalBroadcast
        mMealList = mealVoList;
        broadcastAttractionLoadedWithEventBus();
    }

    private void broadcastAttractionLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.MealsDataLoaded("extra-in-broadcast", mMealList));
    }

    public void notifyErrorInLoadingMeals(String message) {

    }

    public void setStoredData(List<MealVo> mealList) {
        mMealList = mealList;
    }
}
