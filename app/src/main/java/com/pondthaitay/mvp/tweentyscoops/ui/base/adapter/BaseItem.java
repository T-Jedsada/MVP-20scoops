package com.pondthaitay.mvp.tweentyscoops.ui.base.adapter;

@org.parceler.Parcel(org.parceler.Parcel.Serialization.BEAN)
public class BaseItem {

    private int type;

    public BaseItem(int type) {
        this.type = type;
    }

    BaseItem() {
    }

    int getType() {
        return type;
    }
}
