package com.example.asus.apppangan.Admin;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus.apppangan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KelolaTentangKami extends AppCompatActivity implements View.OnClickListener {

    EditText kjudul, mhs1, mhs2,stb1,stb2, pb1,pb2,pg1 , namainstansi, kpalainstansi,gambar1,gambar2;
    Button simpandata;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola__tentang_kami);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        kjudul = (EditText) findViewById(R.id.judul);
        mhs1 = (EditText) findViewById(R.id.mahasiswa1);
        mhs2 = (EditText) findViewById(R.id.mahasiswa2);
        stb1 = (EditText) findViewById(R.id.stambuk1);
        stb2 = (EditText) findViewById(R.id.stambuk2);
        pb1 = (EditText) findViewById(R.id.pembimbing1);
        pb2 = (EditText) findViewById(R.id.pembimbing2);
        pg1 = (EditText) findViewById(R.id.penguji1);
        namainstansi = (EditText) findViewById(R.id.namainstansii);
        kpalainstansi = (EditText) findViewById(R.id.kepalainstansi);
        gambar1 = (EditText) findViewById(R.id.gambarlogo1);
        gambar2 = (EditText) findViewById(R.id.gambarlogo2);
        simpandata = (Button) findViewById(R.id.simpankelolatentangkami);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Tentang Kami");

        simpandata.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             String judulapp = databaseReference.child("Tentang Kami").getKey();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
