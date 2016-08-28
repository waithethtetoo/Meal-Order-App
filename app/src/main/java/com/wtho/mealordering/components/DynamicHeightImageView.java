package com.wtho.mealordering.components;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by WT on 8/19/2016.
 */

public class DynamicHeightImageView extends ImageView {
    private float mAspectRatio = 1.4f;

    public DynamicHeightImageView(Context context) {
        super(context);
    }

    public DynamicHeightImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (measuredWidth / mAspectRatio));
    }
}
