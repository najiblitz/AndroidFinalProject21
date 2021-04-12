package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Billing implements Parcelable {

    private int id;
    private String companyName;
    private String companyPhone;
    private String companyWebsite;

    public Billing(String companyName, String companyPhone, String companyWebsite) {
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyWebsite = companyWebsite;
    }

    public Billing(int id, String companyName, String companyPhone, String companyWebsite) {
        this.id = id;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyWebsite = companyWebsite;
    }

    protected Billing(Parcel in) {
        id = in.readInt();
        companyName = in.readString();
        companyPhone = in.readString();
        companyWebsite = in.readString();
    }

    public Billing() {

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(companyName);
        dest.writeString(companyPhone);
        dest.writeString(companyWebsite);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Billing> CREATOR = new Creator<Billing>() {
        @Override
        public Billing createFromParcel(Parcel in) {
            return new Billing(in);
        }

        @Override
        public Billing[] newArray(int size) {
            return new Billing[size];
        }
    };


    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }


    @Override
    public String toString() {
        return "Billing{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
