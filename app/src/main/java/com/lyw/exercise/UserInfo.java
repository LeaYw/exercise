package com.lyw.exercise;

public class UserInfo {
	private static UserInfo ourInstance = new UserInfo();

	public static UserInfo getInstance() {
		return ourInstance;
	}

	private UserInfo() {
	}
}
