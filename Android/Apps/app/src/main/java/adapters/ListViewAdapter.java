package adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import clases.Library;
import com.cmejia.minipi.R;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<Library> {
    private List<Library> list;
    public ListViewAdapter(Context context, List<Library> data) {
        super(context, R.layout.list_view_items, data);
        this.list = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View v = inflater.inflate(R.layout.list_view_items, null);

        TextView name = v.findViewById(R.id.book_name);
        name.setText(list.get(position).getBookName());
        //name.setText(super.getItem(position).getBookName());

        TextView subject = v.findViewById(R.id.subject);
        subject.setText(list.get(position).getSubject());
        //subject.setText(super.getItem(position).getSubject());

        //return super.getView(position, convertView, parent);
        return v;
    }
}
