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
    private final long splash_screen_delay = 1000;  // tiempo que el splash screen se muestra [ms]

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
            register.put("imageID", R.drawable.electromagnetismo);
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "Ing de Control Moderno");
            register.put("subject", "Sistemas de Control");
            register.put("details", "Enfoque principal en compensacion de sistemas");
            register.put("imageID", R.drawable.control_moderno);
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "SGOliver");
            register.put("subject", "Dispositivos moviles");
            register.put("details", "Enlace con informacion basada en la cursada");
            register.put("imageID", R.drawable.soliver);
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "Dispositivos electronicos");
            register.put("subject", "Dispositivos electronicos");
            register.put("details", "Teoria sobre fisica de semiconductores. Este libro cubre hasta mosfet");
            register.put("imageID", R.drawable.dispositivos_electronicos);
            db.insert("BookTable", null, register); // inserta un registro

            register.put("bookName", "Maquinas electricas");
            register.put("subject", "Maquinas e Instalaciones electricas");
            register.put("details", "Este libro cubre la primera parte de la materia");
            register.put("imageID", R.drawable.maquinas_electricas);
            db.insert("BookTable", null, register); // inserta un registro


            c.close();
        }
        /*String args[] = new String[] {"Dispositivos moviles"};
        ContentValues register = new ContentValues();
        register.put("details", "Enlace con informacion basada en la cursada");
        db.update("BookTable", register, "subject=?", args);*/


        //String[] args = { "Ing de Control Moderno", "Electromagnetismo" };
        //int delete = db.delete("BookTable", "bookName=? OR bookName=?", args);


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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
