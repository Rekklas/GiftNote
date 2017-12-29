package com.kovedward.android.giftnote.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kovedward.android.giftnote.R;
import com.kovedward.android.giftnote.model.Gift;
import com.kovedward.android.giftnote.model.GiftLab;

import java.util.UUID;

/**
 * This class is controller which interacts with model's and view's objects.
 * It gives or modifies the information about specific gift.
 */

public class GiftFragment extends Fragment {

    public static final String ARG_GIFT_ID = "gift_id";

    private Gift mGift;
    private EditText mTitleField;
    private Button mDateButton;

    public static GiftFragment newInstance(UUID giftId) {
        
        Bundle args = new Bundle();
        args.putSerializable(ARG_GIFT_ID, giftId);
        
        GiftFragment fragment = new GiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID giftId = (UUID) getArguments().getSerializable(ARG_GIFT_ID);
        mGift = GiftLab.getGiftLab(getActivity()).getGift(giftId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gift, container, false);

        mTitleField = (EditText) v.findViewById(R.id.gift_title);
        mTitleField.setText(mGift.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGift.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.gift_date_received);

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();

        GiftLab.getGiftLab(getActivity())
                .updateGift(mGift);
    }
}
