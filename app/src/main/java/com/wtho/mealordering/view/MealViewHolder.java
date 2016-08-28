package com.wtho.mealordering.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wtho.mealordering.R;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.utils.MealsConstants;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WT on 8/19/2016.
 */
public class MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //    @BindView(R.id.tv_meal_title)
    TextView tv_meal_title;

    //    @BindView(R.id.iv_meal)
    ImageView iv_meal;

    private ControllerItem mController;
    private MealVo mMeal;

    public MealViewHolder(View itemView, ControllerItem item) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        tv_meal_title = (TextView) itemView.findViewById(R.id.tv_meal_title);
        iv_meal = (ImageView) itemView.findViewById(R.id.iv_meal);
        mController = item;
    }


    public void BindData(MealVo meal) {
        mMeal = meal;
        tv_meal_title.setText(meal.getName());

        String imageUrl = meal.getImage_url();
        Glide.with(iv_meal.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(iv_meal);

    }

    @Override
    public void onClick(View view) {

        mController.onTapMeal(mMeal, iv_meal);
    }

    public void bindData(MealVo item) {
        mMeal = item;
        tv_meal_title.setText(item.getName());

        String imageUrl = item.getImage_url();
        Glide.with(iv_meal.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.stock_photo_placeholder)
                .error(R.drawable.stock_photo_placeholder)
                .into(iv_meal);
    }

    public interface ControllerItem {
        void onTapMeal(MealVo mealVo, ImageView iv_meal);
    }
}
