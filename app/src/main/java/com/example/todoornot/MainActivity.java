package com.example.todoornot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddItemActivity.class);
        Button button = findViewById(R.id.addToDo);
        button.setOnClickListener((view)->startActivity(intent));
        itemList = findViewById(R.id.item_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListDBhelper ldbh = new ListDBhelper(this, ListDBhelper.DATABASE_NAME, null, 1);
    }
}