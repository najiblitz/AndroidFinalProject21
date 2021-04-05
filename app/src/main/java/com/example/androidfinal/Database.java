package com.example.androidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidfinal.Pojo.Money;
import com.example.androidfinal.Pojo.Saving;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "moneyscentsdb";

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
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SAVING_TABLE);
        db.execSQL(CREATE_MONEY_TABLE);
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
        values.put(COLUMN_TITLE, saving.getTitle());
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

    MONEY CONVERTER

     */


    public static final String TABLE_MONEY = "money";

    public static final String COLUMN_AMOUNT_TO_CONVERT = "amount_to_convert";

    public static final String CREATE_MONEY_TABLE = "CREATE TABLE " + TABLE_MONEY + "(" + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_AMOUNT_TO_CONVERT + " DOUBLE)";

    // add new Money object
    public void addMoney(Money money) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_AMOUNT_TO_CONVERT, money.getAmountToConvert());
        db.insert(TABLE_MONEY, null, values);
        db.close();
    }

    public Money getMoney(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Money money = null;
        Cursor cursor = db.query(TABLE_MONEY, new String[]{COLUMN_ID, COLUMN_AMOUNT_TO_CONVERT}, COLUMN_ID + "= ?", new String[]{String.valueOf(id)}, null,null,null);
        if (cursor.moveToFirst()) {
            money = new Money(cursor.getInt(0),
                    cursor.getDouble(1));
        }
        db.close();
        return money;
    }

//    // can i use something like this instead of created a new object each time for future?? (none of this was used for this today. extra code)
//
//    public int updateMoney(Money money) {
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_AMOUNT_TO_CONVERT, money.getAmountToConvert());
//        return db.update(TABLE_MONEY, values, COLUMN_ID + "=?", new String[]{String.valueOf(money.getId())});
//    }
//
//    public void deleteMoney(int money) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_MONEY, COLUMN_ID + "=?", new String[]{String.valueOf(money)});
//        db.close();
//    }


}