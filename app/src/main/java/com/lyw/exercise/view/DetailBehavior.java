package com.lyw.exercise.view;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class DetailBehavior extends AppBarLayout.ScrollingViewBehavior {

    private AppBarLayout appBarLayout;

    private int count;

    public DetailBehavior() {
    }

    public DetailBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 当联动布局behavior与目标View挂载时候回调
     *
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, final View child, final View dependency) {
        if (appBarLayout == null)
            appBarLayout = (AppBarLayout) dependency;

        final boolean result = super.onDependentViewChanged(parent, child, dependency);
        final int bottomPadding = calculateBottomPadding(appBarLayout);

        if (bottomPadding != child.getPaddingBottom() && Build.VERSION.SDK_INT <= 17 && count < 3) { //3次就够了
            //解决滑动bug
            dependency.requestLayout();
            count++;
        }

        if (Math.abs(dependency.getBottom() - child.getTop()) > 5) {
            dependency.requestLayout();
        }

        return result;
    }

    /**
     * 计算AppBar底部到RecyclerView顶部的距离
     */
    private int calculateBottomPadding(AppBarLayout dependency) {
        final int totalScrollRange = dependency.getTotalScrollRange();
        return totalScrollRange + dependency.getTop();
    }
}
