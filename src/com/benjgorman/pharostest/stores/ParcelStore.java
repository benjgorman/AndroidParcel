package com.benjgorman.pharostest.stores;

public class ParcelStore {

	public static final String TABLE_NAME = "Parcel";
	public static final String ID = "_id";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String WEIGHT = "weight";
	public static final String LENGTH = "length";
	public static final String WIDTH = "width";
	public static final String HEIGHT = "height";
	public static final String TABLE_CREATE = "CREATE TABLE " + 
			TABLE_NAME + " (" + 
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  
			LENGTH + " INT, " +
			WEIGHT	+ " DOUBLE, " + 
			WIDTH + " INT, " + 
			HEIGHT + " INT, " + 
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
	
	private Integer width;
	private Integer height;
	private Integer weight;
	private Integer orderNo;
	private Integer length;
	
	public ParcelStore(Integer width, Integer height, Integer orderNo, Integer weight, Integer length) {
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.length = length;
		this.orderNo = orderNo;
		
	}
	
	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getLength() {
		return length;
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
