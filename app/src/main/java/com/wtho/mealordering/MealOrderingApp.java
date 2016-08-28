package com.wtho.mealordering;

import android.app.Application;
import android.content.Context;

import com.wtho.mealordering.data.agent.retrofit.RetrofitDataAgent;

/**
 * Created by WT on 8/19/2016.
 */
public class MealOrderingApp extends Application {
    public static final String TAG = "MealOrderingApp";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        RetrofitDataAgent.getInstance().loadMeals();
    }

    public static Context getContext() {
        return context;
    }
}
