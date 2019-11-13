package com.example.asus.apppangan;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.apppangan.Konsultasi.konsultasipenyakit;
import com.example.asus.apppangan.Penyakit.informasipenyakit;

public class user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


    }



    public void tentangkami(View view) {

        Intent intent = new Intent(user.this, user_tentangkami.class);

        startActivity(intent);

    }


    public void panduan(View view) {

        Intent intent = new Intent(user.this, panduan.class);

        startActivity(intent);

    }

    public void informasipenyakit(View view) {

        Intent intent = new Intent(user.this, informasipenyakit.class);
        startActivity(intent);

    }

    public void konsultasipenyakit(View view) {

       Intent intent = new Intent(user.this, konsultasipenyakit.class );
       startActivity(intent);
    }
}


