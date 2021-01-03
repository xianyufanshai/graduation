package com.graduation.entity;

public class INFORM {
	private int INFORM_ID;
	private String I_NAME;
	private String I_CONTENT;
	private String I_DATE;
	private String I_UID;
	public INFORM(int iNFORM_ID, String i_NAME, String i_CONTENT, String i_DATE, String i_UID) {
		super();
		INFORM_ID = iNFORM_ID;
		I_NAME = i_NAME;
		I_CONTENT = i_CONTENT;
		I_DATE = i_DATE;
		I_UID = i_UID;
	}
	public int getINFORM_ID() {
		return INFORM_ID;
	}
	public void setINFORM_ID(int iNFORM_ID) {
		INFORM_ID = iNFORM_ID;
	}
	public String getI_NAME() {
		return I_NAME;
	}
	public void setI_NAME(String i_NAME) {
		I_NAME = i_NAME;
	}
	public String getI_CONTENT() {
		return I_CONTENT;
	}
	public void setI_CONTENT(String i_CONTENT) {
		I_CONTENT = i_CONTENT;
	}
	public String getI_DATE() {
		return I_DATE;
	}
	public void setI_DATE(String i_DATE) {
		I_DATE = i_DATE;
	}
	public String getI_UID() {
		return I_UID;
	}
	public void setI_UID(String i_UID) {
		I_UID = i_UID;
	}
	
	

}
