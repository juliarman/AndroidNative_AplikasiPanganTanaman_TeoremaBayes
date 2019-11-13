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

public class list_penyakit_padi extends AppCompatActivity {

    DatabaseReference mbref;
    FirebaseDatabase database;
    ListView listpenyakitpadi;
    ArrayList<String> list = new ArrayList<>();
    public static Intent infopenyakit;
    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_penyakit_padi);
        listpenyakitpadi = (ListView) findViewById(R.id.listpenyakitpadi);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,list);
        listpenyakitpadi.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        mbref = database.getReference().child("informasi penyakit").child("padi");
        listpenyakitpadi.setAdapter(adapter);


        listpenyakitpadi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    blas();
                }
                if (position == 1) {
                    fusarium();
                }
                if (position == 2) {
                    hawardaunbakteri();
                }
                if (position == 4) {
                    tungro();
                }
                if (position == 3) {
                    kerdil();
                }
            }
        });

        mbref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                list.add(dataSnapshot.getKey( ));
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

    public void blas(){
        infopenyakit = new Intent(list_penyakit_padi.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("blas").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("blas").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void fusarium(){
        infopenyakit = new Intent(list_penyakit_padi.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("fusarium").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("fusarium").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void hawardaunbakteri(){
        infopenyakit = new Intent(list_penyakit_padi.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("hawar daun bakteri").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("hawar daun bakteri").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void kerdil(){
        infopenyakit = new Intent(list_penyakit_padi.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("penyakit kerdil").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("penyakit kerdil").child("deskripsi").getValue().toString();
                infopenyakit.putExtra("judul", judulnya);
                infopenyakit.putExtra("deskripsi", deskripsinya);
                startActivity(infopenyakit);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void tungro(){
        infopenyakit = new Intent(list_penyakit_padi.this, Detail_Penyakit.class);
        mbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("tungro").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("tungro").child("deskripsi").getValue().toString();
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
