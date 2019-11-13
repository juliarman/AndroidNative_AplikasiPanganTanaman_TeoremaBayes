package com.example.asus.apppangan.Konsultasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.apppangan.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class konsultasipenyakit extends AppCompatActivity implements View.OnClickListener {

    Button konsuljagung,konsulkedelai,konsulpadi;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference woi;
    public static Intent konsultasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasipenyakit);

        firebaseDatabase = FirebaseDatabase.getInstance();


        konsuljagung = (Button) findViewById(R.id.konsultasipenyakitjagung);
        konsulkedelai = (Button) findViewById(R.id.konsultasipenyakitkedelai);
        konsulpadi = (Button) findViewById(R.id.konsultasipenyakitpadi);

        konsuljagung.setOnClickListener(this);
        konsulkedelai.setOnClickListener(this);
        konsulpadi.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.konsultasipenyakitjagung:

                konsultasi = new Intent(konsultasipenyakit.this, konsultasipenyakit_gejala_jagung.class);
                startActivity(konsultasi);
                break;

            case R.id.konsultasipenyakitkedelai:
                konsultasi = new Intent(konsultasipenyakit.this, konsultasipenyakit_gejala_kedelai.class);
                startActivity(konsultasi);
                break;

            case R.id.konsultasipenyakitpadi:
                konsultasi = new Intent(konsultasipenyakit.this, konsultasipenyakit_gejala_padi.class);
                startActivity(konsultasi);
                break;
        }

    }
}
