package com.lyw.exercise.Utils;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by liyawei on 17/2/15.
 */

public class TimeUtils {
	public static void getNextMonthTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH,1);
		Log.e("Dsafaaaa",calendar.getTime().toString());

	}
}
