package com.lyw.exercise;

import android.app.UiModeManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UiModeManagerActivity extends AppCompatActivity {
	private static final String TAG = "UiModeManagerActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_mode_manager);
	}

	public void onClick(View view){
		UiModeManager manager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
		switch (view.getId()){
			case R.id.car_mode_yes:
//				开启车载模式
				manager.enableCarMode(0);
				break;
			case R.id.car_mode_no:
//				关闭车载模式
				manager.disableCarMode(0);
				break;
			case R.id.night_mode_yes:
//				开启夜间模式，注意setNightMode只有在开启车载模式时才起作用
				manager.setNightMode(UiModeManager.MODE_NIGHT_YES);
				Log.e(TAG, String.valueOf(manager.getNightMode()));
				break;
			case R.id.night_mode_no:
//				关闭夜间模式
				manager.setNightMode(UiModeManager.MODE_NIGHT_YES);
				Log.e(TAG, String.valueOf(manager.getNightMode()));
				break;
		}
		((Button)view).setText(String.valueOf(manager.getCurrentModeType()));
	}
}
