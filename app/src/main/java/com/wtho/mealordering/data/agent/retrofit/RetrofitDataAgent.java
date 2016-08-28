package com.wtho.mealordering.data.agent.retrofit;

import android.util.Log;

import com.wtho.mealordering.data.agent.DataAgent;
import com.wtho.mealordering.data.agent.retrofit.TheAPI;
import com.wtho.mealordering.data.model.MealModel;
import com.wtho.mealordering.data.response.MealsListResponse;
import com.wtho.mealordering.utils.CommonInstances;
import com.wtho.mealordering.utils.MealsConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by WT on 8/20/2016.
 */
public class RetrofitDataAgent implements DataAgent {

    private static RetrofitDataAgent objInstance;

    private final TheAPI theApi;

    private RetrofitDataAgent() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MealsConstants.MEALS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TheAPI.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadMeals() {

        Call<MealsListResponse> loadMealCall = theApi.loadMeals(MealsConstants.ACCESS_TOKEN);

        loadMealCall.enqueue(new Callback<MealsListResponse>() {

            @Override
            public void onResponse(Call<MealsListResponse> call, Response<MealsListResponse> response) {
                MealsListResponse mealsListResponse = response.body();
                if (mealsListResponse == null) {
                    MealModel.getInstance().notifyErrorInLoadingMeals(response.message());
                } else {
                    MealModel.getInstance().notifyMealsLoaded(mealsListResponse.getMealsList());
                }
            }

            // HTTP response type Failure
            @Override
            public void onFailure(Call<MealsListResponse> call, Throwable throwable) {
                MealModel.getInstance().notifyErrorInLoadingMeals(throwable.getMessage());
            }
        });
    }
}
