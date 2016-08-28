package com.wtho.mealordering.data.agent.retrofit;

import com.wtho.mealordering.data.response.MealsListResponse;
import com.wtho.mealordering.utils.MealsConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by WT on 7/9/2016.
 */
public interface TheAPI {

    @FormUrlEncoded
    @POST(MealsConstants.API_GET_MEALS_LIST)
    Call<MealsListResponse> loadMeals(
            @Field(MealsConstants.PARAM_ACCESS_TOKEN) String param);
}
