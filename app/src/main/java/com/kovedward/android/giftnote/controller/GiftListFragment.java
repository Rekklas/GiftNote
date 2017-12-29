package com.kovedward.android.giftnote.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kovedward.android.giftnote.R;
import com.kovedward.android.giftnote.model.Gift;
import com.kovedward.android.giftnote.model.GiftLab;

import java.util.List;


/**
 * This is a fragment that contains RecyclerView with the list of gifts
 *
 */

public class GiftListFragment extends Fragment {

    private RecyclerView mGiftRecyclerView;
    private GiftAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift_list, container, false);

        mGiftRecyclerView = (RecyclerView) view.findViewById(R.id.gift_recycler_view);
        mGiftRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    /**
     * This method updates the UI of list page
     */

    private void updateUI(){
        GiftLab giftLab = GiftLab.getGiftLab(getActivity());
        List<Gift> gifts = giftLab.getGifts();

        if (mAdapter == null) {
            mAdapter = new GiftAdapter(gifts);
            mGiftRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setGifts(gifts);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class GiftHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Gift mGift;

        private TextView mTitleTextView;
        private TextView mDateTextView;

        public GiftHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_gift, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.gift_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.gift_date_received);
        }

        public void bind(Gift gift){
            mGift = gift;
            mTitleTextView.setText(mGift.getTitle());
            mDateTextView.setText(mGift.getDateReceived().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = GiftActivity.newIntent(getActivity(), mGift.getId());
            startActivity(intent);
        }
    }

    private class GiftAdapter extends RecyclerView.Adapter<GiftHolder>{

        private List<Gift> mGifts;

        public GiftAdapter(List<Gift> gifts){
            mGifts = gifts;
        }

        @Override
        public GiftHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new GiftHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(GiftHolder holder, int position) {
            Gift gift = mGifts.get(position);
            holder.bind(gift);
        }

        @Override
        public int getItemCount() {
            return mGifts.size();
        }

        public void setGifts(List<Gift> gifts) {
            mGifts = gifts;
        }
    }
}
