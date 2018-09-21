package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import clases.Mascotas;
import com.cmejia.minipi.R;


public class Adaptador extends ArrayAdapter<Mascotas> {
    Mascotas[] listData;
    public Adaptador(Context context, Mascotas[] datos) {
        super(context, R.layout.item_list, datos);
        listData = datos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_list, null);

        TextView name = item.findViewById(R.id.name_view);
        name.setText(listData[position].getName());

        TextView raza = item.findViewById(R.id.raza_view);
        raza.setText(listData[position].getRaza());

        //return super.getView(position, convertView, parent);
        return item;
    }
}
