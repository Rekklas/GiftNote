package com.kovedward.android.giftnote.controller;

import android.support.v4.app.Fragment;

public class GiftActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new GiftFragment();
    }
}
