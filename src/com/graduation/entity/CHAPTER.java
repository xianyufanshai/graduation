package com.graduation.entity;

public class CHAPTER {
	private int CHAPTER_ID;
	private String CHAPTER_NAME;
	private String C_FILENAME;
	private String C_BNAME;
	private int C_BID;
	public CHAPTER(int cHAPTER_ID, String cHAPTER_NAME, String c_FILENAME, String c_BNAME, int c_BID) {
		super();
		CHAPTER_ID = cHAPTER_ID;
		CHAPTER_NAME = cHAPTER_NAME;
		C_FILENAME = c_FILENAME;
		C_BNAME = c_BNAME;
		C_BID = c_BID;
	}
	public int getCHAPTER_ID() {
		return CHAPTER_ID;
	}
	public void setCHAPTER_ID(int cHAPTER_ID) {
		CHAPTER_ID = cHAPTER_ID;
	}
	public String getCHAPTER_NAME() {
		return CHAPTER_NAME;
	}
	public void setCHAPTER_NAME(String cHAPTER_NAME) {
		CHAPTER_NAME = cHAPTER_NAME;
	}
	public String getC_FILENAME() {
		return C_FILENAME;
	}
	public void setC_FILENAME(String c_FILENAME) {
		C_FILENAME = c_FILENAME;
	}
	public String getC_BNAME() {
		return C_BNAME;
	}
	public void setC_BNAME(String c_BNAME) {
		C_BNAME = c_BNAME;
	}
	public int getC_BID() {
		return C_BID;
	}
	public void setC_BID(int c_BID) {
		C_BID = c_BID;
	}
	
	
	
	
	
}
