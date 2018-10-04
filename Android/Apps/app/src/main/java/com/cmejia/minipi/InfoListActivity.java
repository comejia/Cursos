package com.cmejia.minipi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


import adapters.ListViewAdapter;
import clases.Library;

public class InfoListActivity extends AppCompatActivity {

    public ListView myListView;
    public TextView welcomeMsg;

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        myListView = findViewById(R.id.info_list);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar); // Indica que toolbar va a ser la ActionBar de la activity

        // Instancio los objetos que se van a mostrar
        Library[] info = new Library[] {
                new Library("Electromagnetismo", "Medios de enlace", "Libro con los fundamentos de Electromagnetismo"),
                new Library("Ing de Control Moderno", "Sistemas de Control", "Enfoque principal en compensacion de sistemas"),
                new Library("SGOliver", "Dispositivos moviles", "Enlace con informacion basada en la cursada")
        };

        // Creo el adapter personalizado
        ListViewAdapter myAdapter = new ListViewAdapter(this, info);
        myListView.setAdapter(myAdapter); // Enlaza el ListView al adapter

        //myListView.setOnItemSelectedListener(); DIFERENCIA??!!!
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String detail = ((Library)parent.getItemAtPosition(position)).getDetails();

                Intent nextActDetails = new Intent(InfoListActivity.this, DetailsActivity.class);
                nextActDetails.putExtra("DETALLES", detail); // envio datos a la otra activity con Intent
                startActivity(nextActDetails);
            }
        });

        // TESTING SharedPreferences
        welcomeMsg = findViewById(R.id.welcome_msg);
        SharedPreferences preferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        String user = preferences.getString("user","nombre");
        if(!user.equals("nombre")) {
            String buffer = "Bienvenido: " + user;
            welcomeMsg.setText(buffer);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Genera el menu que se ve en la Toolbar
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Metodo para realizar una accion al tocar algun icono
        switch (item.getItemId()) {
            case R.id.action_add:
                // agregar activity de Anadir item
                return true;
            case R.id.action_settings:
                Intent nextActSettings = new Intent(InfoListActivity.this, SettingsActivity.class);
                startActivity(nextActSettings);
                return true;
            case R.id.action_search:
                // implementar una busqueda
                return true;
            case R.id.action_log_out:
                Intent nextActLogin = new Intent(InfoListActivity.this, LoginActivity.class);
                startActivity(nextActLogin);
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
