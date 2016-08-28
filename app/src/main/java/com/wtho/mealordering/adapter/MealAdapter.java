package com.wtho.mealordering.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wtho.mealordering.MealOrderingApp;
import com.wtho.mealordering.R;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.view.MealViewHolder;

import java.util.List;

/**
 * Created by WT on 8/19/2016.
 */
public class MealAdapter extends RecyclerView.Adapter<MealViewHolder> {

    private LayoutInflater mInflater;
    private MealViewHolder.ControllerItem mController;
    private List<MealVo> mMealList;

    public MealAdapter(List<MealVo> mealList, MealViewHolder.ControllerItem controllerItem) {
        mInflater = LayoutInflater.from(MealOrderingApp.getContext());
        mMealList = mealList;
        mController = controllerItem;
    }

    @Override
    public MealViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_meal, parent, false);
        return new MealViewHolder(itemView, mController);
    }

    @Override
    public void onBindViewHolder(MealViewHolder holder, int position) {
        holder.BindData(mMealList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMealList.size();
    }

    public void   setNewData(List<MealVo> newMealList) {
        mMealList = newMealList;
        notifyDataSetChanged();
    }
}
