package com.cmejia.minipi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import clases.UserSQLite;

public class SignUpActivity extends AppCompatActivity {

    public TextView title;
    public EditText userName;
    public EditText userPass;
    public EditText userEmail;
    public Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        title = findViewById(R.id.tittle);
        userName = findViewById(R.id.user_name);
        userPass = findViewById(R.id.user_pass);
        userEmail = findViewById(R.id.user_email);
        registerButton = findViewById(R.id.register_btn);

        // Abre la base de datos, la crea si no existe. EL NOMBRE DE LA BASE DE DATOS DEBE TERMINAR EN .db !!!!
        final UserSQLite userdb = new UserSQLite(this, "DBUsers.db", null, 1);
        final SQLiteDatabase db = userdb.getWritableDatabase(); // Referencia a userdb para modificacion

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userNameSize = userName.getText().length();
                int userPasswordSize = userPass.getText().length();
                int userEmailSize = userEmail.getText().length();

                if( userNameSize != 0 && userPasswordSize != 0 && userEmailSize != 0 ) { // guardar en BBDD y checkear
                    String user = userName.getText().toString();
                    String pass = userPass.getText().toString();
                    String email = userEmail.getText().toString();

                    String[] col = new String[] {"username"};
                    String[] args = new String[] {user};
                    Cursor c = db.query("UserDataTable", col, "username=?",
                            args,null, null, null);

                    if(c.moveToFirst()) { // Si existe algun registro, existe el usuario!
                        // Mostrar dialog con error "El usuario ya existe"
                        userName.setText("");
                    }
                    else { // Agregar usuario a la base de datos
                        ContentValues register = new ContentValues();
                        register.put("username", user);
                        register.put("pass", pass);
                        register.put("email", email);

                        long id = db.insert("UserDataTable", null, register); // inserta un registro
                        if(id == -1) { // Error al insertar registro
                            // Mostrar dialog indicando el error
                        }
                        c.close();
                        db.close(); // Cierra la base de datos
                        finish();
                    }
                }
                else {
                    // UTILZAR UN DIALOG PARA MOSTRAR ERROR: complete todos los campos
                    if( userNameSize == 0 ) {
                        userName.setHint("Ingrese su usuario");
                        userName.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                    if( userPasswordSize == 0) {
                        userPass.setHint("Ingrese su contraseña");
                        userPass.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                    if( userEmailSize == 0) {
                        userEmail.setHint("Ingrese su email");
                        userEmail.setHintTextColor(getResources().getColor(R.color.colorCompleteInputLogin));
                    }
                }

            }
        });
    }
}
