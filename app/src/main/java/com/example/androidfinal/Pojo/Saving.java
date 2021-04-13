package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Saving implements Parcelable {

    /**
     * This class is a pojo that represents each saving
     * @author najiblitz
     * @version 1.0
     *
     */

    private int id;
    private String title;
    private double haveAmount;
    private double goalAmount;

    public Saving(String title, double haveAmount, double goalAmount) {
        this.title = title;
        this.haveAmount = haveAmount;
        this.goalAmount = goalAmount;

    }

    public Saving(int id, String title, double haveAmount, double goalAmount) {

        this.id = id;
        this.title = title;
        this.haveAmount = haveAmount;
        this.goalAmount = goalAmount;

    }

    protected Saving(Parcel in) {
        id = in.readInt();
        title = in.readString();
        haveAmount = in.readDouble();
        goalAmount = in.readDouble();
    }

    public Saving() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeDouble(haveAmount);
        dest.writeDouble(goalAmount);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Saving> CREATOR = new Creator<Saving>() {
        @Override
        public Saving createFromParcel(Parcel in) {
            return new Saving(in);
        }

        @Override
        public Saving[] newArray(int size) {
            return new Saving[size];
        }
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public double getHaveAmount() {
        return haveAmount;
    }

    public void setHaveAmount(double haveAmount) {
        this.haveAmount = haveAmount;
    }
    public double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(double goalAmount) {
        this.goalAmount = goalAmount;
    }

    @Override
    public String toString() {
        return "Saving{" +
                "title='" + title + '\'' +
                '}';
    }



}