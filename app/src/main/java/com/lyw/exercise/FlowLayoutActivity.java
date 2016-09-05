package com.lyw.exercise;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lyw.exercise.view.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowLayoutActivity extends AppCompatActivity {

    private List<String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_flow_layout);

        LinearLayout layout = (LinearLayout) findViewById(R.id.main_content);

        FlowLayout flowLayout = new FlowLayout(this);
        flowLayout.setOnTagItemClickListener(new FlowLayout.OnTagItemClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v;
                Toast.makeText(FlowLayoutActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        initData();
        flowLayout.setTags(tags);
        layout.addView(flowLayout);

    }

    private void initData() {
        tags = new ArrayList<>();
        tags.add("阳哥你好！");
        tags.add("Android开发");
        tags.add("新闻热点");
        tags.add("热水进宿舍啦！");
        tags.add("I love you");
        tags.add("成都妹子");
        tags.add("新余妹子");
        tags.add("仙女湖");
        tags.add("创新工厂");
        tags.add("孵化园");
        tags.add("神州100发射");
        tags.add("有毒疫苗");
        tags.add("顶你阳哥阳哥");
        tags.add("Hello World");
        tags.add("闲逛的蚂蚁");
        tags.add("闲逛的蚂蚁");
        tags.add("闲逛的蚂蚁");
        tags.add("闲逛的蚂蚁");
        tags.add("闲逛的蚂蚁");
        tags.add("闲逛的蚂蚁");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
