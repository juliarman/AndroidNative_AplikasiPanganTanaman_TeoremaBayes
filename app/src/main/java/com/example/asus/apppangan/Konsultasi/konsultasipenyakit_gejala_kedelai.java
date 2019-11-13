package com.example.asus.apppangan.Konsultasi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.apppangan.DBHelper;
import com.example.asus.apppangan.Konsultasi.hasil_konsultasi_kedelai;
import com.example.asus.apppangan.R;

public class konsultasipenyakit_gejala_kedelai extends AppCompatActivity {

    ListAdapter adapter;
    Cursor cursor;
    String[] daftar;
    ListView listgejalanya;
    DBHelper databasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasipenyakit_gejala_kedelai);


        this.listgejalanya = (ListView) findViewById(R.id.listviewnya_gejalaa);
        this.databasena = new DBHelper(this);
        this.cursor = this.databasena.getReadableDatabase().rawQuery("SELECT * FROM gejalakedelai ORDER BY id_gejala ASC", null);
        this.daftar = new String[this.cursor.getCount()];

        this.cursor.moveToFirst();

        for (int cc = 0; cc < this.cursor.getCount(); cc++){

            this.cursor.moveToPosition(cc);
            this.daftar[cc] = this.cursor.getString(1);
        }

        this.adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice,this.daftar);

        this.listgejalanya.setAdapter(this.adapter);
        this.listgejalanya.setTextFilterEnabled(true);


    }

    @SuppressLint("WrongConstant")
    public void  prosesnakedelai(View view) {

        String namagejala ="";

        SparseBooleanArray sparseBooleanArray  = this.listgejalanya.getCheckedItemPositions();

        for (int i = 0; i < this.listgejalanya.getCount(); i++) {

            if (sparseBooleanArray.get(i)){

                if (namagejala =="") {

                    namagejala =  '\"' + this.listgejalanya.getItemAtPosition(i).toString() + '\"';
                }
                else{

                    namagejala = namagejala +  ", \"" + this.listgejalanya.getItemAtPosition(i).toString() + '\"';
                }


            }

        }

        Intent hasilkedelai = new Intent(this, hasil_konsultasi_kedelai.class);
        hasilkedelai.putExtra("namagejala", namagejala);
        if (namagejala == "") {
            Toast.makeText(this, "Pastikan anda sudah memilih satu atau lebih gejala !", 1).show();
        } else {
            startActivity(hasilkedelai);
        }
    }
}