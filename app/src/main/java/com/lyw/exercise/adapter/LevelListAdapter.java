package com.lyw.exercise.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lyw.exercise.R;
import com.lyw.exercise.model.Level;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelListAdapter extends BaseAdapter {
	private LinkedList<Level> levelList;
	private ArrayList<Level> chapterlist;
	private LayoutInflater inflater;


	public LevelListAdapter(LinkedList<Level> levelList, Context context) {
		this.levelList = levelList;
		chapterlist = new ArrayList<>();
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		for (int i = 0; i < levelList.size(); i++) {
//			Level level = levelList.get(i);
//			Level levelChpter;
//			if (!chapterlist.contains(level)) {
//				chapterlist.add(level);
//				levelChpter = level;
//				levelChpter.setLevel(level.getChapter());
//				levelChpter.setIsChapter(true);
//				levelList.add(i, levelChpter);
//			}
//		}
	}

	@Override
	public int getCount() {
		return levelList.size() + chapterlist.size();
	}

	@Override
	public Object getItem(int position) {
		return levelList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		Level info = levelList.get(position);
		if (convertView == null) {
			holder = new Holder();
			convertView = inflater.inflate(R.layout.item_level, parent, false);
			holder.textView = (TextView) convertView.findViewById(R.id.level_name);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.textView.setText(info.getLevel());
//		holder.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		if (info.isChapter()) {
			holder.textView.setTextColor(Color.WHITE);
			holder.textView.setBackgroundColor(Color.BLACK);
		} else {
			holder.textView.setTextColor(Color.BLACK);
			holder.textView.setBackgroundColor(Color.WHITE);
		}
		return convertView;
	}

	static class Holder {
		TextView textView;
	}
}
