package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Budget implements Parcelable {

    private int id;
    private double home;

    protected Budget(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static final Creator<Budget> CREATOR = new Creator<Budget>() {
        @Override
        public Budget createFromParcel(Parcel in) {
            return new Budget(in);
        }

        @Override
        public Budget[] newArray(int size) {
            return new Budget[size];
        }
    };


}
