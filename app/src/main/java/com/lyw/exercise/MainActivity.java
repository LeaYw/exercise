package com.lyw.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyw.exercise.utils.TimeUtils;
import com.lyw.exercise.model.Address;
import com.lyw.exercise.model.ItemDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	private List<Address> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		Uri number = Uri.parse("tel:18201558311");
//		Intent intent = new Intent(Intent.ACTION_DIAL,number);
//		PackageManager packageManager = getPackageManager();
//		List activities = packageManager.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
//		if (activities.size()>0){
//			startActivity(intent);
//		}
		Toolbar toolbar = (Toolbar) findViewById(R.id.my_toobar);
		setSupportActionBar(toolbar);
		testHtml();
		testUrlParse();
		TimeUtils.getNextMonthTime();
	}

	static class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
		}
	}

	private void testUrlParse() {
		String path = "http://dev.17kaojiaoshi.com/qbweb/exam/index.php?yq_exam_id=511&signature=36c74d7e675590e3bbfcdc3af5ed2265498e3903";
	}

	private void testHtml() {
//        ((TextView)findViewById(R.id.full_star_pass)).setText(Html.fromHtml(String.format(getString(resId),
//                countFullStarLevel())));
		TextView testHtml = (TextView) findViewById(R.id.test_html);
		SpannableString spannableString = new SpannableString("span");
		spannableString.setSpan(new AbsoluteSizeSpan(10, true), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		spannableString.setSpan(new AbsoluteSizeSpan(20, true), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		testHtml.setText(spannableString);
//        testHtml.setText(Html.fromHtml(String.format(getString(R.string.html_text),11,22)));
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.group_recyclerview:
				startActivity(new Intent(this, GroupRecyclerViewActivity.class));
				break;
			case R.id.status_immersive:
				startActivity(new Intent(this, StatusBarImmersiveActivity.class));
				break;
			case R.id.card_view:
				startActivity(new Intent(this, CardViewActivity.class));
				break;
			case R.id.material_flow:
				startActivity(new Intent(this, ItemDetailActivity.class));
				break;
			case R.id.navigation_drawer:
				startActivity(new Intent(this, NacigationDrawerActivity.class));
				break;
			case R.id.data_binding:
				startActivity(new Intent(this, DataBindingActivity.class));
				break;
			case R.id.test_tab_activity:
				startActivity(new Intent(this, TestTabActivity.class));
				break;
			case R.id.test_flow_layout:
				startActivity(new Intent(this, FlowLayoutActivity.class));
				break;
			case R.id.test_scroll_top:
				startActivity(new Intent(this, ScrollTopActivity.class));
				break;
			case R.id.test_media:
				startActivity(new Intent(this, MediaActivity.class));
				break;
			case R.id.test_video_view:
				startActivity(new Intent(this, VideoViewActivity.class));
				break;
			case R.id.test_address:
				startActivity(new Intent(this, AddressActivity.class));
				break;
			case R.id.test_telephone_manager:
				TelephonyManager manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
				Log.e("SoftwareVersion", manager.getDeviceSoftwareVersion());
				Log.e("getDeviceId", manager.getDeviceId());
				Log.e("getPhoneType", manager.getPhoneType() + "");
				Log.e("getNetworkOperatorName", manager.getNetworkOperatorName());
				Log.e("getNetworkOperator", manager.getNetworkOperator());
				Log.e("isNetworkRoaming", manager.isNetworkRoaming() + "");
				Log.e("getNetworkCountryIso", manager.getNetworkCountryIso());
				Log.e("getNetworkType", manager.getNetworkType() + "");
				Log.e("getSimState", manager.getSimState() + "");
				Log.e("getSimOperator", manager.getSimOperator());
				Log.e("getSimOperatorName", manager.getSimOperatorName());
				Log.e("getSimCountryIso", manager.getSimCountryIso());
				Log.e("getSimSerialNumber", manager.getSimSerialNumber());
				Log.e("getSubscriberId", manager.getSubscriberId());
				Log.e("getGroupIdLevel1", manager.getGroupIdLevel1());
				Log.e("getLine1Number", manager.getLine1Number());
//				Log.e("dddddddd",manager.getVoiceMailNumber());
				Log.e("getVoiceMailAlphaTag", manager.getVoiceMailAlphaTag());
				Log.e("getCallState", manager.getCallState() + "");
				Log.e("getDataActivity", manager.getDataActivity() + "");
				Log.e("getDataState", manager.getDataState() + "");
				Log.e("getMmsUserAgent", manager.getMmsUserAgent() + "");
				Log.e("getMmsUAProfUrl", manager.getMmsUAProfUrl());
				break;
			case R.id.test_settings:
//				Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
//				if (intent.resolveActivity(getPackageManager()) != null) {
//					startActivity(intent);
//				}
				//xiaomi
//				Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR");
//				ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
//				i.setComponent(componentName);
//				i.putExtra("extra_pkgname", getPackageName());
//				if (i.resolveActivity(getPackageManager()) != null){
//					startActivity(i);
//				}
				//华为
//				try {
//					Intent intent = new Intent();
//					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//					ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
//					intent.setComponent(comp);
//					startActivity(intent);
//				} catch (Exception e) {
//					e.printStackTrace();
////					startActivity(getAppDetailSettingIntent());
//				}
				//meizu
//				Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
//				intent.addCategory(Intent.CATEGORY_DEFAULT);
//				intent.putExtra("packageName", BuildConfig.APPLICATION_ID);
//				if (intent.resolveActivity(getPackageManager()) != null){
//					startActivity(intent);
//				}
				//应用信息
//				Intent localIntent = new Intent();
//				localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				if (Build.VERSION.SDK_INT >= 9) {
//					localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
//					localIntent.setData(Uri.fromParts("package", getPackageName(), null));
//				}
//				startActivity(localIntent);
				break;
			case R.id.test_input_method_manager:
				startActivity(new Intent(this, InputMethodManagerActivity.class));
				break;
			case R.id.test_ui_mode_manager:
				startActivity(new Intent(this, UiModeManagerActivity.class));
				break;
			case R.id.test_download_manager:
				startActivity(new Intent(this, DownloadManagerActivity.class));
				break;
		}
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);

		MenuItem searchItem = menu.findItem(R.id.action_search);
		SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

		MenuItemCompat.OnActionExpandListener onActionExpandListener = new MenuItemCompat.OnActionExpandListener() {
			@Override
			public boolean onMenuItemActionExpand(MenuItem item) {
				Toast.makeText(MainActivity.this, "展开", Toast.LENGTH_SHORT).show();
				return true;
			}

			@Override
			public boolean onMenuItemActionCollapse(MenuItem item) {
				Toast.makeText(MainActivity.this, "收起", Toast.LENGTH_SHORT).show();
				return true;
			}
		};
		MenuItemCompat.setOnActionExpandListener(searchItem, onActionExpandListener);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.favorite:
				Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.action_settings:
//				Intent intent = new Intent(this, SettingsActivity.class);
//				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
