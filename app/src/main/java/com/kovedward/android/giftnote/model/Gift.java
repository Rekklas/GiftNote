package com.kovedward.android.giftnote.model;

import java.util.Date;
import java.util.UUID;

/**
 * This class is a model for gift objects
 */

public class Gift {

    private UUID mId;
    private String mTitle;
    private Date mDateReceived;
    private String mGiftGiver;

    public Gift() {
        this(UUID.randomUUID());
    }

    public Gift(UUID id){
        mId = id;
        mDateReceived = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDateReceived() {
        return mDateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        mDateReceived = dateReceived;
    }

    public String getGiftGiver() {
        return mGiftGiver;
    }

    public void setGiftGiver(String giftGiver) {
        mGiftGiver = giftGiver;
    }
}
