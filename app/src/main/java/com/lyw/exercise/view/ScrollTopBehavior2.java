package com.lyw.exercise.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

public class ScrollTopBehavior2 extends CoordinatorLayout.Behavior<NestedScrollView> {
    int offsetTotal = 0;
    boolean scrolling = false;

    public ScrollTopBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, NestedScrollView child, View dependency) {
        return dependency instanceof NestedScrollView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, NestedScrollView child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
