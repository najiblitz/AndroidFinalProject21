package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction implements Parcelable {

    private int id;
    private String date;
    private String transactionName;
    private double amount;

    public Transaction(String date, String transactionName, double amount) {
        this.date = date;
        this.transactionName = transactionName;
        this.amount = amount;
    }

    public Transaction(int id, String date, String transactionName, double amount) {
        this.date = date;
        this.id = id;
        this.transactionName = transactionName;
        this.amount = amount;
    }

    protected Transaction(Parcel in) {
        id = in.readInt();
        date = in.readString();
        transactionName = in.readString();
        amount = in.readDouble();
    }

    public Transaction() {

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeString(transactionName);
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
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
                "transactionName='" + transactionName + '\'' +
                '}';
    }

}
