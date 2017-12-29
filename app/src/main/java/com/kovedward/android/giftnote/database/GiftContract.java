package com.kovedward.android.giftnote.database;

/**
 * Created by user on 26.12.2017.
 */

public class GiftContract {

    public static final class GiftTable {
        public static final String NAME = "gifts";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
        }
    }
}
