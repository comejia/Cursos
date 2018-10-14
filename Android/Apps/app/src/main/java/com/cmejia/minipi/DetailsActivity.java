package com.cmejia.minipi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import adapters.ViewPagerAdapter;
import fragments.Tab1Fragment;
import fragments.Tab2Fragment;

public class DetailsActivity extends AppCompatActivity {

    public TextView info;
    public Spinner options;

    public ViewPager viewPager;
    public TabLayout tabs;

    public TextView debug;

    public String infoBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        info = findViewById(R.id.info);
        options = findViewById(R.id.options);
        viewPager = findViewById(R.id.detail_pager);
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

        // AGREGADO DE FRAGMENTS Y TABS
        setupViewPager(viewPager);
        tabs.setupWithViewPager(viewPager); // Comunica los tabs con los fragments
        //tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tabs.setTabGravity(TabLayout.GRAVITY_FILL);


    }

    // Metodo para agregar fragments al ViewPager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // getChildFragmentManager() usar esto cuando se tiene un fragment dentro de otro fragment
        // getSupportFragmentManager() usar esto cuando tengo un fragment dentro de una activity

        adapter.addFragment(new Tab1Fragment(), "MENU 1");
        adapter.addFragment(new Tab2Fragment(), "MENU 2");
        //adapter.addFragment(new User_Credential_Fragment(), "Credencial");

        viewPager.setAdapter(adapter);
    }

}

