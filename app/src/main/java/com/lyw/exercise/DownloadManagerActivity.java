package com.lyw.exercise;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DownloadManagerActivity extends AppCompatActivity {
	private static final String TAG = "DownloadManagerActivity";
	private static final String PATH = "http://baobab.wdjcdn.com/1451897812703c.mp4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download_manager);

		IntentFilter filter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);

		BroadcastReceiver receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
//				reference对应startDownload中manger.enqueue的返回值。
				long reference = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
				Log.e(TAG, "onReceive: "+reference);
			}
		};
		registerReceiver(receiver, filter);
	}

	public void onClick(View view){
		switch (view.getId()){
			case R.id.download_start:
				startDownload();
				break;
		}
	}

	private void startDownload() {
		DownloadManager manager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
		DownloadManager.Request down = new DownloadManager.Request(Uri.parse(PATH));
		down.setDescription("test  test");
		down.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		down.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_MOVIES,"test.mp4");
		long l = manager.enqueue(down);
		Log.e(TAG, "startDownload: "+l);
	}
}
