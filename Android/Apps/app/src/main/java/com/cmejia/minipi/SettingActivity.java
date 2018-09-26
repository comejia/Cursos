package com.cmejia.minipi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    public TextView textoHola;
    public TextView textoDatoUsuario;
    public Button botonColor;
    public Button botonIncrementar;
    public Button botonDecrementar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textoHola = (TextView)findViewById(R.id.texto_hola);
        textoDatoUsuario = (TextView)findViewById(R.id.dato_usuario);
        botonColor = (Button)findViewById(R.id.boton_color);
        botonIncrementar = (Button)findViewById(R.id.boton_incrementar);
        botonDecrementar = (Button)findViewById(R.id.boton_decrementar);

        textoHola.setText(R.string.str_saludo_usuario);


        botonColor.setText(R.string.str_boton_color);
        //botonColor.setTextSize();
        botonIncrementar.setText(R.string.str_boton_incrementar);
        botonDecrementar.setText(R.string.str_boton_decrementar);


        botonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoDatoUsuario.setTextColor(Color.rgb(200,0,0));
            }
        });

        botonIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoDatoUsuario.setTextSize(20);
            }
        });

        botonDecrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoDatoUsuario.setTextSize(10);
            }
        });


    }
}
