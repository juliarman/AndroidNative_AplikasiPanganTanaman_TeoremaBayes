package com.example.asus.apppangan;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlTextView;

public class user_tentangkami extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference referensi;
    public HtmlTextView pb1, pb2, pj1, mhs1,mhs2,stb1,stb2,namakpala,namapangkat,judulapp;

    private TextView urllogo1,urllogo2;
    private ImageView logo1,logo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_tentangkami);



        judulapp = (HtmlTextView) findViewById(R.id.judulaplikasi);
        mhs1 = (HtmlTextView) findViewById(R.id.namapembuat1);
        mhs2 = (HtmlTextView) findViewById(R.id.namapembuat2);
        pb1 = (HtmlTextView) findViewById(R.id.pembimbing1);
        pb2 = (HtmlTextView) findViewById(R.id.pembimbing2);
        stb1 = (HtmlTextView) findViewById(R.id.stambuk1);
        stb2 = (HtmlTextView) findViewById(R.id.stambuk2);
        namakpala = (HtmlTextView) findViewById(R.id.namanyakepala);
        namapangkat = (HtmlTextView) findViewById(R.id.namapangkat);
        pj1 = (HtmlTextView) findViewById(R.id.Penguji1);


        urllogo1 =(TextView) findViewById(R.id.urllogo1);
        urllogo2 = (TextView) findViewById(R.id.urllogo2);

        logo1 = (ImageView) findViewById(R.id.logokabupaten);
        logo2 = (ImageView) findViewById(R.id.logokampus);


        database = FirebaseDatabase.getInstance();

        referensi = database.getReference().child("tentang kami");



        tampilkan();

    }


    public void tampilkan(){

        referensi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String judulaplikasinya = dataSnapshot.child("judul aplikasi").getValue().toString();
                String namamhs1 = dataSnapshot.child("pembuat").child("1").child("nama").getValue().toString();
                String namamhs2 = dataSnapshot.child("pembuat").child("2").child("nama").getValue().toString();
                String stb11 = dataSnapshot.child("pembuat").child("1").child("stambuk").getValue().toString();
                String stb22 = dataSnapshot.child("pembuat").child("2").child("stambuk").getValue().toString();
                String pmb1 = dataSnapshot.child("pemeriksa aplikasi").child("pembimbing 1").child("nama").getValue().toString();
                String pmb2 = dataSnapshot.child("pemeriksa aplikasi").child("pembimbing 2").child("nama").getValue().toString();
                String penguji1 = dataSnapshot.child("pemeriksa aplikasi").child("penguji 1").child("nama").getValue().toString();

                String namainstansi = dataSnapshot.child("pemeriksa aplikasi").child("nama instansi penelitian").child("nama instansi").getValue().toString();
                String namakepalainstansi = dataSnapshot.child("pemeriksa aplikasi").child("nama instansi penelitian").child("nama").getValue().toString();

                String logo11 = dataSnapshot.child("gambar").child("logo 1").getValue().toString();
                urllogo1.setText(logo11);
                Picasso.get()

                        .load(logo11)
                        .into(logo1);

                String logo22 = dataSnapshot.child("gambar").child("logo 2").getValue().toString();
                urllogo2.setText(logo22);

                Picasso.get()
                        .load(logo22)
                        .into(logo2);

                judulapp.setHtml(judulaplikasinya);
                mhs1.setHtml(namamhs1);
                mhs2.setHtml(namamhs2);
                stb1.setHtml(stb11);
                stb2.setHtml(stb22);
                pb1.setHtml(pmb1);
                pb2.setHtml(pmb2);
                pj1.setHtml(penguji1);
                namakpala.setHtml(namakepalainstansi);
                namapangkat.setHtml(namainstansi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
