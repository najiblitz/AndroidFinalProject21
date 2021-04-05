package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Money implements Parcelable {

    private int id;
    private double amountToConvert;
    private double amountConverted;
    private String oldCurrency;
    private String newCurrency;

    public Money(double amountToConvert, double amountConverted, String oldCurrency, String newCurrency) {
        this.amountConverted = amountConverted;
        this.amountToConvert = amountToConvert;
        this.oldCurrency = oldCurrency;
        this.newCurrency = newCurrency;
    }

    public Money(int id, double amountToConvert, double amountConverted, String oldCurrency, String newCurrency) {
        this.id = id;
        this.amountConverted = amountConverted;
        this.amountToConvert = amountToConvert;
        this.oldCurrency = oldCurrency;
        this.newCurrency = newCurrency;
    }

    public Money(Parcel in) {
        id = in.readInt();
        amountToConvert = in.readDouble();
        amountConverted = in.readDouble();
        oldCurrency = in.readString();
        newCurrency = in.readString();
    }

    public Money(int anInt, double aDouble) {
        this.id = anInt;
        this.amountConverted = aDouble;
    }

    public Money() {

    }

    public Money(double parseDouble) {
        this.amountConverted = getAmountConverted();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(amountToConvert);
        dest.writeDouble(amountConverted);
        dest.writeString(oldCurrency);
        dest.writeString(newCurrency);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Money> CREATOR = new Creator<Money>() {
        @Override
        public Money createFromParcel(Parcel in) {
            return new Money(in);
        }

        @Override
        public Money[] newArray(int size) {
            return new Money[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public double getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(double amountConverted) {
        this.amountConverted = amountConverted;
    }

    public String getOldCurrency() {
        return oldCurrency;
    }

    public void setOldCurrency(String oldCurrency) {
        this.oldCurrency = oldCurrency;
    }

    public String getNewCurrency() {
        return newCurrency;
    }

    public void setNewCurrency(String newCurrency) {
        this.newCurrency = newCurrency;
    }

}
