package com.wtho.mealordering.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.wtho.mealordering.MealOrderingApp;
import com.wtho.mealordering.R;
import com.wtho.mealordering.activities.DetailActivity;
import com.wtho.mealordering.adapter.MealAdapter;
import com.wtho.mealordering.data.model.MealModel;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.event.DataEvent;
import com.wtho.mealordering.utils.MealsConstants;
import com.wtho.mealordering.view.MealViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by WT on 8/20/2016.
 */
public class MealsFragment extends Fragment {
    //    @BindView(R.id.rv_meals)
    RecyclerView rv_meals;

    private MealAdapter mealAdapter;
    private MealViewHolder.ControllerItem controllerItem;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        controllerItem = (MealViewHolder.ControllerItem) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meals_list, container, false);
//        ButterKnife.bind(this, rootView);

        rv_meals = (RecyclerView) rootView.findViewById(R.id.rv_meals);

        List<MealVo> mealVoList = MealModel.getInstance().getmMealList();
        Log.d(MealOrderingApp.TAG, mealVoList.toString());
        mealAdapter = new MealAdapter(mealVoList, controllerItem);
        rv_meals.setAdapter(mealAdapter);

//        int gridColumnSpanCount = getResources().getInteger(R.integer.attraction_list_grid);
        rv_meals.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    public void onEvent(DataEvent.MealsDataLoaded event) {
        mealAdapter.setNewData(MealModel.getInstance().getmMealList());
    }

}
