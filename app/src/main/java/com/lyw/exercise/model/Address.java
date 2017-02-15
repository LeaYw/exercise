package com.lyw.exercise.model;

public class Address {

	public static final int POSITION_ID = 0;
	public static final int POSITION_NAME = 1;
	public static final int POSITION_PID = 2;
	public static final String FILE_PROVINCE = "provinces.xml";
	public static final String FILE_CITY = "cities.xml";
	public static final String FILE_TOWN = "districts.xml";
	public static final String LABEL_NAME = "Address";

	private int id;
	private String name;
	private int pId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}


}
