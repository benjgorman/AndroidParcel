package com.benjgorman.pharostest.stores;

public class AddressStore {
	
	public static final String TABLE_NAME = "Address";
	public static final String ID = "_id";
	public static final String LINE1 = "line1";
	public static final String LINE2 = "line2";
	public static final String LINE3 = "line3";
	public static final String CITY = "city";
	public static final String REGION = "region";
	public static final String COUNTRY = "country";
	public static final String POSTCODE = "postcode";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String TABLE_CREATE = "CREATE TABLE " +
			TABLE_NAME + " (" +
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			LINE1 + " TEXT, " +
			LINE2 + " TEXT, " +
			LINE3 + " TEXT, " +
			CITY + " TEXT, " +
			REGION + " TEXT, " +
			COUNTRY + " TEXT, " +
			POSTCODE + " TEXT, " +
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
	
	private String line1;
	private String line2;
	private String line3;
	private String region;
	private String city;
	private String country;
	private String postcode;
	
		
	
	public AddressStore(String line1, String line2, String line3,
			String region, String city, String country, String postcode) {
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.region = region;
		this.city = city;
		this.country = country;
		this.postcode = postcode;
	}
	

	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	

}
