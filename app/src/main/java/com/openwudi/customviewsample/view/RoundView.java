package com.openwudi.customviewsample.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

import com.openwudi.customviewsample.R;

/**
 * Created by wudi on 15/7/1.
 */
public class RoundView extends ImageView {
    public RoundView(Context context) {
        super(context);
        initViews();
    }

    public RoundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public RoundView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoundView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initViews();
    }

    private void initViews() {
        setImageDrawable(getResources().getDrawable(R.drawable.google_web_search));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int width) {
        int mode = MeasureSpec.getMode(width);
        int size = MeasureSpec.getSize(width);

        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        }

    }

    private int measureHeight(int height) {
        int mode = MeasureSpec.getMode(height);
        int size = MeasureSpec.getSize(height);

        if (mode == MeasureSpec.EXACTLY) {
            return size;
        } else {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
