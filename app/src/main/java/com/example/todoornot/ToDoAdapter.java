package com.example.todoornot;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoViewHolder> {

    private ArrayList<ToDoItem> toDoItems;
    private FragmentManager fragmentManager;
    private TextView textView;
    private ListDBhelper dBhelper;

    public ToDoAdapter(ArrayList<ToDoItem> toDoItems,
                       FragmentManager fragmentManager,
                       TextView textView,
                       ListDBhelper dBhelper) {
        this.toDoItems = toDoItems;
        this.fragmentManager = fragmentManager;
        this.textView = textView;
        this.dBhelper = dBhelper;
    }


    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_layout, null);
        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder viewH, int position) {

        ToDoItem newItem = toDoItems.get(position);
        viewH.checkBox.setChecked(newItem.isChecked());
        viewH.toDoText.setText(newItem.getItem());
        viewH.dateText.setText(newItem.getDate());

        SelectionDialog sD = new SelectionDialog();
        viewH.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("to_do_item", toDoItems.get(position).getItem());
            sD.setArguments(bundle);
            sD.show(fragmentManager, "ToDos");
            return position == 1;
        });
    }

    @Override
    public int getItemCount() {
        return toDoItems.size();
    }


}