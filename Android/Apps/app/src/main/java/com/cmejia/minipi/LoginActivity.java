package com.cmejia.minipi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public TextView appName;
    public TextView userText;
    public EditText userName;
    public TextView passText;
    public EditText userPass;
    public Button loginBtn;

    public String userNameBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //textoBienvenida.findViewById(R.id.texto_bienvenida); NO UTILIZAR, crashea la app
        appName = (TextView)findViewById(R.id.app_name);
        userText = (TextView)findViewById(R.id.user_text);
        userName = (EditText)findViewById(R.id.user_name);
        passText = (TextView)findViewById(R.id.pass_text);
        userPass = (EditText)findViewById(R.id.user_pass);
        loginBtn = (Button)findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //NOTA: si no hay nada en el getText se crashea el programa. Se debe hacer una VERIFICACION
                userNameBuffer = userName.getText().toString(); // hay que convertir porque getText devuelve un array de char

                // Instancia un intent para pasar a otra activity
                //Intent actConfig = new Intent(LoginActivity.this, Configuracion.class);
                Intent actConfig = new Intent(LoginActivity.this, InfoList.class);

                actConfig.putExtra("USUARIO", userNameBuffer); // envio datos a la otra activity con Intent

                //bufTextUser = Text_pass.getText().toString();
                //int1.putExtra("PASS",bufTextUser);

                startActivity(actConfig); // Inicio la otra activity

            }
        });

    }
}
