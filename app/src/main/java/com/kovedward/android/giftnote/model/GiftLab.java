package com.kovedward.android.giftnote.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kovedward.android.giftnote.database.GiftContract;
import com.kovedward.android.giftnote.database.GiftContract.GiftTable;
import com.kovedward.android.giftnote.database.GiftCursorWrapper;
import com.kovedward.android.giftnote.database.GiftDbHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 25.12.2017.
 */

public class GiftLab {

    private static GiftLab sGiftLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private GiftLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new GiftDbHelper(mContext)
                .getWritableDatabase();
    }

    public static GiftLab getGiftLab(Context context) {
        if (sGiftLab == null) {
            sGiftLab = new GiftLab(context);
        }
        return sGiftLab;
    }

    public void addGift(Gift gift) {
        ContentValues values = getContentValues(gift);
        mDatabase.insert(GiftTable.NAME, null, values);
    }

    public List<Gift> getGifts() {
        List<Gift> gifts = new ArrayList<>();

        GiftCursorWrapper cursor = queryGifts(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                gifts.add(cursor.getGift());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return gifts;
    }

    public Gift getGift(UUID giftId) {
        GiftCursorWrapper cursor  = queryGifts(
                GiftTable.Cols.UUID + " =?",
                new String[]{giftId.toString()}
        );
        try {
            if (cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getGift();
        } finally {
            cursor.close();
        }
    }

    public void updateGift(Gift gift) {
        String uuidString = gift.getId().toString();
        ContentValues values = getContentValues(gift);

        mDatabase.update(GiftTable.NAME, values,
                GiftTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    private GiftCursorWrapper queryGifts(String whereClause, String[] whereArgs) {

        Cursor cursor = mDatabase.query(
                GiftTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new GiftCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Gift gift) {
        ContentValues values = new ContentValues();
        values.put(GiftTable.Cols.UUID, gift.getId().toString());
        values.put(GiftTable.Cols.TITLE, gift.getTitle());
        values.put(GiftTable.Cols.DATE, gift.getDateReceived().getTime());

        return values;
    }
}
