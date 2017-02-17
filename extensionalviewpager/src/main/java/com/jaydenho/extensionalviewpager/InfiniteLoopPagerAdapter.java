package com.jaydenho.extensionalviewpager;

import android.support.v4.view.PagerAdapter;

/**
 * Created by hedazhao on 2017/1/18.
 * 实现无限循环的ViewPager，适配了CircleIndicator和AutoScrollViewPager
 */
public abstract class InfiniteLoopPagerAdapter extends PagerAdapter {
    protected boolean mIsInfiniteLoop = false;
    private static final int INFINITE_LOOP_MAX_COUNT = 10000;

    @Override
    public int getCount() {
        return mIsInfiniteLoop ? INFINITE_LOOP_MAX_COUNT : getRealCount();
    }

    public abstract int getRealCount();

    public int getRealPosition(int position) {
        return mIsInfiniteLoop ? position % getRealCount() : position;
    }

    public InfiniteLoopPagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.mIsInfiniteLoop = isInfiniteLoop;
        return this;
    }

    public boolean isInfiniteLoop() {
        return mIsInfiniteLoop;
    }

}
