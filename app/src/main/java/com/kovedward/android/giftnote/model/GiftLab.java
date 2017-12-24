package com.kovedward.android.giftnote.model;

import android.content.Context;

/**
 * Created by user on 25.12.2017.
 */

public class GiftLab {

    private static GiftLab sGiftLab;

    private GiftLab(Context context) {

    }

    public static GiftLab getGiftLab(Context context) {
        if (sGiftLab == null) {
            sGiftLab = new GiftLab(context);
        }
        return sGiftLab;
    }
}
