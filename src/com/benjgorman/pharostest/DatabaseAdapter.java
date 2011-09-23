package com.benjgorman.pharostest;

import java.util.ArrayList;
import java.util.List;

import com.benjgorman.pharostest.stores.OrderStore;

import android.content.ContentValues;
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
	private static final String DATABASE_TABLE = "todo";
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
	
	/**
	 * returns the parcel history as a list of parcel objects
	 * 
	 * @return
	 */
	public List<OrderStore> listOrderHistory() {
		
		Cursor cursor = this.getOrderCursor();
		List<OrderStore> list = new ArrayList<OrderStore>();

		// If a record exists
		if (cursor.moveToFirst()) {
			do {
				OrderStore order = new OrderStore(cursor.getColumnName(1), null, null, null);
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
	 * returns a cursor to navigate around the parcels data
	 * 
	 * @return
	 */
	public Cursor getOrderCursor() {
		return this.database.query(OrderStore.TABLE_NAME, new String[] { OrderStore.ID, OrderStore.TRACKING_NO }, null, null, null,
				null, OrderStore.ROW_CREATED_AT + " DESC");
	}
	

	/**
	 * Return a Cursor over the list of all todo in the database
	 * 
	 * @return Cursor over all notes
	 */
	public Cursor fetchAllTodos() {
		return database.query(DATABASE_TABLE, new String[] { KEY_ROWID,
				KEY_CATEGORY, KEY_SUMMARY, KEY_DESCRIPTION }, null, null, null,
				null, null);
	}

	/**
	 * Return a Cursor positioned at the defined todo
	 */
	public Cursor fetchTodo(long rowId) throws SQLException {
		Cursor mCursor = database.query(true, DATABASE_TABLE, new String[] {
				KEY_ROWID, KEY_CATEGORY, KEY_SUMMARY, KEY_DESCRIPTION },
				KEY_ROWID + "=" + rowId, null, null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

}

