package com.wtho.mealordering.event;

import com.wtho.mealordering.data.vo.MealVo;

import java.util.List;

/**
 * Created by WT on 8/22/2016.
 */
public class DataEvent {

    public static class MealsDataLoaded{
        private String extraMessage;
        private List<MealVo> mealVoList;

        public MealsDataLoaded(String extraMessage, List<MealVo> mealVoList) {
            this.extraMessage = extraMessage;
            this.mealVoList = mealVoList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<MealVo> getMealVoList() {
            return mealVoList;
        }
    }
}
