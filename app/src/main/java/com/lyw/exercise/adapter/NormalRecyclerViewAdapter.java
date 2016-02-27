package com.lyw.exercise.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lyw.exercise.R;
import com.lyw.exercise.model.Level;

import java.util.ArrayList;

public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater layoutInflater;
    private Context context;
    private String[] titles;
    private ArrayList<Level> levels;

    private static enum DATA_TYPE {TYPE_LEVEL, TYPE_CHAPTER}

    public NormalRecyclerViewAdapter(Context context, ArrayList<Level> levels) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        titles = context.getResources().getStringArray(R.array.titles);
        this.levels = levels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == DATA_TYPE.TYPE_CHAPTER.ordinal()) {
            return new ChapterHolder(layoutInflater.inflate(R.layout.item_chapter, parent, false));
        } else {
            return new LevelHolder(layoutInflater.inflate(R.layout.item_level, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Level level = levels.get(position);
        if (holder instanceof ChapterHolder){
            ((ChapterHolder) holder).chapter.setText(level.getChapter());
        } else if (holder instanceof LevelHolder){
            ((LevelHolder) holder).level.setText(level.getLevel());
        }
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (levels.get(position).isChapter()) {
            return DATA_TYPE.TYPE_CHAPTER.ordinal();
        } else {
            return DATA_TYPE.TYPE_LEVEL.ordinal();
        }
    }

    public static class LevelHolder extends RecyclerView.ViewHolder {
        TextView level;

        public LevelHolder(View itemView) {
            super(itemView);
            level = (TextView) itemView.findViewById(R.id.level_name);
        }
    }

    public static class ChapterHolder extends RecyclerView.ViewHolder {
        TextView chapter;

        public ChapterHolder(View itemView) {
            super(itemView);
            chapter = (TextView) itemView.findViewById(R.id.chapter_name);
        }
    }
}
