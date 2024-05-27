package com.example.assignment2customdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class TextEditorDialog extends Dialog {
    EditText edtText;
    CheckBox btnUpperCase, btnLowerCase, btnInitCap,btnReverse;
    Button btnCancel,btnSubmit;
    private String initialText;
    private OnTextEditedListener listener;

    public interface OnTextEditedListener {
        void onTextEdited(String editedText);
    }
    public TextEditorDialog(@NonNull Context context, String initialText, OnTextEditedListener listener) {
        super(context);
        this.initialText = initialText;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_text_editor);

         edtText = findViewById(R.id.edtText);
         btnUpperCase = findViewById(R.id.btnUpperCase);
         btnLowerCase = findViewById(R.id.btnLowerCase);
         btnInitCap = findViewById(R.id.btnInitCap);
         btnReverse = findViewById(R.id.btnReverse);
         btnCancel = findViewById(R.id.btnCancel);
         btnSubmit = findViewById(R.id.btnSubmit);

       btnUpperCase.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              edtText.setText(edtText.getText().toString().toUpperCase());
           }
       });

       btnLowerCase.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               edtText.setText(edtText.getText().toString().toLowerCase());
           }
       });

       btnReverse.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               edtText.setText(new StringBuilder(edtText.getText().toString()).reverse().toString());
           }
       });

       btnInitCap.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               edtText.setText(toInitCap(edtText.getText().toString()));
           }

       });

       btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             if(listener != null){
             listener.onTextEdited(edtText.getText().toString());
             }
             dismiss();
           }
       });

       btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
             dismiss();
           }
       });
    }
    private String toInitCap(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
}
