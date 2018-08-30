package com.cmejia.minipi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Configuracion extends AppCompatActivity {

    public TextView textoHola;
    public TextView textoDatoUsuario;

    public String bufDatoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        textoHola = (TextView)findViewById(R.id.texto_hola);
        textoDatoUsuario = (TextView)findViewById(R.id.dato_usuario);

        textoHola.setText(R.string.str_saludo_usuario);
        bufDatoUsuario = getIntent().getStringExtra("USUARIO");
        textoDatoUsuario.setText(bufDatoUsuario);

    }
}
