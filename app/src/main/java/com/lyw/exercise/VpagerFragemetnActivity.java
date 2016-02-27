package com.lyw.exercise;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lyw.exercise.adapter.MyFragmentAdapter;
import com.lyw.exercise.fragment.LevelFragment;
import com.lyw.exercise.fragment.TaskFragment;

import java.util.ArrayList;

public class VpagerFragemetnActivity extends AppCompatActivity {
	private ArrayList<Fragment> fragments;
	private ViewPager mPager;
	private TextView view1, view2, view3, view4;
	private ImageView image;
	private int bmpWidth;//横线宽度
	private int offset;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vpager_fragemetn);
		initTextView();
		initImage();
		initViewpager();
	}

	private void initTextView() {
		view1 = (TextView) findViewById(R.id.tv_guide1);
		view2 = (TextView) findViewById(R.id.tv_guide2);
		view3 = (TextView) findViewById(R.id.tv_guide3);
		view4 = (TextView) findViewById(R.id.tv_guide4);

		view1.setOnClickListener(new TxListener(0));
		view2.setOnClickListener(new TxListener(1));
		view3.setOnClickListener(new TxListener(2));
		view4.setOnClickListener(new TxListener(3));
	}

	class TxListener implements View.OnClickListener {
		private int index = 0;

		public TxListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	}

	private void initImage() {
		image = (ImageView) findViewById(R.id.cursor);
		bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.cursor).getWidth();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int screenWidth = metrics.widthPixels;
		offset = (screenWidth / 4 - bmpWidth) / 2;

		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}

	private void initViewpager() {
		mPager = (ViewPager) findViewById(R.id.viewpage);
		fragments = new ArrayList<>();
		TaskFragment taskFragment1 = TaskFragment.newInstance();
		TaskFragment taskFragment2 = TaskFragment.newInstance();
		TaskFragment levelFragment1 = TaskFragment.newInstance();
		TaskFragment levelFragment2 = TaskFragment.newInstance();
		fragments.add(taskFragment1);
		fragments.add(taskFragment2);
		fragments.add(levelFragment1);
		fragments.add(levelFragment2);

		mPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), fragments));
		mPager.setCurrentItem(0);
		mPager.addOnPageChangeListener(new MyOnPageChangeListener());
	}

	class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
		private int one = offset * 2 + bmpWidth;

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
			ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) image.getLayoutParams();
			params.leftMargin = position * one + positionOffsetPixels / fragments.size();
			image.requestLayout();
		}

		@Override
		public void onPageSelected(int position) {
//			Animation animation = new TranslateAnimation(currentIndex * one, position * one, 0, 0);
//			currentIndex = position;
//			animation.setFillAfter(true);
//			animation.setDuration(200);
//			image.startAnimation(animation);
		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	}
}
