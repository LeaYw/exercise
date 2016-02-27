package com.lyw.exercise.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	public CircleView(Context context) {
		super(context);
	}

	public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
		int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
		int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
		int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

		if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
			setMeasuredDimension(200, 200);
		} else if (widthSpecMode == MeasureSpec.AT_MOST) {
			setMeasuredDimension(200, heightSpecSize);
		} else if (heightSpecMode == MeasureSpec.AT_MOST) {
			setMeasuredDimension(widthSpecSize, 200);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		final int paddingLeft = getPaddingLeft();
		final int paddingRight = getPaddingRight();
		final int paddingTop = getPaddingTop();
		final int paddingBottom = getPaddingBottom();
		int width = getWidth() - paddingLeft - paddingRight;
		int height = getHeight() - paddingBottom - paddingTop;
		int radius = Math.min(width, height) / 2;
		int cx = paddingLeft + width / 2;
		int cy = paddingTop + height / 2;
		canvas.drawLine(paddingLeft, cy, paddingLeft + width, cy, mPaint);
		canvas.drawLine(cx, paddingTop, cx, paddingTop + height, mPaint);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeWidth(3f);
		mPaint.setColor(Color.RED);
		canvas.drawCircle(cx, cy, radius, mPaint);
		mPaint.setColor(Color.BLUE);
		mPaint.setTextSize(100f);
		canvas.drawText("A", paddingLeft + width / 4, paddingTop + height / 4 * 3, mPaint);
	}
}
