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
    //    @BindView(R.id.tv_meal_desc)
    TextView tv_meal_desc;
    //    @BindView(R.id.tv_meal_price)
    TextView tv_meal_price;
    //    @BindView(R.id.tv_ingredients)
    TextView tv_ingredients;

    //    @BindView(R.id.iv_meal)
    ImageView iv_meal;

    private ControllerItem mController;
    private MealVo mMeal;

    public MealViewHolder(View itemView, ControllerItem item) {
        super(itemView);
//        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        tv_meal_title = (TextView) itemView.findViewById(R.id.tv_meal_title);
        tv_meal_desc = (TextView) itemView.findViewById(R.id.tv_meal_desc);
        tv_meal_price = (TextView) itemView.findViewById(R.id.tv_meal_price);
        tv_ingredients = (TextView) itemView.findViewById(R.id.tv_ingredients);
        iv_meal = (ImageView) itemView.findViewById(R.id.iv_meal);
        mController = item;
    }


    public void BindData(MealVo meal) {
        mMeal = meal;
        tv_meal_title.setText(meal.getName());
        tv_meal_desc.setText(meal.getDesc());
        tv_meal_price.setText(meal.getPrice());

        String ingredientsUrl = MealsConstants.MEALS_BASE_URL + meal.getIngredients()[0];
        tv_ingredients.setText(ingredientsUrl);

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
        tv_meal_desc.setText(item.getDesc());
        tv_meal_price.setText(item.getPrice());
        String ingredientsUrl = MealsConstants.MEALS_BASE_URL + item.getIngredients()[0];
        tv_ingredients.setText(ingredientsUrl);

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
