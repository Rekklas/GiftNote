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

/**
 * This class is controller which interacts with model's and view's objects.
 * It gives or modifies the information about specific gift.
 */

public class GiftFragment extends Fragment {

    private Gift mGift;
    private EditText mTitleField;
    private Button mDateButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gift, container, false);

        mTitleField = (EditText) v.findViewById(R.id.gift_title);
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

}
