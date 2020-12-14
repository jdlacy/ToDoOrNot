package com.example.todoornot;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    TextView items;
    CheckBox checkBox;
    TextView toDoText;
    TextView dateText;

    public ToDoViewHolder(@NonNull View itemV) {
        super(itemV);
        checkBox = itemV.findViewById(R.id.checkBox);
        toDoText = itemV.findViewById(R.id.toDoBox);
        dateText = itemV.findViewById(R.id.dateBox);
    }

}