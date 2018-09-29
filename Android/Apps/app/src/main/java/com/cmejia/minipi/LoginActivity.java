package com.cmejia.minipi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    public TextView tittle;
    public EditText userName;
    public EditText userPass;
    public Button loginButton;
    public TextView textSignUp;

    public int userNameSize;
    public int userPassSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //textoBienvenida.findViewById(R.id.texto_bienvenida); NO UTILIZAR, crashea la app
        tittle = findViewById(R.id.tittle);
        userName = findViewById(R.id.user_name);
        userPass = findViewById(R.id.user_pass);
        loginButton = findViewById(R.id.login_btn);
        textSignUp = findViewById(R.id.sign_up);

        // Crea el archivo de preferencias "UserPreferences" si no existe
        final SharedPreferences preferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NOTA: si no hay nada en el getText se crashea el programa. Se debe hacer una VERIFICACION
                userNameSize = userName.getText().length();
                userPassSize = userPass.getText().length();
                if( userNameSize != 0 && userPassSize != 0 ) {
                    // Instancia un intent para pasar a otra activity
                    Intent nextActInfoList = new Intent(LoginActivity.this, InfoListActivity.class);
                    //dataBuffer = userName.getText().toString(); // hay que convertir porque getText devuelve un array de char

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("user", userName.getText().toString());
                    editor.commit();

                    startActivity(nextActInfoList); // Inicio la otra activity
                    finish();
                }
                else {
                    if( userNameSize == 0 ) {
                        userName.setHint("Ingrese su usuario");
                        userName.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                    if( userPassSize == 0) {
                        userPass.setHint("Ingrese su contraseña");
                        userPass.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                }
            }
        });

        textSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                // Clear a los campos EditText user y pass
                userName.setText("");
                userPass.setText("");
                startActivity(nextActSignUp);
            }
        });
    }
}
