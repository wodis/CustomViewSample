package com.openwudi.customviewsample.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.openwudi.customviewsample.R;

/**
 * Created by wudi on 15/7/2.
 */
public class CustomLayout extends LinearLayout {
    public CustomLayout(Context context) {
        super(context);
        initViews();
    }

    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    public void initViews() {
        setBackgroundResource(R.color.accent_material_dark);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);

        int childCnt = getChildCount();
        int currentHeight = getPaddingTop();
        int currentWidth = getPaddingLeft();

        for (int i = 0; i < childCnt; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            int childWidth = child.getMeasuredWidth();
            currentWidth += childWidth;
        }

        setMeasuredDimension(currentWidth * 2, resolveSize(sizeHeight, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            child.layout(childWidth, 0, r, childHeight);
        }
    }
}
