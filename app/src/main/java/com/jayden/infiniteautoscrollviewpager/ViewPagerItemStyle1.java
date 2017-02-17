package com.jayden.infiniteautoscrollviewpager;

import android.content.Context;

/**
 * Created by hedazhao on 2017/2/15.
 */
public class ViewPagerItemStyle1 extends BaseViewPagerItem {
    public ViewPagerItemStyle1(Context context) {
        super(context);
        addTextView(context);
    }

    @Override
    public void refreshUI(int realPosition) {
        setBackgroundResource(BACKGROUND_CONFIG[realPosition]);
        setText("样式一 真实位置： " + realPosition);
    }

}
