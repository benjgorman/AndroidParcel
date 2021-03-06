package com.benjgorman.pharostest;

import java.util.ArrayList;
import java.util.List;

import com.benjgorman.pharostest.stores.AddressStore;
import com.benjgorman.pharostest.stores.DetailsStore;
import com.benjgorman.pharostest.stores.OrderStore;
import com.benjgorman.pharostest.stores.PaymentStore;
import com.benjgorman.pharostest.stores.RAddressStore;
import com.benjgorman.pharostest.stores.RDetailsStore;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class DatabaseAdapter {

	// Database fields
	private static final String TAG = "Halp";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_CATEGORY = "category";
	public static final String KEY_SUMMARY = "summary";
	public static final String KEY_DESCRIPTION = "description";
	private Context context;
	private SQLiteDatabase database;
	private DatabaseHelper dbHelper;

	public DatabaseAdapter(Context context) {
		this.context = context;
		
		DatabaseHelper dbHelper = new DatabaseHelper(this.context);
		
		this.database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	/**
	 * Adds an details to the database. If it already exists it returns the ID of the one found.
	 * @param rdetails
	 * @return rdetailsID
	 */
	public String insertRDetails(RDetailsStore details) {
		String detailsID = null;

		Cursor cursor = this.database.query(RDetailsStore.TABLE_NAME, 
				new String[] {RDetailsStore.ID}, 
				RDetailsStore.SURNAME + " = '" + details.getSurname() + "' AND " + 
				RDetailsStore.PHONE + " = '" + details.getPhone() + "'",
				null, null, null, null);

		if (cursor.getCount() > 0 && cursor.moveToFirst()) {
			// Address found
			detailsID = cursor.getString(0);
		} else {
			// Address not found, add the address
			String insert = "INSERT INTO " +
					RDetailsStore.TABLE_NAME + " (" + 
					RDetailsStore.TITLE + ", " +
					RDetailsStore.FORENAME + ", " +
					RDetailsStore.SURNAME + ", " +
					RDetailsStore.PHONE +
				") values (?, ?, ?, ?)";

			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			insertStatement.bindString(1, details.getTitle());
			insertStatement.bindString(2, details.getForename());
			insertStatement.bindString(3, details.getSurname());
			insertStatement.bindString(4, details.getPhone());

			Long result = insertStatement.executeInsert();
			detailsID = result.toString();
		}

		return detailsID;
	}
	
	/**
	 * Adds an payment to the database. If it already exists it returns the ID of the one found.
	 * @param payment
	 * @return paymentID
	 */
	public String insertPayment(PaymentStore payment) {
		String paymentID = null;

		Cursor cursor = this.database.query(PaymentStore.TABLE_NAME, 
				new String[] {PaymentStore.ID}, 
				PaymentStore.NUMBER + " = '" + payment.getNumber() + "' AND " + 
				PaymentStore.NAME + " = '" + payment.getName() + "'",
				null, null, null, null);

		if (cursor.getCount() > 0 && cursor.moveToFirst()) {
			// Address found
			paymentID = cursor.getString(0);
		} else {
			// Address not found, add the address
			String insert = "INSERT INTO " +
					PaymentStore.TABLE_NAME + " (" + 
					PaymentStore.TYPE + ", " +
					PaymentStore.NAME + ", " +
					PaymentStore.NUMBER +
				") values (?, ?, ?)";

			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			insertStatement.bindString(1, payment.getType());
			insertStatement.bindString(2, payment.getName());
			insertStatement.bindString(3, payment.getNumber());

			Long result = insertStatement.executeInsert();
			paymentID = result.toString();
		}

		return paymentID;
	}
	
	/**
	 * Adds details to the database. If it already exists it returns the ID of the one found.
	 * @param details
	 * @return detailsID
	 */
	public String insertDetails(DetailsStore details) {
		String detailsID = null;

		Cursor cursor = this.database.query(DetailsStore.TABLE_NAME, 
				new String[] {DetailsStore.ID}, 
				DetailsStore.SURNAME + " = '" + details.getSurname() + "' AND " + 
				DetailsStore.PHONE + " = '" + details.getPhone() + "'",
				null, null, null, null);

		if (cursor.getCount() > 0 && cursor.moveToFirst()) {
			// Address found
			detailsID = cursor.getString(0);
		} else {
			// Address not found, add the address
			String insert = "INSERT INTO " +
					DetailsStore.TABLE_NAME + " (" + 
					DetailsStore.TITLE + ", " +
					DetailsStore.FORENAME + ", " +
					DetailsStore.SURNAME + ", " +
					DetailsStore.PHONE + ", " +
					DetailsStore.EMAIL +
				") values (?, ?, ?, ?, ?)";

			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			insertStatement.bindString(1, details.getTitle());
			insertStatement.bindString(2, details.getForename());
			insertStatement.bindString(3, details.getSurname());
			insertStatement.bindString(4, details.getPhone());
			insertStatement.bindString(5, details.getEmail());

			Long result = insertStatement.executeInsert();
			detailsID = result.toString();
		}

		return detailsID;
	}
	
	/**
	 * Adds an raddress to the database. If it already exists it returns the ID of the one found.
	 * @param raddress
	 * @return raddressID
	 */
	public String insertRAddress(RAddressStore address) {
		String addressID = null;

		Cursor cursor = this.database.query(RAddressStore.TABLE_NAME, 
				new String[] {RAddressStore.ID}, 
				RAddressStore.LINE1 + " = '" + address.getLine1() + "' AND " + 
				RAddressStore.POSTCODE + " = '" + address.getPostcode() + "'",
				null, null, null, null);

		if (cursor.getCount() > 0 && cursor.moveToFirst()) {
			// Address found
			addressID = cursor.getString(0);
		} else {
			// Address not found, add the address
			String insert = "INSERT INTO " +
					RAddressStore.TABLE_NAME + " (" + 
					RAddressStore.LINE1 + ", " +
					RAddressStore.LINE2 + ", " +
					RAddressStore.LINE3 + ", " +
					RAddressStore.CITY + ", " +
					RAddressStore.COUNTRY + ", " +
					RAddressStore.REGION + ", " +
					RAddressStore.POSTCODE +
				") values (?, ?, ?, ?, ?, ?, ?)";

			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			insertStatement.bindString(1, address.getLine1());
			insertStatement.bindString(2, address.getLine2());
			insertStatement.bindString(3, address.getLine3());
			insertStatement.bindString(4, address.getCity());
			insertStatement.bindString(5, address.getCountry());
			insertStatement.bindString(6, address.getPostcode());
			insertStatement.bindString(7, address.getPostcode());

			Long result = insertStatement.executeInsert();
			addressID = result.toString();
		}

		return addressID;
	}
	
	/**
	 * Adds an address to the database. If it already exists it returns the ID of the one found.
	 * @param address
	 * @return addressID
	 */
	public String insertAddress(AddressStore address) {
		String addressID = null;

		Cursor cursor = this.database.query(AddressStore.TABLE_NAME, 
				new String[] {AddressStore.ID}, 
				AddressStore.LINE1 + " = '" + address.getLine1() + "' AND " + 
				AddressStore.POSTCODE + " = '" + address.getPostcode() + "'",
				null, null, null, null);

		if (cursor.getCount() > 0 && cursor.moveToFirst()) {
			// Address found
			addressID = cursor.getString(0);
		} else {
			// Address not found, add the address
			String insert = "INSERT INTO " +
					AddressStore.TABLE_NAME + " (" + 
					AddressStore.LINE1 + ", " +
					AddressStore.LINE2 + ", " +
					AddressStore.LINE3 + ", " +
					AddressStore.CITY + ", " +
					AddressStore.COUNTRY + ", " +
					AddressStore.REGION + ", " +
					AddressStore.POSTCODE +
				") values (?, ?, ?, ?, ?, ?, ?)";

			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			insertStatement.bindString(1, address.getLine1());
			insertStatement.bindString(2, address.getLine2());
			insertStatement.bindString(3, address.getLine3());
			insertStatement.bindString(4, address.getCity());
			insertStatement.bindString(5, address.getCountry());
			insertStatement.bindString(6, address.getPostcode());
			insertStatement.bindString(7, address.getPostcode());

			Long result = insertStatement.executeInsert();
			addressID = result.toString();
		}

		return addressID;
	}

	
	public long insertOrder(String trackingNo) {
		
		long result = 0;
		Log.d(TAG, "Inserting parcel number to the database");

		//check if order has been tracked before
		Cursor cursor = this.database.query(OrderStore.TABLE_NAME, new String[] { OrderStore.TRACKING_NO },
						OrderStore.TRACKING_NO + " = '" + trackingNo + "'", null, null, null, null);
		
		//if an order has been tracked before
		if (!cursor.moveToFirst()) {
			
			String insert = "INSERT INTO " + OrderStore.TABLE_NAME + " (" + OrderStore.TRACKING_NO + ") values (?)";
			
			SQLiteStatement insertStatement = this.database.compileStatement(insert);
			
			insertStatement.bindString(1, trackingNo);
			
			result = insertStatement.executeInsert();
			
			Log.d(TAG, "Inserted - Database returned " + result);
		
		}
		else 
		{
			//order exists already, no need to do anything else
			Log.d(TAG, "That parcel number already exists in the database");
		}

		/* Close the cursor */
		if (cursor != null && !cursor.isClosed()) 
		{
			cursor.close();
		}

		return result;
	}
	
	
	
	public List<OrderStore> listOrderHistory() {
		
		Cursor cursor = this.getOrderCursor();
		List<OrderStore> list = new ArrayList<OrderStore>();

		// If a record exists
		if (cursor.moveToFirst()) {
			do {
				OrderStore order = new OrderStore(cursor.getColumnName(1), null, null, null, null, null);
				list.add(order);
			} while (cursor.moveToNext());
		}

		// Close the cursor
		if (cursor != null && !cursor.isClosed()) {
			cursor.close();
		}

		return list;
	}
	
	/**
	 * returns a cursor to navigate around the order data
	 * 
	 * @return
	 */
	public Cursor getOrderCursor() {
		return this.database.query(OrderStore.TABLE_NAME, new String[] { OrderStore.ID, OrderStore.TRACKING_NO }, null, null, null,
				null, OrderStore.ROW_CREATED_AT + " DESC");
	}
	
	/**
	 * returns a cursor to navigate around the address data
	 * 
	 * @return
	 */
	public Cursor getAddressCursor() {
		return this.database.query(AddressStore.TABLE_NAME, new String[] { AddressStore.ID, AddressStore.LINE1, AddressStore.LINE2, AddressStore.CITY, AddressStore.POSTCODE }, null, null, null,
				null, AddressStore.ROW_CREATED_AT + " DESC");
	}
	
	/**
	 * returns a cursor to navigate around the raddress data
	 * 
	 * @return
	 */
	public Cursor getRAddressCursor() {
		return this.database.query(RAddressStore.TABLE_NAME, new String[] { RAddressStore.ID, RAddressStore.LINE1, AddressStore.LINE2, RAddressStore.CITY, RAddressStore.POSTCODE }, null, null, null,
				null, RAddressStore.ROW_CREATED_AT + " DESC");
	}
	
	/**
	 * returns a cursor to navigate around the details data
	 * 
	 * @return
	 */
	public Cursor getRDetailsCursor() {
		return this.database.query(RDetailsStore.TABLE_NAME, new String[] { RDetailsStore.ID, RDetailsStore.TITLE, RDetailsStore.FORENAME, RDetailsStore.SURNAME, RDetailsStore.PHONE }, null, null, null,
				null, RDetailsStore.ROW_CREATED_AT + " DESC");
	}
	
	/**
	 * returns a cursor to navigate around the details data
	 * 
	 * @return
	 */
	public Cursor getPaymentCursor() {
		return this.database.query(PaymentStore.TABLE_NAME, new String[] { PaymentStore.ID, PaymentStore.NUMBER, PaymentStore.TYPE, PaymentStore.NAME}, null, null, null,
				null, PaymentStore.ROW_CREATED_AT + " DESC");
	}
	
	/**
	 * returns a cursor to navigate around the details data
	 * 
	 * @return
	 */
	public Cursor getDetailsCursor() {
		return this.database.query(DetailsStore.TABLE_NAME, new String[] { DetailsStore.ID, DetailsStore.TITLE, DetailsStore.FORENAME, DetailsStore.SURNAME, DetailsStore.PHONE, DetailsStore.EMAIL }, null, null, null,
				null, DetailsStore.ROW_CREATED_AT + " DESC");
	}
	

}

