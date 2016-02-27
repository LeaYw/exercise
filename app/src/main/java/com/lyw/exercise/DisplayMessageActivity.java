package com.lyw.exercise;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.support.v4.app.FragmentManager;
import com.lyw.exercise.fragment.LevelFragment;
import com.lyw.exercise.fragment.TaskFragment;

public class DisplayMessageActivity extends AppCompatActivity {
	private boolean showTask = true;
	private TaskFragment taskFragment;
	private LevelFragment levelFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		Toolbar childBar = (Toolbar) findViewById(R.id.my_child_toolbar);
		setSupportActionBar(childBar);
		ActionBar ab = getSupportActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		taskFragment = TaskFragment.newInstance();
		levelFragment = LevelFragment.newInstance("hello", "hello");
		ft.replace(R.id.fragment_container, taskFragment);
		ft.commit();
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.text_tab1:
				if (!showTask) {
					FragmentManager fragmentManager = getSupportFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.fragment_container, taskFragment);
					transaction.commit();
					showTask = true;
				}
				break;
			case R.id.text_tab2:
				if (showTask) {
					FragmentManager fragmentManager = getSupportFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.fragment_container, levelFragment);
					transaction.commit();
					showTask = false;
				}
				break;
			case R.id.to_third:
				Intent intent = new Intent(this,VpagerFragemetnActivity.class);
				startActivity(intent);
				break;
			default:
				break;
		}
	}

}
