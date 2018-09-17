package com.cmejia.minipi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    public TextView textoBienvenida;
    public TextView textoUsuario;
    public EditText nombreUsuario;
    public TextView textoPassword;
    public EditText passUsuario;
    public Button botonEnter;
    public TextView textoIngreso;

    public String bufNombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //textoBienvenida.findViewById(R.id.texto_bienvenida); NO UTILIZAR, crashea la app
        textoBienvenida = (TextView)findViewById(R.id.texto_bienvenida);
        textoUsuario = (TextView)findViewById(R.id.texto_usuario);
        nombreUsuario = (EditText)findViewById(R.id.nombre_usuario);
        textoPassword = (TextView)findViewById(R.id.texto_password);
        passUsuario = (EditText)findViewById(R.id.pass_usuario);
        botonEnter = (Button)findViewById(R.id.boton_enter);
        textoIngreso = (TextView)findViewById(R.id.texto_ingreso);

//        textoBienvenida.setText(R.string.str_bienvenida);
//        textoUsuario.setText(R.string.str_usuario);
//        nombreUsuario.setHint(R.string.str_hint_usuario);
//        textoPassword.setText(R.string.str_password);
//        passUsuario.setHint(R.string.str_hint_password);
//        botonEnter.setText(R.string.str_enter);

        botonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textoIngreso.setText(R.string.str_msj_enter);

                //NOTA: si no hay nada en el getText se crashea el programa. Se debe hacer una VERIFICACION
                bufNombreUsuario = nombreUsuario.getText().toString(); // hay que convertir porque getText devuelve un array de char

                // Instancia un intent para pasar a otra activity
                //Intent actConfig = new Intent(Login.this, Configuracion.class);
                Intent actConfig = new Intent(Login.this, InfoList.class);

                actConfig.putExtra("USUARIO", bufNombreUsuario); // envio datos a la otra activity con Intent

                //bufTextUser = Text_pass.getText().toString();
                //int1.putExtra("PASS",bufTextUser);

                startActivity(actConfig); // Inicio la otra activity

            }
        });

    }
}
