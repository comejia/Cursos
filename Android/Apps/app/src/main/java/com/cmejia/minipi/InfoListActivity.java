package com.cmejia.minipi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import adapters.ListViewAdapter;
import clases.Library;

public class InfoListActivity extends AppCompatActivity {

    public ListView myListView;
    public TextView welcomeMsg;

    public ImageView settingsImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        myListView = findViewById(R.id.info_list);
        settingsImg = findViewById(R.id.settings_img);

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

        settingsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextActSettings = new Intent(InfoListActivity.this, SettingsActivity.class);
                startActivity(nextActSettings);
            }
        });

        // Prueba SharedPreferences
        welcomeMsg = findViewById(R.id.welcome_msg);
        SharedPreferences preferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        String user = preferences.getString("user","nombre");
        if(!user.equals("nombre")) {
            String buffer = "Bienvenido: " + user;
            welcomeMsg.setText(buffer);
        }
    }
}
