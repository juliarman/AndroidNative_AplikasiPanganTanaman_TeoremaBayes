package com.example.asus.apppangan.Penyakit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.apppangan.R;

public class informasipenyakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasipenyakit);


    }

    public void informasipenyakitjagung(View view) {

        Intent intent = new Intent(informasipenyakit.this, list_penyakit_jagung.class);
        startActivity(intent);
    }

    public void informasipenyakitpadi(View view) {

        Intent intent = new Intent(informasipenyakit.this, list_penyakit_padi.class);
        startActivity(intent);
    }

    public void informasipenyakitkedelai(View view) {

        Intent intent = new Intent(informasipenyakit.this, list_penyakit_kedelai.class);
        startActivity(intent);
    }
}
