package com.fp.listview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ImageView add;
    private KontakAdapter kAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

        add = (ImageView) findViewById(R.id.listView);
        add.setOnClickListener(operasi);

        ArrayList<Kontak> listKontak = new ArrayList<Kontak>();
        kAdapter = new kontakAdapter(this, 0, listKontak);
        lv.setAdapter(kAdapter);

//        Kontak newKontak1 = new Kontak("budi", "081111");
//        Kontak newKontak2 = new Kontak("agus", "082222");
//        kAdapter.add(newKontak1);
//        kAdapter.add(newKontak2);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tambah) {
                tambah_data();
            }
        }
    };

    private void tambah_data()
    {
        AlertDialog.Builder buat = new AlertDialog.Builder(this);
        buat.setTitle("Add Kontak");
    }
    private void add_item(String nm, String hp)
    {
        Kontak newKontak = new Kontak(nm, hp);
        kAdapter.add(newKontak);
    }
}