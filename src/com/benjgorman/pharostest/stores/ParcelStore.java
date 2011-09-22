package com.benjgorman.pharostest.stores;

public class ParcelStore {

	public static final String TABLE_NAME = "Parcel";
	public static final String ID = "_id";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String PARCEL_ID = "parcelNO";
	public static final String ORDER_NO = "orderNo";
	public static final String WEIGHT = "weight";
	public static final String HEIGHT = "height";
	public static final String WIDTH = "width";
	public static final String TABLE_CREATE = "CREATE TABLE " + 
			TABLE_NAME + " (" + 
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			HEIGHT + " INT, " +
			WIDTH	+ " TEXT, " + 
			WEIGHT + " INT, " + 
			ORDER_NO + " INT, " + 
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " ;
	
	private Integer width;
	private Integer height;
	private Integer weight;
	private Integer orderNo;
	
	public ParcelStore(Integer width, Integer height, Integer orderNo, Integer weight) {
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.orderNo = orderNo;
		
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
