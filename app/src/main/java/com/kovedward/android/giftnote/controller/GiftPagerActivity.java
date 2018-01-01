package com.kovedward.android.giftnote.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.kovedward.android.giftnote.R;
import com.kovedward.android.giftnote.model.Gift;
import com.kovedward.android.giftnote.model.GiftLab;

import java.util.List;
import java.util.UUID;

/**
 * Created by user on 02.01.2018.
 */

public class GiftPagerActivity extends AppCompatActivity {
    public static final String EXTRA_GIFT_ID = "gift_id";

    private ViewPager mViewPager;
    private List<Gift> mGifts;

    public static Intent newIntent(Context packageContext, UUID giftId){
        Intent intent = new Intent(packageContext, GiftPagerActivity.class);
        intent.putExtra(EXTRA_GIFT_ID, giftId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_pager);

        UUID giftId = (UUID) getIntent().getSerializableExtra(EXTRA_GIFT_ID);

        mViewPager = (ViewPager) findViewById(R.id.gift_view_pager);

        mGifts = GiftLab.getGiftLab(this).getGifts();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Gift gift = mGifts.get(position);
                return GiftFragment.newInstance(gift.getId());
            }

            @Override
            public int getCount() {
                return mGifts.size();
            }
        });

        for (int i = 0; i < mGifts.size(); i++) {
            if (mGifts.get(i).getId().equals(giftId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
