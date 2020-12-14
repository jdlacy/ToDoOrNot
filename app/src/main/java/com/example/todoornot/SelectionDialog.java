package com.example.todoornot;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;

public class SelectionDialog extends DialogFragment {
    private EditText itemText;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Add New ToDo");
        View dialogView = inflater.inflate((R.layout.activity_add_item, null);
        builder.setView(dialogView);

        this.itemText = dialogView.findViewById(R.id.addToDo);


        builder.setPositiveButton("Save", (dialog, which)->{
            String newItem = this.itemText.getText().toString();
            if (TextUtils.isEmpty(newItem)) {
                Toast.makeText(getContext(),"No ToDos entered. Please enter something first.", Toast.LENGTH_LONG);
                return;
            }
        });
    }

    public interface SelectionDialogListener {

    }
}
