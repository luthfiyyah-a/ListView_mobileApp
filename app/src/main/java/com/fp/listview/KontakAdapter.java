package com.fp.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

import java.util.List;

public class KontakAdapter extends ArrayAdapter<Kontak> {

    private static class ViewHolder {
        TextView nama;
        TextView nohp;
        ImageView img;
    }
    public KontakAdapter(@NonNull Context context, int resource, @NonNull List<Kontak> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View ConvertView, ViewGroup parent) {
        Kontak dtkontak = getItem(position);

        ViewHolder viewKontak;

        if(ConvertView == null) {
            viewKontak = new ViewHolder();
            ConvertView = LayoutInflater.from(getContext()).inflate(R.layout.item_kontak, parent, false);
            viewKontak.nama = (TextView) ConvertView.findViewById(R.id.tNama);
            viewKontak.nohp = (TextView) ConvertView.findViewById(R.id.tnoHP);
            viewKontak.img = (ImageView) ConvertView.findViewById(R.id.img);

            ConvertView.setTag(viewKontak);

            Button btn = (Button) ConvertView.findViewById(R.id.btn);
            btn.setTag(position);
            btn.setOnClickListener(op);
        }
        else {
            viewKontak = (ViewHolder) ConvertView.getTag();
        }

        viewKontak.nama.setText(dtkontak.getNama());
        viewKontak.nohp.setText(dtkontak.getNoHP());

        return ConvertView;
    }
}
