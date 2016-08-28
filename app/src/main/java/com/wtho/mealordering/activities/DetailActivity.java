package com.wtho.mealordering.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wtho.mealordering.MealOrderingApp;
import com.wtho.mealordering.R;
import com.wtho.mealordering.data.model.MealModel;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.utils.MealsConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WT on 8/19/2016.
 */
public class DetailActivity extends AppCompatActivity {

    private static final String MEALS_NAME = "MEALS_NAME";
    //    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //    @BindView(R.id.fab)
    FloatingActionButton fab;

    //    @BindView(R.id.tv_meal_desc)
    TextView tv_meal_desc;
    TextView tv_meal_price;
    TextView tv_meal_ingredients;
    //    @BindView(R.id.iv_meal)
    ImageView iv_meal;

    //    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    private MealVo mealVo;

    public static Intent newIntent(String mealName) {
        Intent intent = new Intent(MealOrderingApp.getContext(), DetailActivity.class);
        intent.putExtra(MEALS_NAME, mealName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        ButterKnife.bind(this, this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        tv_meal_desc = (TextView) findViewById(R.id.tv_meal_desc);
        tv_meal_price = (TextView) findViewById(R.id.tv_meal_price);
        tv_meal_ingredients = (TextView) findViewById(R.id.tv_meal_ingredient);
        iv_meal = (ImageView) findViewById(R.id.iv_meal);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String mealName = getIntent().getStringExtra(MEALS_NAME);
        mealVo = MealModel.getInstance().getMealsByName(mealName);
        if (mealVo == null) {
            throw new RuntimeException("No meal found with name : " + mealName);
        } else {
            tv_meal_desc.setText(mealVo.getDesc() + "\n\n"
                    + mealVo.getDesc());
            tv_meal_price.setText(mealVo.getPrice());

            String ingredientsUrl = MealsConstants.INGREDIENTS_DIR + mealVo.getIngredients()[0];
            tv_meal_ingredients.setText(ingredientsUrl);

            String imageUrl = mealVo.getImage_url();
            Glide.with(iv_meal.getContext())
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(R.drawable.stock_photo_placeholder)
                    .error(R.drawable.stock_photo_placeholder)
                    .into(iv_meal);

            collapsingToolbar.setTitle(mealName);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Context context = MealOrderingApp.getContext();
            String transitionName = context.getResources().getString(R.string.meal_list_detail_transition_name);
            iv_meal.setTransitionName(transitionName);
        }
    }


    private void bindData(MealVo mealVo) {
        tv_meal_desc.setText(mealVo.getDesc() + "\n\n"
                + mealVo.getDesc());
    }

}
