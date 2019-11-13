package com.example.asus.apppangan.Panduan;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.asus.apppangan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class padi extends AppCompatActivity implements View.OnClickListener {

    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";
    public static Intent panduan;
    Button pd1,pd2,pd3,pd4,pd5,pd6;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference woi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_padi);

        firebaseDatabase = FirebaseDatabase.getInstance();
        woi = firebaseDatabase.getReference().child("panduan");

        pd1 = (Button) findViewById(R.id.benih_berkualitas);
        pd2 = (Button) findViewById(R.id.penanaman);
        pd3 = (Button) findViewById(R.id.persemaian);
        pd4 = (Button) findViewById(R.id.pemupukan);
        pd5 = (Button) findViewById(R.id.pengendalian_hama);
        pd6 = (Button) findViewById(R.id.panen);

        pd1.setOnClickListener(this);
        pd2.setOnClickListener(this);
        pd3.setOnClickListener(this);
        pd4.setOnClickListener(this);
        pd5.setOnClickListener(this);
        pd6.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.benih_berkualitas:
                benih_berkualitas();
                break;

            case R.id.penanaman:
                penanaman();
                break;

            case R.id.persemaian:
                persemaian();
                break;

            case R.id.pemupukan:
                pemupukan();
                break;

            case R.id.pengendalian_hama:
                pengendalianhamapadi();
                break;

            case R.id.panen:
                panen();
                break;
        }
    }

    public void benih_berkualitas(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN013").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN013").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void penanaman(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN016").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN016").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void persemaian(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN019").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN019").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void pemupukan(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN015").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN015").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void pengendalianhamapadi(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN018").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN018").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }


    public void pengairan(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN017").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN017").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void panen(){
        panduan = new Intent(padi.this, Detail_Panduan.class);
        woi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN014").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN014").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

}
