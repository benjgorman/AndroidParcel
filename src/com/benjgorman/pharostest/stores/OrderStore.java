package com.benjgorman.pharostest.stores;

public class OrderStore {
	
	public static final String TABLE_NAME = "Order";
	public static final String ID = "_id";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String TRACKING_NO = "trackingNo";
	public static final String DELIVER_ID = "deliver";
	public static final String PICKUP_ID = "pickup";
	public static final String TABLE_CREATE = "CREATE TABLE " + 
			TABLE_NAME + " (" + 
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			TRACKING_NO	+ " TEXT, " + 
			PICKUP_ID + " INT, " + 
			DELIVER_ID + " INT, " + 
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " + 
			"UNIQUE (" + TRACKING_NO + "))";

	private String trackingNo;
	private String orderNo;
	private AddressStore pickup;
	private AddressStore deliver;
	private ParcelStore parcel;
	
	public OrderStore(String trackingNo, String orderNo, AddressStore pickup,
			AddressStore deliver, ParcelStore parcel) {
		this.trackingNo = trackingNo;
		this.orderNo = orderNo;
		this.pickup = pickup;
		this.deliver = deliver;
		this.parcel = parcel;
	}
	
	
	public ParcelStore getParcel() {
		return parcel;
	}
	public void setParcel(ParcelStore parcel) {
		this.parcel = parcel;
	}
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public AddressStore getPickup() {
		return pickup;
	}
	public void setPickup(AddressStore pickup) {
		this.pickup = pickup;
	}
	public AddressStore getDeliver() {
		return deliver;
	}
	public void setDeliver(AddressStore deliver) {
		this.deliver = deliver;
	}
	
}
