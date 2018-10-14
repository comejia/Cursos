package com.cmejia.minipi;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import clases.BookSQLite;

public class EditActivity extends AppCompatActivity {

    public String id;
    public EditText book;
    public EditText subject;
    public EditText details;
    public Button editButton;
    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        book = findViewById(R.id.input_book_edit);
        subject = findViewById(R.id.input_subject_edit);
        details = findViewById(R.id.input_details_edit);
        editButton = findViewById(R.id.edit_button);

        id = getIntent().getStringExtra("ID");
        if(!id.isEmpty())
            details.setText("VACIOOO");

        BookSQLite bookdb = new BookSQLite(this, "DBBook.db", null, 1);
        db = bookdb.getWritableDatabase(); // Referencia a userdb para modificacion

        final Intent intent = new Intent(EditActivity.this, InfoListActivity.class);

        intent.putExtra("VERDATOS","cesar");
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues register = new ContentValues();

                if( book.getText().length() != 0 ) {
                    register.put("bookName", book.getText().toString());
                }
                if( subject.getText().length() != 0 ) {
                    register.put("subject", subject.getText().toString());
                }
                if( details.getText().length() != 0 ) {
                    register.put("details", details.getText().toString());
                }

                String[] args = new String[] {id};
                db.update("BookTable", register, "bookName=?", args);

                db.close();
                finish();
            }
        });

    }
}

