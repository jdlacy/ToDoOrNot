package com.example.todoornot;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager;
=======
>>>>>>> 87389aee57c334f5f1a948f740afe6cf9e0bee0a
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
<<<<<<< HEAD
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
=======

import java.util.ArrayList;
>>>>>>> 87389aee57c334f5f1a948f740afe6cf9e0bee0a

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemList;
<<<<<<< HEAD
    private Button add;
    private ListDBhelper dBhelper;
    private ToDoAdapter adapter;
    private ArrayList<ToDoItem> db;

=======
>>>>>>> 87389aee57c334f5f1a948f740afe6cf9e0bee0a

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AddItemActivity.class);
<<<<<<< HEAD
        add = findViewById(R.id.addToDo);
        add.setOnClickListener((view)->startActivity(intent));

=======
        Button button = findViewById(R.id.addToDo);
        button.setOnClickListener((view)->startActivity(intent));
>>>>>>> 87389aee57c334f5f1a948f740afe6cf9e0bee0a
        itemList = findViewById(R.id.item_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
<<<<<<< HEAD

        dBhelper = new ListDBhelper(getApplicationContext(),
                ListDBhelper.DATABASE_NAME,
                null,
                1);

        db = dBhelper.getItems();
        adapter = new ToDoAdapter(db, dBhelper);

        itemList.setAdapter(adapter);
        itemList.setLayoutManager(new LinearLayoutManager(this));

=======
        ListDBhelper ldbh = new ListDBhelper(this, ListDBhelper.DATABASE_NAME, null, 1);
>>>>>>> 87389aee57c334f5f1a948f740afe6cf9e0bee0a
    }
}