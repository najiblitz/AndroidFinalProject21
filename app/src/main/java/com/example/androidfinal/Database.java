package com.example.androidfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androidfinal.Pojo.Saving;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "moneyscentsdb";

    // SAVINGS TABLE

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

}