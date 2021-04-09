package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {

    private int id;
    private String category;
    private String name;
    private double amount;

    public Transaction(String category, String name, double amount) {
        this.category = category;
        this.name = name;
        this.amount = amount;
    }

    public Transaction(int id, String category, String name, double amount) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.amount = amount;
    }

    protected Transaction(Parcel in) {
        id = in.readInt();
        category = in.readString();
        name = in.readString();
        amount = in.readDouble();
    }

    public Transaction() {

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(category);
        dest.writeDouble(amount);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<Transaction> CREATOR = new Creator<Transaction>() {
        @Override
        public Transaction createFromParcel(Parcel in) {
            return new Transaction(in);
        }

        @Override
        public Transaction[] newArray(int size) {
            return new Transaction[size];
        }
    };


    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "category='" + category + '\'' +
                '}';
    }

}
