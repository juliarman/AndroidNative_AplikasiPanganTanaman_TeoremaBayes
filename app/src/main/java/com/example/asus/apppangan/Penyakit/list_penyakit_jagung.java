package com.example.asus.apppangan.Penyakit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.asus.apppangan.Panduan.Detail_Panduan;
import com.example.asus.apppangan.Panduan.jagung;
import com.example.asus.apppangan.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class list_penyakit_jagung extends AppCompatActivity {

    DatabaseReference mbref;
    FirebaseDatabase database;
    ListView listpenyakitjagung;
    ArrayList<String>  list = new ArrayList<>();
    public static Intent infopenyakit;
    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penyakit_jagung);
            listpenyakitjagung = (ListView) findViewById(R.id.listpenyakitjagung);
            final ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list);
            listpenyakitjagung.setAdapter(adapter);
            database = FirebaseDatabase.getInstance();
            mbref = database.getReference().child("informasi penyakit").child("jagung");
            listpenyakitjagung.setAdapter(adapter);
            listpenyakitjagung.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position==0){
                        bercakdaun();
                    }
                    if (position==1){
                        bulai();
                    }
                    if (position==2){
                        busukbatang();
                    }
                    if (position==4){

                        karatdaun();
                    }
                    if (position==3){
                        hawardaun();
                    }
                }
            });

                mbref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        list.add(dataSnapshot.child("judul").getValue().toString());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }


    public void bercakdaun(){
        infopenyakit = new Intent(list_penyakit_jagung.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("bercak daun").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("bercak daun").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void bulai(){
        infopenyakit = new Intent(list_penyakit_jagung.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("bulai").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("bulai").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void busukbatang(){
        infopenyakit = new Intent(list_penyakit_jagung.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("busuk batang").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("busuk batang").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void hawardaun(){
        infopenyakit = new Intent(list_penyakit_jagung.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("hawar daun").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("hawar daun").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void karatdaun(){
        infopenyakit = new Intent(list_penyakit_jagung.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("karat daun").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("karat daun").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
