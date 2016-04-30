package com.nicatec.probandodb;

/**
 * Created by vtx on 21/4/16.
 */
public class DBConstants {
	public static final String TABLE_TWEETS = "TWEETS";
	// Table field constants
	public static final String KEY_TWEET_ID = "_id";
	public static final String KEY_TWEET_NAME = "name";
	public static final String[] allColumns = {
			KEY_TWEET_ID,
			KEY_TWEET_NAME,
	};
	public static final String SQL_CREATE_TWEETS_TABLE =
			"create table " + TABLE_TWEETS
					+ "( " + KEY_TWEET_ID
					+ " integer primary key autoincrement, "
					+ KEY_TWEET_NAME + " text not null"
					//+ KEY_RADAR_DESCRIPTION + " text not null"
					+ ");";
}
