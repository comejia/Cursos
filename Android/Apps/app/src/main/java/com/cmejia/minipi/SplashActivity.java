package com.cmejia.minipi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    public ProgressBar progressBar;
    private final long splash_screen_delay = 3000;  // tiempo que el splash screen se muestra [ms]

    int progress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);
        //CARGAR BBDD

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
