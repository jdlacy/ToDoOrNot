package com.example.todoornot;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ToDoViewHolder extends RecyclerView.ViewHolder {
    public CheckBox checkBox;
    public TextView dateText;

    public ToDoViewHolder(@NonNull View itemV) {
        super(itemV);

        checkBox = itemV.findViewById(R.id.checkBox);
        dateText = itemV.findViewById(R.id.dateBox);
    }

}