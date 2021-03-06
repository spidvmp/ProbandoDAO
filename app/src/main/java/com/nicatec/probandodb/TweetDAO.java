package com.nicatec.probandodb;

import android.content.ContentValues;
import android.content.Context;

import java.lang.ref.WeakReference;

public class TweetDAO {

	/*
	public static final String TABLE_RADAR = "RADAR";

	// Table field constants 
	public static final String KEY_RADAR_ID = "_id";
	public static final String KEY_RADAR_TITLE = "name";
	public static final String KEY_RADAR_DESCRIPTION = "description";

	public static final String SQL_CREATE_RADAR_TABLE =
			"create table " + TABLE_RADAR
					+ "( " + KEY_RADAR_ID
					+ " integer primary key autoincrement, "
					+ KEY_RADAR_TITLE + " text not null,"
					+ KEY_RADAR_DESCRIPTION + " text not null"
					+ ");";


	public static final String[] allColumns = {
			KEY_RADAR_ID,
			KEY_RADAR_TITLE,
			KEY_RADAR_DESCRIPTION
	};
	*/

	protected DBHelper db;

	private static final long INVALID_ID_DELETE_ALL_RECORDS = 0;
	private String databaseName;

	private WeakReference<Context> context;
	// private Context context;

	public TweetDAO() {
		db = DBHelper.getInstance();
	}

	public TweetDAO(String databaseName, Context context) {
		this.context = new WeakReference<Context>(context);
		this.databaseName = databaseName;
	}

	public long insert(TweetMessage message) {
		if (message == null) {
			throw new IllegalArgumentException("Passing NULL message, imbecile");
		}

		if (context.get() == null) {
			throw new IllegalStateException("Context NULL");
		}

		// insert
		//DBHelper db = DBHelper.getInstance(this.databaseName, context.get());

		long id = db.getWritableDatabase().insert(DBConstants.TABLE_TWEETS, null, this.getContentValues(message));
		message.setId(id);
		db.close();

		return id;
	}



	/*

	public int update(long id, Radar message) {
		if (message == null) {
			throw new IllegalArgumentException("Passing NULL message, imbecile");
		}
		if (context.get() == null) {
			throw new IllegalStateException("Context NULL");
		}

		DBHelper db = DBHelper.getInstance(this.databaseName, context.get());

		//db.getWritableDatabase().update(TABLE_RADAR, this.getContentValues(message), KEY_RADAR_ID + "=" + id, null);
		int numberOfRowsUpdated = db.getWritableDatabase().update(TABLE_RADAR, this.getContentValues(message), KEY_RADAR_ID + "=?", new String[]{"" + id});

		db.close();
		db=null;
		return numberOfRowsUpdated;
	}

	public void delete(long id) {
		DBHelper db = DBHelper.getInstance(this.databaseName, context.get());

		if (id == INVALID_ID_DELETE_ALL_RECORDS) {
			db.getWritableDatabase().delete(TABLE_RADAR,  null, null);
		} else {
			db.getWritableDatabase().delete(TABLE_RADAR, KEY_RADAR_ID + " = " + id, null);
		}
		db.close();
		db=null;
	}

	public void deleteAll() {
		delete(INVALID_ID_DELETE_ALL_RECORDS);
	}
*/
	public static ContentValues getContentValues(TweetMessage message) {
		ContentValues content = new ContentValues();
		content.put(DBConstants.KEY_TWEET_NAME, message.getMessage());
		if ( message.getId() > 0) {
			content.put(DBConstants.KEY_TWEET_ID, message.getId());
		}

		return content;
	}
/*

	// convenience method

	public static Radar radarFromCursor(Cursor c) {
		assert c != null;

		String title = c.getString(c.getColumnIndex(KEY_RADAR_TITLE));
		String description = c.getString(c.getColumnIndex(KEY_RADAR_DESCRIPTION));
		long id = c.getLong(c.getColumnIndex(KEY_RADAR_ID));

		Radar radar = new Radar(title, description);
		radar.setId(id);

		return radar;
	}

*/
	/**
	 * Returns all radars in DB inside a Cursor
	 * @return cursor with all records
	 */

	/*
	public Cursor queryCursor() {
		// select
		DBHelper db = DBHelper.getInstance(this.databaseName, context.get());

		Cursor c = db.getReadableDatabase().query(TABLE_RADAR, allColumns, null, null, null, null, null);

		return c;
	}

	public Radars query() {
		Radars radars = new Radars();

		Cursor cursor = queryCursor();
		if (cursor != null && cursor.getCount() > 0) {
			cursor.moveToFirst();
			do {
				Radar radar = radarFromCursor(cursor);
				radars.add(radar);
			} while (cursor.moveToNext());
		}
		return radars;
	}

*/
	/**
	 * Returns a Radar object from its id
	 * @param id - the radar id in db
	 * @return Radar object if found, null otherwise
	 */

	/*
	public Radar query(long id) {
		Radar radar = null;

		DBHelper db = DBHelper.getInstance(this.databaseName, context.get());

		String where = KEY_RADAR_ID + "=" + id;
		Cursor c = db.getReadableDatabase().query(TABLE_RADAR, allColumns, where, null, null, null, null);
		if (c != null) {
			if (c.getCount() > 0) {
				c.moveToFirst();
				radar = radarFromCursor(c);
			}
		}
		c.close();
		db.close();
		return radar;
	}

*/
}
