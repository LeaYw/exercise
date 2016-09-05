package com.lyw.exercise.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ScrollTopBehavior extends CoordinatorLayout.Behavior<View> {
    int offsetTotal = 0;
    boolean scrolling = false;

    public ScrollTopBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
//        offset(child, dyConsumed);
        Log.e("dddd", dxConsumed + "---" + target.getScrollY() + "---" + child.getHeight());
        if (dyConsumed > 0) {//往上滑
            offset(child, dyConsumed);
//            if (target.getScrollY()>child.getHeight()){
//                //没有顶住child
//                offset(child,dyConsumed);
//            } else {
//                //顶住child
//                offset(child,dyConsumed);
//            }

        } else {//往下滑
            if (target.getScrollY() > child.getHeight()) {
                //没有订到child

            } else {
                //顶住child
                offset(child, dyConsumed);
            }
        }
    }
    private boolean isFling = false;

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
        if (velocityY<0/* && target.ge*/){
            offset(child,-child.getHeight());
        }
        Log.e("dddd", "dddd" + velocityY);
        return true;
    }

    public void offset(View child, int dy) {
        int old = offsetTotal;
        int top = offsetTotal - dy;
        top = Math.max(top, -child.getHeight());
        top = Math.min(top, 0);
        offsetTotal = top;
        if (old == offsetTotal) {
            scrolling = false;
            return;
        }
        int delta = offsetTotal - old;
        child.offsetTopAndBottom(delta);
        scrolling = true;
    }

}
