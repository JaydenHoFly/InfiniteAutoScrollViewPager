package com.jayden.infiniteautoscrollviewpager;

import android.app.Activity;
import android.os.Bundle;

import com.jaydenho.extensionalviewpager.CircleIndicator;
import com.jaydenho.extensionalviewpager.viewpager.AutoScrollViewPager;

/**
 * Created by hedazhao on 2017/2/15.
 */
public class InfiniteAutoScrollViewPagerActivity extends Activity {

    /**
     * 滑动页面自动滑动时，每个页面的停留时间
     */
    private static final long SCROLL_ITEM_AUTO_SCROLL_INTERVAL_TIME = 2000;

    /**
     * 滑动页面自动滑动时的时间因子，自动滑动的时间基数大概是200ms
     */
    private static final int SCROLL_ITEM_AUTO_SCROLL_DURATION_FACTOR = 3;

    private AutoScrollViewPager mViewPager = null;
    private ViewPagerAdapter mViewPagerAdapter = null;
    private CircleIndicator mIndicator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_auto_scroll_viewpager);

        initData();
        initView();
        initEvent();
    }

    private void initData() {
        mViewPagerAdapter = new com.jayden.infiniteautoscrollviewpager.ViewPagerAdapter(this);
    }

    private void initView() {
        mViewPager = (AutoScrollViewPager) findViewById(R.id.viewpager_infinite_auto_scroll);
        mIndicator = (CircleIndicator) findViewById(R.id.indicator);
    }

    private void initEvent() {
        mViewPagerAdapter.setInfiniteLoop(true);//是否无限滑动
        mViewPager.setInterval(SCROLL_ITEM_AUTO_SCROLL_INTERVAL_TIME);//页面自动滑动时，每个页面停留的时间
        mViewPager.setAutoScrollDurationFactor(SCROLL_ITEM_AUTO_SCROLL_DURATION_FACTOR);//页面自动滑动时，滑动过程所需时间的因子
        mViewPager.setAdapter(mViewPagerAdapter);
        mIndicator.setViewPager(mViewPager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewPager.startAutoScroll();//开始自动滑动
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewPager.stopAutoScroll();//停止自动滑动
    }
}
