package com.lyw.exercise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lyw.exercise.adapter.NormalRecyclerViewAdapter;
import com.lyw.exercise.model.Level;

import java.util.ArrayList;

public class GroupRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Level> levels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initLevelData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new NormalRecyclerViewAdapter(this,levels));
    }

    private void initLevelData() {
        levels = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Level chapter = new Level(null, "chapter" + i, true);
            levels.add(chapter);
            for (int j = 0; j < 10; j++) {
                Level level = new Level("level" + j, null, false);
                levels.add(level);
            }
        }
    }
}
