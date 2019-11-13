package com.example.asus.apppangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.apppangan.Panduan.jagung;
import com.example.asus.apppangan.Panduan.kedelai;
import com.example.asus.apppangan.Panduan.padi;

public class panduan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_panduan);






    }




    public void jagung(View view) {

        Intent intent = new Intent(panduan.this, jagung.class);
        startActivity(intent);
    }

    public void padi(View view) {


        Intent intent = new Intent(panduan.this, padi.class);
        startActivity(intent);
    }

    public void kedelai(View view) {

        Intent intent = new Intent(panduan.this, kedelai.class);
        startActivity(intent);
    }

}
