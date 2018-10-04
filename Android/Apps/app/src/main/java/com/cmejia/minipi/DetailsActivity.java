package com.cmejia.minipi;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public TextView info;
    public Spinner options;
    public TabLayout tabs;

    public TextView debug;

    public String infoBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        info = findViewById(R.id.info);
        options = findViewById(R.id.options);
        tabs = findViewById(R.id.tabs);

        debug = findViewById(R.id.debug);


        // Obtengo la informacion pasada por la activity InfoList
        infoBuffer = getIntent().getStringExtra("DETALLES");
        info.setText(infoBuffer);

        // Creacion del adaptador con los strings desde el xml
        ArrayAdapter<CharSequence> adaptador =
                ArrayAdapter.createFromResource(this, R.array.datos_array, android.R.layout.simple_spinner_item);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // define como muestra los items

        options.setAdapter(adaptador); // setea el adaptador al spinner

        options.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                debug.setText("Seleccionado " + parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                debug.setText("");
            }
        });

        tabs.addTab(tabs.newTab().setText("TAB 1"));
        tabs.addTab(tabs.newTab().setText("TAB 2"));
        tabs.addTab(tabs.newTab().setText("TAB 3"));
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setTabGravity(TabLayout.GRAVITY_CENTER);

    }
}
