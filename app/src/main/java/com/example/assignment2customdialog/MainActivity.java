package com.example.assignment2customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextEditorDialog.OnTextEditedListener {

    Button openDialogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       openDialogBtn = findViewById(R.id.openDialogBtn);

       openDialogBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
            TextEditorDialog dialog = new TextEditorDialog(MainActivity.this, "initial Text", MainActivity.this);
            dialog.show();
           }
       });
    }

    @Override
    public void onTextEdited(String editedText) {
        Toast.makeText(this, "Edited Text" + editedText, Toast.LENGTH_LONG).show();
    }
}