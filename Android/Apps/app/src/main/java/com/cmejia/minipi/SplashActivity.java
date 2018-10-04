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
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import clases.UserSQLite;

public class SplashActivity extends AppCompatActivity {

    public ProgressBar progressBar;
    private final long splash_screen_delay = 3000;  // tiempo que el splash screen se muestra [ms]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);


        //Nos aseguramos de que existe al menos un registro
            //if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                //do {
                 //   String codigo= c.getString(0);
                //    String nombre = c.getString(1);

              //  } while(c.moveToNext());
            //}
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
