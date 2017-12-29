package com.kovedward.android.giftnote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kovedward.android.giftnote.database.GiftContract.GiftTable;

/**
 * Created by user on 26.12.2017.
 */

public class GiftDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "gift.db";
    public static final int DATABASE_VERSION = 1;


    public GiftDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GIFTS_TABLE = "CREATE TABLE" + GiftTable.NAME + "(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GiftTable.Cols.UUID + "TEXT NOT NULL, " +
                GiftTable.Cols.TITLE + ", " +
                GiftTable.Cols.DATE +
                "); ";

        db.execSQL(SQL_CREATE_GIFTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
