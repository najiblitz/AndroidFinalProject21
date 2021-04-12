package com.example.androidfinal.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Budget implements Parcelable {

    private int id;

    // salary

    private double salary;

    // Home

    private double home;
    private double electric;
    private double oil;
    private double tv;
    private double phone;
    private double homeRepairs;
    private double homeOther;

    // Vehicle

    private double car;
    private double insurance;
    private double gas;
    private double carRepairs;
    private double carOther;

    // Daily

    private double dining;
    private double groceries;
    private double beauty;
    private double personal;
    private double activities;
    private double shows;
    private double dailyOther;

    public Budget(double salary, double home, double electric, double oil, double tv, double phone, double homeRepairs, double homeOther, double car, double insurance, double gas, double carRepairs, double carOther, double dining, double groceries, double beauty, double personal, double activities, double shows, double dailyOther) {
        this.salary = salary;
        this.home = home;
        this.electric = electric;
        this.oil = oil;
        this.tv = tv;
        this.phone = phone;
        this.homeRepairs = homeRepairs;
        this.homeOther = homeOther;
        this.car = car;
        this.insurance = insurance;
        this.gas = gas;
        this.carRepairs = carRepairs;
        this.carOther = carOther;
        this.dining = dining;
        this.groceries = groceries;
        this.beauty = beauty;
        this.personal = personal;
        this.activities = activities;
        this.shows = shows;
        this.dailyOther = dailyOther;
    }
    public Budget(int id, double salary, double home, double electric, double oil, double tv, double phone, double homeRepairs, double homeOther, double car, double insurance, double gas, double carRepairs, double carOther, double dining, double groceries, double beauty, double personal, double activities, double shows, double dailyOther) {
        this.id = id;
        this.salary = salary;
        this.home = home;
        this.electric = electric;
        this.oil = oil;
        this.tv = tv;
        this.phone = phone;
        this.homeRepairs = homeRepairs;
        this.homeOther = homeOther;
        this.car = car;
        this.insurance = insurance;
        this.gas = gas;
        this.carRepairs = carRepairs;
        this.carOther = carOther;
        this.dining = dining;
        this.groceries = groceries;
        this.beauty = beauty;
        this.personal = personal;
        this.activities = activities;
        this.shows = shows;
        this.dailyOther = dailyOther;
    }

    protected Budget(Parcel in) {
        id = in.readInt();
        salary = in.readDouble();
        home = in.readDouble();
        electric = in.readDouble();
        oil = in.readDouble();
        tv = in.readDouble();
        phone = in.readDouble();
        homeRepairs = in.readDouble();
        homeOther = in.readDouble();
        car = in.readDouble();
        insurance = in.readDouble();
        gas = in.readDouble();
        carRepairs = in.readDouble();
        carOther = in.readDouble();
        dining = in.readDouble();
        groceries = in.readDouble();
        beauty = in.readDouble();
        personal = in.readDouble();
        activities = in.readDouble();
        shows = in.readDouble();
        dailyOther = in.readDouble();
    }

    public Budget() {

        salary = 0;
        home = 0;
        electric = 0;
        oil = 0;
        tv = 0;
        phone = 0;
        homeRepairs = 0;
        homeOther = 0;
        car = 0;
        insurance = 0;
        gas = 0;
        carRepairs = 0;
        carOther = 0;
        dining = 0;
        groceries = 0;
        beauty = 0;
        personal = 0;
        activities = 0;
        shows = 0;
        dailyOther = 0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(salary);
        dest.writeDouble(home);
        dest.writeDouble(electric);
        dest.writeDouble(oil);
        dest.writeDouble(tv);
        dest.writeDouble(phone);
        dest.writeDouble(homeRepairs);
        dest.writeDouble(homeOther);
        dest.writeDouble(car);
        dest.writeDouble(insurance);
        dest.writeDouble(gas);
        dest.writeDouble(carRepairs);
        dest.writeDouble(carOther);
        dest.writeDouble(dining);
        dest.writeDouble(groceries);
        dest.writeDouble(beauty);
        dest.writeDouble(personal);
        dest.writeDouble(activities);
        dest.writeDouble(shows);
        dest.writeDouble(dailyOther);
    }

    @Override
    public int describeContents() {
        return 0;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getHome() {
        return home;
    }

    public void setHome(double home) {
        this.home = home;
    }

    public double getElectric() {
        return electric;
    }

    public void setElectric(double electric) {
        this.electric = electric;
    }

    public double getOil() {
        return oil;
    }

    public void setOil(double oil) {
        this.oil = oil;
    }

    public double getTv() {
        return tv;
    }

    public void setTv(double tv) {
        this.tv = tv;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public double getHomeRepairs() {
        return homeRepairs;
    }

    public void setHomeRepairs(double homeRepairs) {
        this.homeRepairs = homeRepairs;
    }

    public double getHomeOther() {
        return homeOther;
    }

    public void setHomeOther(double homeOther) {
        this.homeOther = homeOther;
    }

    public double getCar() {
        return car;
    }

    public void setCar(double car) {
        this.car = car;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getCarRepairs() {
        return carRepairs;
    }

    public void setCarRepairs(double carRepairs) {
        this.carRepairs = carRepairs;
    }

    public double getCarOther() {
        return carOther;
    }

    public void setCarOther(double carOther) {
        this.carOther = carOther;
    }

    public double getDining() {
        return dining;
    }

    public void setDining(double dining) {
        this.dining = dining;
    }

    public double getGroceries() {
        return groceries;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

    public double getBeauty() {
        return beauty;
    }

    public void setBeauty(double beauty) {
        this.beauty = beauty;
    }

    public double getPersonal() {
        return personal;
    }

    public void setPersonal(double personal) {
        this.personal = personal;
    }

    public double getActivities() {
        return activities;
    }

    public void setActivities(double activities) {
        this.activities = activities;
    }

    public double getShows() {
        return shows;
    }

    public void setShows(double shows) {
        this.shows = shows;
    }

    public double getDailyOther() {
        return dailyOther;
    }

    public void setDailyOther(double dailyOther) {
        this.dailyOther = dailyOther;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "home=" + home +
                '}';
    }



}
