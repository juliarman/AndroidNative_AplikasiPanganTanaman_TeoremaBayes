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

import com.example.asus.apppangan.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class list_penyakit_kedelai extends AppCompatActivity {

    DatabaseReference mbref;
    FirebaseDatabase database;
    ListView listpenyakitkedelai;
    ArrayList<String> list = new ArrayList<>();
    public static Intent infopenyakit;
    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penyakit_kedelai);
        listpenyakitkedelai = (ListView) findViewById(R.id.listpenyakitkedelai);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        listpenyakitkedelai.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        mbref = database.getReference().child("informasi penyakit").child("kedelai");
        listpenyakitkedelai.setAdapter(adapter);
        listpenyakitkedelai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    antraknose();
                }
                if (position == 1) {
                    penyakitkarat();
                }
                if (position == 2) {
                    pustulbakteri();
                }
                if (position == 3) {
                    targespot();
                }
                if (position == 4) {
                    rkbdbp();
                }
            }
        });




                mbref.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        list.add(dataSnapshot.getKey());
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

    public void antraknose(){
        infopenyakit = new Intent(list_penyakit_kedelai.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("penyakit antraknose").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("penyakit antraknose").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void penyakitkarat(){
        infopenyakit = new Intent(list_penyakit_kedelai.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("penyakit karat").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("penyakit karat").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void pustulbakteri(){
        infopenyakit = new Intent(list_penyakit_kedelai.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("penyakit pustul bakteri").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("penyakit pustul bakteri").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void targespot(){
        infopenyakit = new Intent(list_penyakit_kedelai.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("penyakit targe spot").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("penyakit targe spot").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void rkbdbp(){
        infopenyakit = new Intent(list_penyakit_kedelai.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("rebah kecambah, busuk daun, batang dan polong").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("rebah kecambah, busuk daun, batang dan polong").child("deskripsi").getValue().toString();
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


