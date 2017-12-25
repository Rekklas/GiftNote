package com.kovedward.android.giftnote.model;

import android.content.Context;

import java.util.List;
import java.util.UUID;

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

    public List<Gift> getGifts() {
        return null;
    }

    public Gift getGift(UUID giftId) {
        return null;
    }
}
