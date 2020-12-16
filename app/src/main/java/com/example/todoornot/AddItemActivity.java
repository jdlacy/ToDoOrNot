package com.example.todoornot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    DatePickerDialog datePicker;
    Button dateButton;
    EditText newToDoText;
    Button saveButton;
    Button cancelButton;
    String date;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        ListDBhelper db = new ListDBhelper(this, ListDBhelper.DATABASE_NAME, null, 1);

        newToDoText = findViewById(R.id.addToDoText);
        dateButton = findViewById(R.id.date_button);
        saveButton = findViewById(R.id.save_button);
        cancelButton = findViewById(R.id.cancel_button);

        dateButton.setOnClickListener(view -> datePicker.show());
        cancelButton.setOnClickListener(view -> onBackPressed());

        datePicker = new DatePickerDialog(this);
        datePicker.setOnDateSetListener((view, year, month, dayOfMonth) -> {
            Toast.makeText(getApplicationContext(), String.format("%02d/%02d/%02d selected", month + 1, dayOfMonth, year), Toast.LENGTH_LONG).show();
        });


        saveButton.setOnClickListener((view) -> {
            String text = newToDoText.getText().toString();

            String date = "sample";

            if ((TextUtils.isEmpty(text)) || (TextUtils.isEmpty(date))) {
                Toast.makeText(this, "Please enter something", Toast.LENGTH_SHORT).show();
            } else {
                db.newTask(text, date);
                onBackPressed();
                Toast.makeText(this, "New Task Added Successfully!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}