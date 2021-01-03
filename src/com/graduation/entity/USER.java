package com.graduation.entity;

public class USER {

			private String USER_ID;
			private String USER_NAME;
			private String PWD;
			private String SEX;
			private String EMAIL;
			private int STATUS;
			public USER(String uSER_ID, String uSER_NAME, String pWD, String sEX, String eMAIL, int sTATUS) {
				super();
				USER_ID = uSER_ID;
				USER_NAME = uSER_NAME;
				PWD = pWD;
				SEX = sEX;
				EMAIL = eMAIL;
				STATUS = sTATUS;
			}
			public String getUSER_ID() {
				return USER_ID;
			}
			public void setUSER_ID(String uSER_ID) {
				USER_ID = uSER_ID;
			}
			public String getUSER_NAME() {
				return USER_NAME;
			}
			public void setUSER_NAME(String uSER_NAME) {
				USER_NAME = uSER_NAME;
			}
			public String getPWD() {
				return PWD;
			}
			public void setPWD(String pWD) {
				PWD = pWD;
			}
			public String getSEX() {
				return SEX;
			}
			public void setSEX(String sEX) {
				SEX = sEX;
			}
			public String getEMAIL() {
				return EMAIL;
			}
			public void setEMAIL(String eMAIL) {
				EMAIL = eMAIL;
			}
			public int getSTATUS() {
				return STATUS;
			}
			public void setSTATUS(int sTATUS) {
				STATUS = sTATUS;
			}
			
			
			
				
			
			
}