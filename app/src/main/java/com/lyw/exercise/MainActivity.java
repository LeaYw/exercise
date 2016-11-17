package com.lyw.exercise;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lyw.exercise.model.ItemDetailActivity;
import com.lyw.exercise.view.FlowLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

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
    }

    private void testUrlParse() {

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
                Toast.makeText(this, "settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
