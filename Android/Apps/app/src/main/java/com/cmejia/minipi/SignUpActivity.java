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

public class SignUpActivity extends AppCompatActivity {

    public TextView title;
    public EditText userName;
    public EditText userPass;
    public EditText userEmail;
    public Button registerButton;

    public int stringLenUserName;
    public int stringLenUserPass;
    public int stringLenUserEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        title = findViewById(R.id.tittle);
        userName = findViewById(R.id.user_name);
        userPass = findViewById(R.id.user_pass);
        userEmail = findViewById(R.id.user_email);
        registerButton = findViewById(R.id.register_btn);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringLenUserName = userName.getText().length();
                stringLenUserPass = userPass.getText().length();
                stringLenUserEmail = userEmail.getText().length();

                if( stringLenUserName != 0 && stringLenUserPass != 0 && stringLenUserEmail != 0) {
                    // guardar en BBDD y checkear
                    finish();
                }
                else {
                    if( stringLenUserName == 0 ) {
                        userName.setHint("Ingrese su usuario");
                        userName.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                    if( stringLenUserPass == 0) {
                        userPass.setHint("Ingrese su contraseña");
                        userPass.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                    if( stringLenUserEmail == 0) {
                        userEmail.setHint("Ingrese su email");
                        userEmail.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                }

            }
        });
    }
}
