package com.wtho.mealordering.utils;

import com.google.gson.Gson;

/**
 * Created by WT on 8/19/2016.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
