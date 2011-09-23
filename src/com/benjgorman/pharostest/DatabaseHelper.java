package com.benjgorman.pharostest;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.benjgorman.pharostest.stores.AddressStore;
import com.benjgorman.pharostest.stores.OrderStore;
import com.benjgorman.pharostest.stores.ParcelStore;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "PharosParcelDB";

	private static final int DATABASE_VERSION = 2;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(ParcelStore.TABLE_CREATE);
		database.execSQL(AddressStore.TABLE_CREATE);
		database.execSQL(OrderStore.TABLE_CREATE);
		
	}

	// Method is called during an upgrade of the database, e.g. if you increase
	// the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		
		database.execSQL("DROP TABLE IF EXISTS parcel");
		database.execSQL("DROP TABLE IF EXISTS order");
		database.execSQL("DROP TABLE IF EXISTS address");
		onCreate(database);
	}
	
}
