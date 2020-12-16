package com.example.todoornot;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListDBhelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "ToDoList";
    public final static String TABLE_NAME = "Items";
    public final static String ID_COL = "_id";
    public final static String TEXT_COL = "ToDoItem";
    public final static String DATE_COL = "DueDate";
    public final static String DONE_COL = "Done";


    public ListDBhelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TEXT_COL + " TEXT," +
                DATE_COL + " TEXT," +
                DONE_COL + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Create
    public int newTask(String text, String date) {
        ContentValues taskItem = new ContentValues();
        taskItem.put(TEXT_COL, text);
        taskItem.put(DATE_COL, date);
        taskItem.put(DONE_COL, false);
        return (int) getWritableDatabase().insert(TABLE_NAME, null, taskItem);
    }

    //Read
    public ArrayList<ToDoItem> getItems() {
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, new String[]{ID_COL, TEXT_COL, DATE_COL, DONE_COL},
                null,
                null,
                null, null, null);
        ArrayList<ToDoItem> toDos = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                ToDoItem toDoItem = new ToDoItem(
                        cursor.getInt(cursor.getColumnIndex(ID_COL)),
                        cursor.getString(cursor.getColumnIndex(TEXT_COL)),
                        cursor.getString(cursor.getColumnIndex(DATE_COL)),
                        cursor.getInt(cursor.getColumnIndex(DONE_COL)) == 1
                );
                toDos.add(toDoItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return toDos;
    }

    //Update
    public void checkComplete(int id, boolean checkOn) {
        ContentValues cv = new ContentValues();
        cv.put(DONE_COL, checkOn);
        getWritableDatabase().update(TABLE_NAME, cv, "_id=?", new String[]{Integer.toString(id)});
    }

    //Delete
}
