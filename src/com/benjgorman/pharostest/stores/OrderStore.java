package com.benjgorman.pharostest.stores;

public class OrderStore {
	
	public static final String TABLE_NAME = "Orders";
	public static final String ID = "_id";
	public static final String ROW_CREATED_AT = "createdAt";
	public static final String TRACKING_NO = "trackingNo";
	public static final String PICKUP_ID = "pickupID";
	public static final String DELIVER_ID = "deliverID";
	public static final String RDETAIL_ID = "rdetailID";
	public static final String DETAIL_ID = "detailID";
	public static final String PARCEL_ID = "parcelID";
	public static final String TABLE_CREATE = "CREATE TABLE " + 
			TABLE_NAME + " (" + 
			ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + 
			TRACKING_NO + " TEXT, " +
			RDETAIL_ID + " INT, " +
			DETAIL_ID + " INT, " +
			PICKUP_ID + " INT, " + 
			DELIVER_ID + " INT, " + 
			PARCEL_ID + " INT, " + 
			ROW_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " + 
			"UNIQUE (" + TRACKING_NO + "))";
	
	private String trackingNo;
	private String pickupID;
	private String deliverID;
	private String rdetailID;
	private String detailID;
	private String parcelID;	
	
	public OrderStore(String trackingNo, String pickupID, String deliverID, String rdetailID, String detailID, String parcelID) {
		this.trackingNo = trackingNo;
		this.pickupID = pickupID;
		this.deliverID = deliverID;
		this.rdetailID = rdetailID;
		this.parcelID = parcelID;
		
	}
	
	public String getTrackingNo() {
		return trackingNo;
	}


	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}


	public String getPickupID() {
		return pickupID;
	}


	public void setPickupID(String pickupID) {
		this.pickupID = pickupID;
	}


	public String getDeliverID() {
		return deliverID;
	}


	public void setDeliverID(String deliverID) {
		this.deliverID = deliverID;
	}


	public String getRdetailID() {
		return rdetailID;
	}


	public void setRdetailID(String rdetailID) {
		this.rdetailID = rdetailID;
	}


	public String getDetailID() {
		return detailID;
	}


	public void setDetailID(String detailID) {
		this.detailID = detailID;
	}


	public String getParcelID() {
		return parcelID;
	}


	public void setParcelID(String parcelID) {
		this.parcelID = parcelID;
	}

	
}
