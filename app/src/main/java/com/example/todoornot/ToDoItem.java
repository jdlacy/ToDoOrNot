package com.example.todoornot;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToDoItem {

    private int id;
    private String text;
    private String date;
    private boolean checkedOn;

    public ToDoItem(int id, String text, String date, boolean checkedOn) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.checkedOn = checkedOn;
    }
    public String getItem() {return text;}

    public String getDate() {return date;}

    public boolean isChecked() {return checkedOn;}

    public int getID() {return id;}
}
