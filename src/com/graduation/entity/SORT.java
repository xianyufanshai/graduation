package com.graduation.entity;

public class SORT {
	private int SORT_ID ;
	private String SORT_NAME ;
	private int SORT_PARENT_ID ;
	public SORT(int sORT_ID, String sORT_NAME, int sORT_PAERENT_ID) {
		super();
		SORT_ID = sORT_ID;
		SORT_NAME = sORT_NAME;
		SORT_PARENT_ID = sORT_PAERENT_ID;
	}
	public int getSORT_ID() {
		return SORT_ID;
	}
	public void setSORT_ID(int sORT_ID) {
		SORT_ID = sORT_ID;
	}
	public String getSORT_NAME() {
		return SORT_NAME;
	}
	public void setSORT_NAME(String sORT_NAME) {
		SORT_NAME = sORT_NAME;
	}
	public int getSORT_PARENT_ID() {
		return SORT_PARENT_ID;
	}
	public void setSORT_PARENT_ID(int sORT_PARENT_ID) {
		SORT_PARENT_ID = sORT_PARENT_ID;
	}
	
	
}
