package com.example.asus.apppangan.Panduan;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.asus.apppangan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class kedelai extends AppCompatActivity implements View.OnClickListener {

    public static String TAG_JUDUL ="judul";
    public static String TAG_DESKRIPSI ="deskripsi";
    public static Intent panduan;
    Button pd1,pd2,pd3,pd4,pd5,pd6,pd7;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference broku;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_kedelai);

        firebaseDatabase = FirebaseDatabase.getInstance();
        broku = firebaseDatabase.getReference().child("panduan");

        pd1 = (Button) findViewById(R.id.benih_berkualitaskedelai);
        pd2 = (Button) findViewById(R.id.penanamankedelai);
        pd3 = (Button) findViewById(R.id.pemupukankedelai);
        pd4 = (Button) findViewById(R.id.pengairankedelai);
        pd5 = (Button) findViewById(R.id.pengendalian_hamakedelai);
        pd6 = (Button) findViewById(R.id.pemeliharaankedelai);
        pd7 = (Button) findViewById(R.id.panenkedelai);


        imageView = (ImageView) findViewById(R.id.detailpanduanbackground);


        pd1.setOnClickListener(this);
        pd2.setOnClickListener(this);
        pd3.setOnClickListener(this);
        pd4.setOnClickListener(this);
        pd5.setOnClickListener(this);
        pd6.setOnClickListener(this);
        pd7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.benih_berkualitaskedelai:
                benihberkualitaskedelai();
                break;

            case R.id.penanamankedelai:
                penanamankedelai();
                break;

            case R.id.pemupukankedelai:
                pemupukankedelai();
                break;

            case R.id.pengairankedelai:
                pengairankedelai();
                break;

            case R.id.pengendalian_hamakedelai:
                pengendalianhamakedelai();
                break;

            case R.id.pemeliharaankedelai:
                pemeliharaankedelai();
                break;

            case R.id.panenkedelai:
                panenkedelai();
                break;
        }

    }

    public void benihberkualitaskedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN006").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN006").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void penanamankedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN010").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN010").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void pemupukankedelai(){




        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                String judulnya = dataSnapshot.child("PDN009").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN009").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void pengairankedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN011").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN011").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void pengendalianhamakedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN012").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN012").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void panenkedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN007").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN007").child("deskripsi").getValue().toString();
                panduan.putExtra("judul", judulnya);
                panduan.putExtra("deskripsi", deskripsinya);
                startActivity(panduan);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }


    public void pemeliharaankedelai(){
        panduan = new Intent(kedelai.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN008").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN008").child("deskripsi").getValue().toString();
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
