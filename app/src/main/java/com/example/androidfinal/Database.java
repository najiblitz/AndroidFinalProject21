package com.example.androidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidfinal.Pojo.Billing;
import com.example.androidfinal.Pojo.Budget;
import com.example.androidfinal.Pojo.Saving;
import com.example.androidfinal.Pojo.Transaction;


import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "moneyscentsdb";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SAVING_TABLE);
        db.execSQL(CREATE_BUDGET_TABLE);
        db.execSQL(CREATE_TRANSACTION_TABLE);
    }

    /*

    SAVINGS TRACKER

     */

    public static final String TABLE_SAVING = "saving";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_HAVE_AMOUNT = "haveAmount";
    public static final String COLUMN_GOAL_AMOUNT = "goalAmount";

    public static final String CREATE_SAVING_TABLE = "CREATE TABLE " + TABLE_SAVING + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_TITLE + " TEXT, " + COLUMN_HAVE_AMOUNT + " DOUBLE, " + COLUMN_GOAL_AMOUNT + " DOUBLE)";



    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addSaving(Saving saving) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, saving.getTitle());
        values.put(COLUMN_HAVE_AMOUNT, saving.getHaveAmount());
        values.put(COLUMN_GOAL_AMOUNT, saving.getGoalAmount());
        db.insert(TABLE_SAVING, null, values);
        db.close();
    }

    public Saving getSaving(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Saving saving = null;
        Cursor cursor = db.query(TABLE_SAVING, new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_HAVE_AMOUNT, COLUMN_GOAL_AMOUNT}, COLUMN_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            saving = new Saving(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3)
            );

        }
        db.close();
        return saving;
    }

    public ArrayList<Saving> getAllSavings() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE_SAVING, null);
        ArrayList<Saving> savings = new ArrayList<>();
        while (cursor.moveToNext()) {
            savings.add(new Saving(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3)
            ));
        }
        db.close();
        return savings;

    }

    public int updateSaving(Saving saving) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, saving.getTitle());
        values.put(COLUMN_HAVE_AMOUNT, saving.getHaveAmount());
        values.put(COLUMN_GOAL_AMOUNT, saving.getGoalAmount());
        return db.update(TABLE_SAVING, values, COLUMN_ID + "=?", new String[]{String.valueOf(saving.getId())});
    }

    public void deleteSaving(int saving) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SAVING, COLUMN_ID + "=?", new String[]{String.valueOf(saving)});
        db.close();
    }






    /*

    BUDGET TRACKER

     */



    public static final String TABLE_BUDGET = "budget";

    public static final String COLUMN_SALARY = "salary";
    public static final String COLUMN_HOME = "home";
    public static final String COLUMN_ELECTRIC = "electric";
    public static final String COLUMN_OIL = "oil";
    public static final String COLUMN_TV = "tv";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_HOME_REPAIRS = "home_repairs";
    public static final String COLUMN_HOME_OTHER = "home_other";
    public static final String COLUMN_VEHICLE = "vehicle";
    public static final String COLUMN_INSURANCE = "insurance";
    public static final String COLUMN_GAS = "gas";
    public static final String COLUMN_CAR_REPAIRS = "car_repairs";
    public static final String COLUMN_CAR_OTHER = "car_other";
    public static final String COLUMN_DINING = "dining";
    public static final String COLUMN_GROCERIES = "groceries";
    public static final String COLUMN_HEALTH = "health";
    public static final String COLUMN_PERSONAL = "personal";
    public static final String COLUMN_ACTIVITIES = "activities";
    public static final String COLUMN_SHOWS = "shows";
    public static final String COLUMN_DAILY_OTHER = "daily_other";

    public static final String CREATE_BUDGET_TABLE = "CREATE TABLE " + TABLE_BUDGET + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_SALARY + " DOUBLE, " +
            COLUMN_HOME + " DOUBLE, " +
            COLUMN_ELECTRIC + " DOUBLE, " +
            COLUMN_OIL + " DOUBLE, " +
            COLUMN_TV + " DOUBLE, " +
            COLUMN_PHONE + " DOUBLE, " +
            COLUMN_HOME_REPAIRS + " DOUBLE, " +
            COLUMN_HOME_OTHER + " DOUBLE, " +
            COLUMN_VEHICLE + " DOUBLE, " +
            COLUMN_INSURANCE + " DOUBLE, " +
            COLUMN_GAS + " DOUBLE, " +
            COLUMN_CAR_REPAIRS + " DOUBLE, " +
            COLUMN_CAR_OTHER + " DOUBLE, " +
            COLUMN_DINING + " DOUBLE, " +
            COLUMN_GROCERIES + " DOUBLE, " +
            COLUMN_HEALTH + " DOUBLE, " +
            COLUMN_PERSONAL + " DOUBLE, " +
            COLUMN_ACTIVITIES + " DOUBLE, " +
            COLUMN_SHOWS + " DOUBLE, " +
            COLUMN_DAILY_OTHER + " DOUBLE)";


    public void addBudget(Budget budget) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALARY, budget.getSalary());
        values.put(COLUMN_HOME, budget.getHome());
        values.put(COLUMN_ELECTRIC, budget.getElectric());
        values.put(COLUMN_OIL, budget.getOil());
        values.put(COLUMN_TV, budget.getTv());
        values.put(COLUMN_PHONE, budget.getPhone());
        values.put(COLUMN_HOME_REPAIRS, budget.getHomeRepairs());
        values.put(COLUMN_HOME_OTHER, budget.getHomeOther());
        values.put(COLUMN_VEHICLE, budget.getCar());
        values.put(COLUMN_INSURANCE, budget.getInsurance());
        values.put(COLUMN_GAS, budget.getGas());
        values.put(COLUMN_CAR_REPAIRS, budget.getCarRepairs());
        values.put(COLUMN_CAR_OTHER, budget.getCarOther());
        values.put(COLUMN_DINING, budget.getDining());
        values.put(COLUMN_GROCERIES, budget.getGroceries());
        values.put(COLUMN_HEALTH, budget.getBeauty());
        values.put(COLUMN_PERSONAL, budget.getPersonal());
        values.put(COLUMN_ACTIVITIES, budget.getActivities());
        values.put(COLUMN_SHOWS, budget.getShows());
        values.put(COLUMN_DAILY_OTHER, budget.getDailyOther());

        db.insert(TABLE_BUDGET, null, values);
        db.close();
    }

    public Budget getBudget(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Budget budget = null;
        Cursor cursor = db.query(TABLE_BUDGET, new String[]{COLUMN_ID, COLUMN_SALARY, COLUMN_HOME,}, COLUMN_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            budget = new Budget(cursor.getInt(0),
                    cursor.getDouble(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7),
                    cursor.getDouble(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getDouble(11),
                    cursor.getDouble(12),
                    cursor.getDouble(13),
                    cursor.getDouble(14),
                    cursor.getDouble(15),
                    cursor.getDouble(16),
                    cursor.getDouble(17),
                    cursor.getDouble(18),
                    cursor.getDouble(19),
                    cursor.getDouble(20)
            );

        }
        db.close();
        return budget;
    }

    public ArrayList<Budget> getAllBudgets() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE_BUDGET, null);
        ArrayList<Budget> budgets = new ArrayList<>();
        while (cursor.moveToNext()) {
            budgets.add(new Budget(
                    cursor.getInt(0),
                    cursor.getDouble(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4),
                    cursor.getDouble(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7),
                    cursor.getDouble(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getDouble(11),
                    cursor.getDouble(12),
                    cursor.getDouble(13),
                    cursor.getDouble(14),
                    cursor.getDouble(15),
                    cursor.getDouble(16),
                    cursor.getDouble(17),
                    cursor.getDouble(18),
                    cursor.getDouble(19),
                    cursor.getDouble(20)
            ));
        }
        db.close();
        return budgets;

    }

    public int updateBudget(Budget budget) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SALARY, budget.getSalary());
        values.put(COLUMN_HOME, budget.getHome());
        values.put(COLUMN_ELECTRIC, budget.getElectric());
        values.put(COLUMN_OIL, budget.getOil());
        values.put(COLUMN_TV, budget.getTv());
        values.put(COLUMN_PHONE, budget.getPhone());
        values.put(COLUMN_HOME_REPAIRS, budget.getHomeRepairs());
        values.put(COLUMN_HOME_OTHER, budget.getHomeOther());
        values.put(COLUMN_VEHICLE, budget.getCar());
        values.put(COLUMN_INSURANCE, budget.getInsurance());
        values.put(COLUMN_GAS, budget.getGas());
        values.put(COLUMN_CAR_REPAIRS, budget.getCarRepairs());
        values.put(COLUMN_CAR_OTHER, budget.getCarOther());
        values.put(COLUMN_DINING, budget.getDining());
        values.put(COLUMN_GROCERIES, budget.getGroceries());
        values.put(COLUMN_HEALTH, budget.getBeauty());
        values.put(COLUMN_PERSONAL, budget.getPersonal());
        values.put(COLUMN_ACTIVITIES, budget.getActivities());
        values.put(COLUMN_SHOWS, budget.getShows());
        values.put(COLUMN_DAILY_OTHER, budget.getDailyOther());

        return db.update(TABLE_BUDGET, values, COLUMN_ID + "=?", new String[]{String.valueOf(budget.getId())});

}

















 /*

    Billing Contacts

     */

    public static final String TABLE_BILLING = "billing";
    public static final String COLUMN_COMPANY_NAME = "name";
    public static final String COLUMN_COMPANY_NUMBER = "phone";
    public static final String COLUMN_COMPANY_WEBSITE = "website";

    public static final String CREATE_BILLING_TABLE = "CREATE TABLE " + TABLE_BILLING + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_COMPANY_NAME + " TEXT, " + COLUMN_PHONE + " TEXT, " + COLUMN_COMPANY_WEBSITE + " TEXT)";


    public void addBilling(Billing billing) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPANY_NAME, billing.getCompanyName());
        values.put(COLUMN_COMPANY_NUMBER, billing.getCompanyPhone());
        values.put(COLUMN_COMPANY_WEBSITE, billing.getCompanyWebsite());
        db.insert(TABLE_BILLING, null, values);
        db.close();
    }

    public Billing getBilling(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Billing billing = null;
        Cursor cursor = db.query(TABLE_BILLING, new String[]{COLUMN_ID, COLUMN_COMPANY_NAME, COLUMN_COMPANY_NUMBER, COLUMN_COMPANY_WEBSITE}, COLUMN_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            billing = new Billing(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );

        }
        db.close();
        return billing;
    }



    public ArrayList<Billing> getAllBilling() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE_BILLING, null);
        ArrayList<Billing> billings = new ArrayList<>();
        while (cursor.moveToNext()) {
            billings.add(new Billing(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2))
            );
        }
        db.close();
        return billings;

    }

    public int updateBilling(Billing billing) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPANY_NAME, billing.getCompanyName());
        values.put(COLUMN_COMPANY_NUMBER, billing.getCompanyPhone());
        values.put(COLUMN_COMPANY_WEBSITE, billing.getCompanyWebsite());
        return db.update(TABLE_BILLING, values, COLUMN_ID + "=?", new String[]{String.valueOf(billing.getId())});
    }

    public void deleteBilling(int billing) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BILLING, COLUMN_ID + "=?", new String[]{String.valueOf(billing)});
        db.close();
    }
















 /*

    Transactions

     */

    public static final String TABLE_TRANSACTION = "transaction";
    public static final String COLUMN_TRANSACTION_DATE = "date";
    public static final String COLUMN_TRANSACTION_NAME = "name";
    public static final String COLUMN_TRANSACTION_AMOUNT = "amount";


    public static final String CREATE_TRANSACTION_TABLE = "CREATE TABLE " + TABLE_SAVING + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_TITLE + " TEXT, " + COLUMN_HAVE_AMOUNT + " DOUBLE, " + COLUMN_GOAL_AMOUNT + " DOUBLE)";



    public void addTransaction(Transaction transaction) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRANSACTION_DATE, transaction.getDate());
        values.put(COLUMN_TRANSACTION_NAME, transaction.getTransactionName());
        values.put(COLUMN_TRANSACTION_AMOUNT, transaction.getAmount());
        db.insert(TABLE_TRANSACTION, null, values);
        db.close();
    }

    public Transaction getTransaction(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Transaction transaction = null;
        Cursor cursor = db.query(TABLE_TRANSACTION, new String[]{COLUMN_ID, COLUMN_TRANSACTION_DATE, COLUMN_TRANSACTION_NAME, COLUMN_TRANSACTION_AMOUNT}, COLUMN_ID + "= ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToFirst()) {
            transaction = new Transaction(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getDouble(3)
            );

        }
        db.close();
        return transaction;

    }



    public ArrayList<Transaction> getAllTransactions() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE_TRANSACTION, null);
        ArrayList<Transaction> transactions = new ArrayList<>();
        while (cursor.moveToNext()) {
            transactions.add(new Transaction(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2),
            cursor.getDouble(3))
            );
        }
        db.close();
        return transactions;
    }


    public int updateTransaction(Transaction transaction) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TRANSACTION_DATE, transaction.getDate());
        values.put(COLUMN_TRANSACTION_NAME, transaction.getTransactionName());
        values.put(COLUMN_TRANSACTION_AMOUNT, transaction.getAmount());
        return db.update(TABLE_TRANSACTION, values, COLUMN_ID + "=?", new String[]{String.valueOf(transaction.getId())});
    }

    public void deleteTransaction(int billing) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTION, COLUMN_ID + "=?", new String[]{String.valueOf(billing)});
        db.close();
    }





}