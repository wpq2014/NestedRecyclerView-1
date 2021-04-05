package com.yu.nested.recyclerview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;

import com.google.android.material.tabs.TabLayout;
import com.yu.nested.recyclerview.Utils;

public class RelatedTabLayout extends TabLayout {
    private static final String TAG = RelatedTabLayout.class.getSimpleName();

    private TabLayout mScrollView;

    public RelatedTabLayout(Context context) {
        super(context);
    }

    public RelatedTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldL, int oldT) {
        super.onScrollChanged(l, t, oldL, oldT);
        if (mScrollView != null) {
            mScrollView.scrollTo(l, t);
        }
    }

    public void setRelateScrollView(TabLayout scrollView) {
        mScrollView = scrollView;
    }

    private final float DEFAULT_HEIGHT = Utils.dp2px(getContext(), 20f);
    private float animationProgress = 1f;

    /**
     * 属性动画 setAnimationProgress
     *
     * @param progress
     */
    public void setAnimationProgress(float progress) {
        this.animationProgress = progress;
//        ViewGroup.LayoutParams lp = getLayoutParams();
//        Log.e("动画1", "" + animationProgress);
//        if (progress <= 1f) {
//            lp.height = (int) (DEFAULT_HEIGHT + 80 * progress);
//        }
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), (int) (DEFAULT_HEIGHT * progress));
    }

    /**
     * 属性动画 getAnimationProgress
     *
     * @return
     */
    public float getAnimationProgress() {
        return animationProgress;
    }
}
