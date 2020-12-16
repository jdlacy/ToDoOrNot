package com.example.todoornot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemList;
    private Button add;
    private ListDBhelper dBhelper;
    private ToDoAdapter adapter;
    private ArrayList<ToDoItem> db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddItemActivity.class);
        add = findViewById(R.id.addToDo);
        add.setOnClickListener((view)->startActivity(intent));

        itemList = findViewById(R.id.item_list);
    }

    @Override
    protected void onResume() {
        super.onResume();

        dBhelper = new ListDBhelper(getApplicationContext(),
                ListDBhelper.DATABASE_NAME,
                null,
                1);

        db = dBhelper.getItems();
        adapter = new ToDoAdapter(db, dBhelper);

        itemList.setAdapter(adapter);
        itemList.setLayoutManager(new LinearLayoutManager(this));

    }
}