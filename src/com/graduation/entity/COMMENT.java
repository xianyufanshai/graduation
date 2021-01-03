package com.graduation.entity;



public class COMMENT {
	private int COMMENT_ID;
	private String COMMENT_CONTENT;
	private int COM_BID;
	private String COM_UID;
	private String COM_DATE;
	private int COM_CHECK;
	public COMMENT(int cOMMENT_ID, String cOMMENT_CONTENT, int cOM_BID, String cOM_UID, String cOM_DATE, int cOM_CHECK) {
		super();
		COMMENT_ID = cOMMENT_ID;
		COMMENT_CONTENT = cOMMENT_CONTENT;
		COM_BID = cOM_BID;
		COM_UID = cOM_UID;
		COM_DATE = cOM_DATE;
		COM_CHECK = cOM_CHECK;
	}
	public int getCOMMENT_ID() {
		return COMMENT_ID;
	}
	public void setCOMMENT_ID(int cOMMENT_ID) {
		COMMENT_ID = cOMMENT_ID;
	}
	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}
	public void setCOMMENT_CONTENT(String cOMMENT_CONTENT) {
		COMMENT_CONTENT = cOMMENT_CONTENT;
	}
	public int getCOM_BID() {
		return COM_BID;
	}
	public void setCOM_BID(int cOM_BID) {
		COM_BID = cOM_BID;
	}
	public String getCOM_UID() {
		return COM_UID;
	}
	public void setCOM_UID(String cOM_UID) {
		COM_UID = cOM_UID;
	}
	public String getCOM_DATE() {
		return COM_DATE;
	}
	public void setCOM_DATE(String cOM_DATE) {
		COM_DATE = cOM_DATE;
	}
	public int getCOM_CHECK() {
		return COM_CHECK;
	}
	public void setCOM_CHECK(int cOM_CHECK) {
		COM_CHECK = cOM_CHECK;
	}
	
    
}
