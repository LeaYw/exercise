package com.lyw.exercise.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.lyw.exercise.R;
import com.lyw.exercise.adapter.LevelListAdapter;
import com.lyw.exercise.model.Level;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelFragment extends Fragment {
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	private String mParam1;
	private String mParam2;
	private LinkedList<Level> levelLinkedList;

	public static LevelFragment newInstance(String param1, String param2) {
		LevelFragment fragment = new LevelFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	public LevelFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
		initLevelList();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_level, container, false);
		final TextView textView = (TextView) view.findViewById(R.id.level_text);
		textView.setText(levelLinkedList.get(0).getChapter());
		ListView lv = (ListView) view.findViewById(R.id.lever_listview);
		lv.setAdapter(new LevelListAdapter(levelLinkedList, getActivity()));
		lv.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if (!textView.getText().toString().equals(levelLinkedList.get(firstVisibleItem).getChapter())) {
					textView.setText(levelLinkedList.get(firstVisibleItem).getChapter());
				}
			}
		});

		return view;
	}

	private void initLevelList() {
		levelLinkedList = new LinkedList<>();
		ArrayList<String> chapterlist = new ArrayList<>();
		Level level;
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 4; i++) {
				level = new Level(j + "item" + i, j + "", false);
				levelLinkedList.add(level);
			}
		}
		for (int i = 0; i < levelLinkedList.size(); i++) {
			level = levelLinkedList.get(i);
			if (!chapterlist.contains(level.getChapter())) {
				chapterlist.add(level.getChapter());
				levelLinkedList.add(i, new Level(level.getLevel(), level.getChapter(), true));
			}
		}
	}


}
