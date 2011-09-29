package com.benjgorman.pharostest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.benjgorman.pharostest.stores.AddressStore;
import com.benjgorman.pharostest.stores.DetailsStore;
import com.benjgorman.pharostest.stores.OrderStore;
import com.benjgorman.pharostest.stores.ParcelStore;
import com.benjgorman.pharostest.stores.PaymentStore;
import com.benjgorman.pharostest.stores.RAddressStore;
import com.benjgorman.pharostest.stores.RDetailsStore;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "PharosParcelDB";

	private static final int DATABASE_VERSION = 10;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Method is called during creation of the database
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(ParcelStore.TABLE_CREATE);
		database.execSQL(AddressStore.TABLE_CREATE);
		database.execSQL(RAddressStore.TABLE_CREATE);
		database.execSQL(OrderStore.TABLE_CREATE);
		database.execSQL(DetailsStore.TABLE_CREATE);
		database.execSQL(RDetailsStore.TABLE_CREATE);
		database.execSQL(PaymentStore.TABLE_CREATE);
		
	}

	// Method is called during an upgrade of the database, e.g. if you increase
	// the database version
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		
		database.execSQL("DROP TABLE IF EXISTS " + ParcelStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + OrderStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + AddressStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + RAddressStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + DetailsStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + RDetailsStore.TABLE_NAME);
		database.execSQL("DROP TABLE IF EXISTS " + PaymentStore.TABLE_NAME);
		onCreate(database);
	}
	
}
