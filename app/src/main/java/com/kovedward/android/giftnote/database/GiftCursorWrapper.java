package com.kovedward.android.giftnote.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.kovedward.android.giftnote.model.Gift;

import java.util.Date;
import java.util.UUID;

import static com.kovedward.android.giftnote.database.GiftContract.*;

/**
 * Created by user on 29.12.2017.
 */

public class GiftCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public GiftCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Gift getGift(){
        String uuidString = getString(getColumnIndex(GiftTable.Cols.UUID));
        String title = getString(getColumnIndex(GiftTable.Cols.TITLE));
        long date = getLong(getColumnIndex(GiftTable.Cols.DATE));

        Gift gift = new Gift(UUID.fromString(uuidString));
        gift.setTitle(title);
        gift.setDateReceived(new Date(date));

        return gift;
    }
}
