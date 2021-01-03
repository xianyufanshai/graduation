package com.graduation.entity;

public class SHELF {
	private int SHELF_ID;
	private String S_BFILENAME;
	private String S_BWRITER;
	
	private String S_BNAME;
	private int S_BID;
	private String S_UID;
	public SHELF(int sHELF_ID, String s_BFILENAME, String s_BWRITER, String s_BNAME, int s_BID, String s_UID) {
		super();
		SHELF_ID = sHELF_ID;
		S_BFILENAME = s_BFILENAME;
		S_BWRITER = s_BWRITER;
		S_BNAME = s_BNAME;
		S_BID = s_BID;
		S_UID = s_UID;
	}
	public int getSHELF_ID() {
		return SHELF_ID;
	}
	public void setSHELF_ID(int sHELF_ID) {
		SHELF_ID = sHELF_ID;
	}
	public String getS_BFILENAME() {
		return S_BFILENAME;
	}
	public void setS_BFILENAME(String s_BFILENAME) {
		S_BFILENAME = s_BFILENAME;
	}
	public String getS_BWRITER() {
		return S_BWRITER;
	}
	public void setS_BWRITER(String s_BWRITER) {
		S_BWRITER = s_BWRITER;
	}
	public String getS_BNAME() {
		return S_BNAME;
	}
	public void setS_BNAME(String s_BNAME) {
		S_BNAME = s_BNAME;
	}
	public int getS_BID() {
		return S_BID;
	}
	public void setS_BID(int s_BID) {
		S_BID = s_BID;
	}
	public String getS_UID() {
		return S_UID;
	}
	public void setS_UID(String s_UID) {
		S_UID = s_UID;
	}
	
	

}
