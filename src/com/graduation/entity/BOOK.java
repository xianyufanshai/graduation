package com.graduation.entity;

public class BOOK {
	private int BOOK_ID;
	private String BOOK_NAME;
	private String BOOK_DESCRIPTION;
	private int BOOK_FID;
	private int BOOK_CID;
	private String BOOK_FILENAME;
	private String BOOK_WRITER;
	private int BOOK_CHECK;
	public BOOK(int bOOK_ID, String bOOK_NAME, String bOOK_DESCRIPTION, int bOOK_FID, int bOOK_CID,
			String bOOK_FILENAME, String bOOK_WRITER, int bOOK_CHECK) {
		super();
		BOOK_ID = bOOK_ID;
		BOOK_NAME = bOOK_NAME;
		BOOK_DESCRIPTION = bOOK_DESCRIPTION;
		BOOK_FID = bOOK_FID;
		BOOK_CID = bOOK_CID;
		BOOK_FILENAME = bOOK_FILENAME;
		BOOK_WRITER = bOOK_WRITER;
		BOOK_CHECK = bOOK_CHECK;
	}
	public int getBOOK_ID() {
		return BOOK_ID;
	}
	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}
	public String getBOOK_NAME() {
		return BOOK_NAME;
	}
	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}
	public String getBOOK_DESCRIPTION() {
		return BOOK_DESCRIPTION;
	}
	public void setBOOK_DESCRIPTION(String bOOK_DESCRIPTION) {
		BOOK_DESCRIPTION = bOOK_DESCRIPTION;
	}
	public int getBOOK_FID() {
		return BOOK_FID;
	}
	public void setBOOK_FID(int bOOK_FID) {
		BOOK_FID = bOOK_FID;
	}
	public int getBOOK_CID() {
		return BOOK_CID;
	}
	public void setBOOK_CID(int bOOK_CID) {
		BOOK_CID = bOOK_CID;
	}
	public String getBOOK_FILENAME() {
		return BOOK_FILENAME;
	}
	public void setBOOK_FILENAME(String bOOK_FILENAME) {
		BOOK_FILENAME = bOOK_FILENAME;
	}
	public String getBOOK_WRITER() {
		return BOOK_WRITER;
	}
	public void setBOOK_WRITER(String bOOK_WRITER) {
		BOOK_WRITER = bOOK_WRITER;
	}
	public int getBOOK_CHECK() {
		return BOOK_CHECK;
	}
	public void setBOOK_CHECK(int bOOK_CHECK) {
		BOOK_CHECK = bOOK_CHECK;
	}
	
	

}
