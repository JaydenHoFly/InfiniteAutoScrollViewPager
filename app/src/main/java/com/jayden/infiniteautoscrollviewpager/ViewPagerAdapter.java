package com.jayden.infiniteautoscrollviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jaydenho.extensionalviewpager.RecyclingPagerAdapter;

/**
 * Created by hedazhao on 2017/2/15.
 */
public class ViewPagerAdapter extends RecyclingPagerAdapter {

    public static final int VIEW_TYPE_1 = 0;//view_type一定要从0开始按顺序递增,因为recycleBin中存储View的容器是数组
    public static final int VIEW_TYPE_2 = 1;

    private Context mContext = null;

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        int realPosition = getRealPosition(position);
        int viewType = getItemViewType(position);
        if (convertView == null) {
            switch (viewType) {
                case VIEW_TYPE_1:
                    convertView = new ViewPagerItemStyle1(mContext);
                    break;
                case VIEW_TYPE_2:
                    convertView = new ViewPagerItemStyle2(mContext);
                    break;
            }
        }
        if (convertView instanceof BaseViewPagerItem) {
            ((BaseViewPagerItem) convertView).refreshUI(realPosition);
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = IGNORE_ITEM_VIEW_TYPE;
        switch (getRealPosition(position)) {
            case 0:
            case 2:
            case 4:
                viewType = VIEW_TYPE_1;
                break;
            case 1:
            case 3:
                viewType = VIEW_TYPE_2;
                break;
        }
        return viewType;
    }

    @Override
    public int getRealCount() {
        return 5;
    }
}
