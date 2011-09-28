package com.benjgorman.pharostest.stores;

public class RDetailsStore {
	
	public static final String TABLE_NAME = "RDetails";
	public static final String ID = "_id";
	public static final String TITLE = "title";
	public static final String FORENAME = "forename";
	public static final String SURNAME = "surname";
	public static final String PHONE = "phone";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String TABLE_CREATE = "CREATE TABLE " +
			TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			TITLE + " TEXT, " +
			FORENAME + " TEXT, " +
			SURNAME + " TEXT, " +
			PHONE + " TEXT, " +
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
	
	private String title;
	private String forename;
	private String surname;
	private String phone;

	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public String getForename() {
		return forename;
	}



	public void setForename(String forename) {
		this.forename = forename;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}


	public RDetailsStore(String title, String forename, String surname, String phone) {
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.phone = phone;
		
	}

}
