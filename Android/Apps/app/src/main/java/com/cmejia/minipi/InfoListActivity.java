package com.cmejia.minipi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

import adapters.ListViewAdapter;
import clases.BookSQLite;
import clases.Library;

public class InfoListActivity extends AppCompatActivity {

    public ListView myListView;
    public TextView welcomeMsg;
    public Toolbar toolbar;

    public SQLiteDatabase db;
    public ListViewAdapter adapter;

    public List<Library> info;
    public int positionID;
    public boolean itemEditFlag = false;
    public String changedBookID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);

        myListView = findViewById(R.id.info_list);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar); // Indica que toolbar va a ser la ActionBar de la activity

        registerForContextMenu(myListView); // Enlaza el menu contextual al ListView

        // Levanta info de la base de datos y lo pasa a Library como parametros
        final BookSQLite bookdb = new BookSQLite(this, "DBBook.db", null, 1);
        db = bookdb.getWritableDatabase(); // Referencia a userdb para modificacion
        Cursor c = db.query("BookTable", null, null, // Pregunto por todos los registros
                null,null, null, null);

        // Instancio los objetos que se van a mostrar en el ListView a mano
        /*Library[] info = new Library[] {
                new Library("Electromagnetismo", "Medios de enlace", "Libro con los fundamentos de Electromagnetismo"),
                new Library("Ing de Control Moderno", "Sistemas de Control", "Enfoque principal en compensacion de sistemas"),
                new Library("SGOliver", "Dispositivos moviles", "Enlace con informacion basada en la cursada")
        };*/

        // Instancio los objetos que se van a mostrar en el ListView a partir de la base de datos
        info = new ArrayList<>();
        if (c.moveToFirst()) { // Nos aseguramos de que existe al menos un registro
            do { //Recorremos el cursor hasta que no haya más registros
                String book= c.getString(0);
                String subject = c.getString(1);
                String details = c.getString(2);
                info.add(new Library(book, subject, details));
            } while(c.moveToNext());
            c.close();
        }
        setupListViewAdapter(info); // Creo el adapter a traves del metodo
        // Creo el adapter personalizado
        //ListViewAdapter myAdapter = new ListViewAdapter(this, info);
        //myListView.setAdapter(myAdapter); // Enlaza el ListView al adapter
        //adapter = myAdapter;

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
        if( !user.equals("nombre") ) {
            String buffer = "Bienvenido: " + user;
            welcomeMsg.setText(buffer);
        }
    }
    private void setupListViewAdapter(List<Library> list) {
        this.adapter = new ListViewAdapter(this, list);
        myListView.setAdapter(adapter); // Enlaza el ListView al adapter
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if(itemEditFlag) {
            int cantChange = 0;

            ContentValues register = new ContentValues();
            SharedPreferences preferences = getSharedPreferences("UpdateBookDB", Context.MODE_PRIVATE);
            String book = preferences.getString("bookName","not_data");
            String subject = preferences.getString("subject", "not_data");
            String details = preferences.getString("details", "not_data");

            Library item = info.get(positionID); // Obteno el item Library que se modifico

            if( !book.isEmpty() ) {
                register.put("bookName", book);
                item.setBookName(book);
                cantChange++;
            }
            if( !subject.isEmpty() ) {
                register.put("subject", subject);
                item.setSubject(subject);
                cantChange++;
            }
            if( !details.isEmpty() ) {
                register.put("details", details);
                item.setDetails(details);
                cantChange++;
            }

            if( cantChange > 0 ) {
                info.set(positionID, item); // Actualiza el item modificado en la ListView
                adapter.notifyDataSetChanged(); // Notifica el cambio

                String[] args = new String[] {changedBookID}; // Actualiza la base de datos
                db.update("BookTable", register, "bookName=?", args);
            }

            changedBookID = "";
            itemEditFlag = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    // *********** Menu de la Toolbar **************************
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
                break;
            case R.id.action_settings:
                Intent nextActSettings = new Intent(InfoListActivity.this, SettingsActivity.class);
                startActivity(nextActSettings);
                break;
            case R.id.action_search:
                // implementar una busqueda
                break;
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

    // *********** Menu Contextual **************************
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menu = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        positionID = menu.position;
        changedBookID = (adapter.getItem(positionID)).getBookName(); // Obtengo el "id" del registro que se va a borrar o editar
        switch (item.getItemId()) {
            case R.id.op_edit: // Abre una activity para editar datos del item de la ListView
                itemEditFlag = true;
                welcomeMsg.setText("EDIT" + changedBookID);
                Intent nextActEdit = new Intent(InfoListActivity.this, EditActivity.class);
                startActivity(nextActEdit);
                return true;

            case R.id.op_delete:
                // Elimina un item de la ListView. NOTA: automaticamente se elimina un item de List info!!!
                adapter.remove(adapter.getItem(positionID)); // Elimina el item
                adapter.notifyDataSetChanged(); // Actuliza la ListView

                // Elimina un registro de la base de datos
                String[] args = new String[] {changedBookID};
                db.delete("BookTable", "bookName=?", args); // Elimina el registro
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
