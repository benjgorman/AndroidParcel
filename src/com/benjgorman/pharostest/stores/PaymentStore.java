package com.benjgorman.pharostest.stores;

public class PaymentStore {

	public static final String TABLE_NAME = "Payment";
	public static final String ID = "_id";
	public static final String NUMBER = "number";
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String TABLE_CREATE = "CREATE TABLE " +
			TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			NUMBER + " TEXT, " +
			NAME + " TEXT, " +
			TYPE + " TEXT, " +
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
	
	private String number;
	private String name;
	private String type;
	

	public PaymentStore(String number, String name, String type) {
		this.setNumber(number);
		this.setName(name);
		this.setType(type);
	
		
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
