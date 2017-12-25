package com.kovedward.android.giftnote.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class GiftActivity extends SingleFragmentActivity {

    public static final String EXTRA_GIFT_ID = "extra_gift_id";

    public static Intent newIntent(Context packageContext, UUID giftId) {
        Intent intent = new Intent(packageContext, GiftActivity.class);
        intent.putExtra(EXTRA_GIFT_ID, giftId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID giftId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_GIFT_ID);
        return GiftFragment.newInstance(giftId);
    }
}
