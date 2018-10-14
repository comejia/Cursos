package com.cmejia.minipi;

import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import clases.BookSQLite;

public class SplashActivity extends AppCompatActivity {

    public ProgressBar progressBar;
    private final long splash_screen_delay = 3000;  // tiempo que el splash screen se muestra [ms]

    public SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        final BookSQLite bookdb = new BookSQLite(this, "DBBook.db", null, 1);
        db = bookdb.getWritableDatabase(); // Referencia a userdb para modificacion

        Cursor c = db.query("BookTable", null, null,
                null,null, null, null);

        if(!c.moveToFirst()) { // Si no existe ningun registro, entonces cargar la base de datos
            ContentValues register = new ContentValues();
            register.put("bookName", "Electromagnetismo");
            register.put("subject", "Medios de enlace");
            register.put("details", "Libro con los fundamentos de Electromagnetismo");
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "Ing de Control Moderno");
            register.put("subject", "Sistemas de Control");
            register.put("details", "Enfoque principal en compensacion de sistemas");
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "SGOliver");
            register.put("subject", "Dispositivos moviles");
            register.put("details", "Enlace con informacion basada en la cursada");
            db.insert("BookTable", null, register); // inserta un registro

            c.close();
            db.close(); // Cierra la base de datos
        }

        //else {
            //}
            //String selection = "username" + " LIKE ?";
            // Specify arguments in placeholder order.
            //String[] selectionArgs = { "cesarmejia" };
            //int delete = db.delete("UserDataTable", "username=?", selectionArgs);


        // Se crea la tarea a ejecutar
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Seteo la activity que se va a mostrar despues del splash screen
                Intent nextActLogin =  new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(nextActLogin);

                finish(); // Destruyo la activity para que no se vuelva a mostrar al tocar el boton back
            }
        };
        // Creo un timer y agrego la tarea al scheduler
        Timer timer = new Timer();
        timer.schedule(task, splash_screen_delay);

    }

}
