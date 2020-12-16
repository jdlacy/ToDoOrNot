package com.example.todoornot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    private ArrayList<ToDoItem> toDoItems;
    private ListDBhelper dBhelper;

    public ToDoAdapter(ArrayList<ToDoItem> toDoItems,
                       ListDBhelper dBhelper) {
        this.toDoItems = toDoItems;
        this.dBhelper = dBhelper;
    }


    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_layout, null);
        ToDoViewHolder view = new ToDoViewHolder(itemView);
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder viewH, int position) {

        ToDoItem newItem = toDoItems.get(position);
        viewH.checkBox.setChecked(newItem.isChecked());
        viewH.checkBox.setText(newItem.getItem());
        viewH.dateBox.setText(newItem.getDate());

        viewH.checkBox.setOnCheckedChangeListener((v, checked)->{
            dBhelper.checkComplete(toDoItems.get(viewH.getAdapterPosition()).getID(),checked);
        });
    }

    @Override
    public int getItemCount() {
        return toDoItems.size();
    }

}