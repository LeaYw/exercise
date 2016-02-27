package com.lyw.exercise.model;


public class Level {
	private String chapter;
	private String level;
	private boolean isChapter;

	public boolean isChapter() {
		return isChapter;
	}

	public void setIsChapter(boolean isChapter) {
		this.isChapter = isChapter;
	}

	public Level() {
	}

	public Level(String level, String chapter, boolean isChapter) {
		this.isChapter = isChapter;
		this.chapter = chapter;
		this.level = level;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
