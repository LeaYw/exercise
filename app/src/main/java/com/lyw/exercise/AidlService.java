package com.lyw.exercise;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.lyw.exercise.aidl.IMyAidlInterface;

public class AidlService extends Service {
	private static final String TAG = "AidlService";

	private IBinder binder = new IMyAidlInterface.Stub(){

		@Override
		public String getInfo(String s) throws RemoteException {
			return "Service get "+s+"----------";
		}
	};

	@Override
	public void onCreate() {
		super.onCreate();
		Log.e(TAG, "onCreate:");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return binder;
	}
}
