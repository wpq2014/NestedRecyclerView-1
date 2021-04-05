package com.yu.nested.recyclerview.demo;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.yu.nested.library.NestedParentRecyclerView;
import com.yu.nested.recyclerview.R;
import com.yu.nested.recyclerview.Utils;

public class AdTabFragment extends OutTabFragment {

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_ad_tab;
    }

    @Override
    public void loadView(View view) {
        super.loadView(view);

        final View mountingTabView = view.findViewById(R.id.mountingTab);
        //设置吸顶偏移量，增加广告后，需要提前进入吸顶状态
        final int adHeight = (int) Utils.dp2px(view.getContext(), 30f);
        mNestedRecyclerView.setMountingDistance(adHeight);
        mNestedRecyclerView.setChildRecyclerViewHelper(new NestedParentRecyclerView.ChildRecyclerViewHelper() {
            @Override
            public RecyclerView getCurRecyclerView() {
                return mBottomTabView.getCurRecyclerView();
            }

            @Override
            public View getInnerTabView() {
                return mBottomTabView.getTabLayout();
            }

            @Override
            public View getOutTabView() {
                return mountingTabView;
            }
        });

        final View adView = view.findViewById(R.id.ad);
        adView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adView.setVisibility(View.GONE);
                mBottomTabView.setViewHeight(mNestedRecyclerView.getMeasuredHeight());
                mNestedRecyclerView.setMountingDistance(0);
                mNestedRecyclerView.scrollUp(adHeight);
            }
        });

        mNestedRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                //为了关闭广告后，吸顶栏
                mBottomTabView.setViewHeight(mNestedRecyclerView.getMeasuredHeight() - adHeight);
            }
        });
    }
}
