package com.jayden.infiniteautoscrollviewpager;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by hedazhao on 2017/2/15.
 */
public abstract class BaseViewPagerItem extends FrameLayout {

    protected TextView mTV = null;

    protected int[] BACKGROUND_CONFIG = new int[]{R.mipmap.image_viewpager_01, R.mipmap.image_viewpager_02, R.mipmap.image_viewpager_03, R.mipmap.image_viewpager_04, R.mipmap.image_viewpager_05};

    public BaseViewPagerItem(Context context) {
        super(context);
    }

    protected void addTextView(Context context) {
        mTV = new TextView(context);
        mTV.setTextSize(15);
        mTV.setTextColor(getResources().getColor(R.color.colorAccent));
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.topMargin = 10;
        lp.gravity = Gravity.START;
        addView(mTV, lp);
    }

    protected void setText(String text) {
        mTV.setText(text);
    }

    public abstract void refreshUI(int realPosition);
}
