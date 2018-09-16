package com.cmejia.minipi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Configuracion extends AppCompatActivity {

    public TextView textoHola;
    public TextView textoDatoUsuario;
    public Button botonColor;
    public Button botonIncrementar;
    public Button botonDecrementar;

    public Spinner spinnerData;

    public String bufDatoUsuario;


    public TextView debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        textoHola = (TextView)findViewById(R.id.texto_hola);
        textoDatoUsuario = (TextView)findViewById(R.id.dato_usuario);
        botonColor = (Button)findViewById(R.id.boton_color);
        botonIncrementar = (Button)findViewById(R.id.boton_incrementar);
        botonDecrementar = (Button)findViewById(R.id.boton_decrementar);
        spinnerData = (Spinner)findViewById(R.id.spinner_data);

        textoHola.setText(R.string.str_saludo_usuario);
        bufDatoUsuario = getIntent().getStringExtra("USUARIO");
        textoDatoUsuario.setText(bufDatoUsuario);

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


        debug = (TextView)findViewById(R.id.debug);


        // Creacion del adaptador con los strings desde el xml
        ArrayAdapter <CharSequence> adaptador =
                ArrayAdapter.createFromResource(this, R.array.datos_array, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // define como muestra los items

        spinnerData.setAdapter(adaptador); // setea el adaptador al spinner

        spinnerData.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                debug.setText("Seleccionado " + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                debug.setText("");
            }
        });


        // usar listening
        //adaptador = setD

    }
}
