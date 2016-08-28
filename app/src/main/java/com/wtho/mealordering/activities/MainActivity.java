package com.wtho.mealordering.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.wtho.mealordering.R;
import com.wtho.mealordering.data.vo.MealVo;
import com.wtho.mealordering.fragment.MealsFragment;
import com.wtho.mealordering.view.MealViewHolder;

/**
 * Created by WT on 8/19/2016.
 */

public class MainActivity extends AppCompatActivity implements MealViewHolder.ControllerItem {

    //    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //    @BindView(R.id.fab_search)
    FloatingActionButton fabSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this, this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigateToRecyclerView();

        fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    private void navigateToRecyclerView() {
        MealsFragment mealsFragment=new MealsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, mealsFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void onTapMeal(MealVo mealVo, ImageView iv_meal) {
        Intent intent = DetailActivity.newIntent(mealVo.getName());
        startActivity(intent);
    }

}
