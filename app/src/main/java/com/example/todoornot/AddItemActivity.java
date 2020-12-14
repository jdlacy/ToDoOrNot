package com.example.todoornot;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity implements SelectionDialog.SelectionDialogListener {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        DatePickerDialog dP = new DatePickerDialog(this);
        dP.setOnDateSetListener((view, year, month, dayOfMonth) -> Toast.makeText(
                getApplicationContext(),
                String.format("%02d/%02d/%d selected", month, dayOfMonth, year), Toast.LENGTH_LONG).show());
        dP.setCancelable(false);
    }
}