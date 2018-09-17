package com.cmejia.minipi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class InfoList extends AppCompatActivity {

    public ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        myList = findViewById(R.id.info_list);

        Mascotas[] datos = new Mascotas[] {
                new Mascotas("Tobias","Callejero"),
                new Mascotas("Olivia", "Galgo"),
        };

        Adaptador miAdapter = new Adaptador(this, datos);
        myList.setAdapter(miAdapter);
    }
}
