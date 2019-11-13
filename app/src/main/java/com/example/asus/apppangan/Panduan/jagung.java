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

public class jagung extends AppCompatActivity implements View.OnClickListener {

   public static String TAG_JUDUL ="judul";
   public static String TAG_DESKRIPSI ="deskripsi";

   public static Intent panduan;

    Button pd1,pd2,pd3,pd4,pd5;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference broku;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan_jagung);

        firebaseDatabase = FirebaseDatabase.getInstance();
        broku = firebaseDatabase.getReference().child("panduan");

        pd1 = (Button) findViewById(R.id.pengelolahan_lahan);
        pd2 = (Button) findViewById(R.id.pembibitan);
        pd3 = (Button) findViewById(R.id.pemberian_pupuk);
        pd4 = (Button) findViewById(R.id.pengendalianhama);
        pd5 = (Button) findViewById(R.id.panenjagung);

        pd1.setOnClickListener(this);
        pd2.setOnClickListener(this);
        pd3.setOnClickListener(this);
        pd4.setOnClickListener(this);
        pd5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.pengelolahan_lahan:
                pengolahan_lahan();
                break;

            case R.id.pembibitan:
                pembibitan();
                break;

            case R.id.pemberian_pupuk:
                pemberian_pupuk();
                break;

            case R.id.pengendalianhama:
                pengendalian_hama();
                break;

            case R.id.panenjagung:
                panen();
                break;
        }
    }


   /* public class Detail_Panduan{

        Context context;
        public Detail_Panduan(Context context){
            this.context=context;
        }

        public void mengubah(){
            HtmlTextView judulnya = (HtmlTextView) ((Activity)context).findViewById(R.id.judullll);
            HtmlTextView deskripsinya = (HtmlTextView) ((Activity)context).findViewById(R.id.deskripsiiiii);
        }


    }
    */


   public void pengolahan_lahan(){
       panduan = new Intent(jagung.this, Detail_Panduan.class);
       broku.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String judulnya = dataSnapshot.child("PDN005").child("judul").getValue().toString();
               String deskripsinya = dataSnapshot.child("PDN005").child("deskripsi").getValue().toString();
               panduan.putExtra("judul", judulnya);
               panduan.putExtra("deskripsi", deskripsinya);
               startActivity(panduan);
           }
           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
           }
       });
   }

   public void pembibitan(){
       panduan = new Intent(jagung.this, Detail_Panduan.class);
       broku.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String judulnya = dataSnapshot.child("PDN003").child("judul").getValue().toString();
               String deskripsinya = dataSnapshot.child("PDN003").child("deskripsi").getValue().toString();
               panduan.putExtra("judul", judulnya);
               panduan.putExtra("deskripsi", deskripsinya);
               startActivity(panduan);
           }
           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });

   }

   public void pemberian_pupuk(){
       panduan = new Intent(jagung.this, Detail_Panduan.class);
       broku.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String judulnya = dataSnapshot.child("PDN002").child("judul").getValue().toString();
               String deskripsinya = dataSnapshot.child("PDN002").child("deskripsi").getValue().toString();
               panduan.putExtra("judul", judulnya);
               panduan.putExtra("deskripsi", deskripsinya);
               startActivity(panduan);
           }
           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {
           }
       });
   }


    public void pengendalian_hama(){
        panduan = new Intent(jagung.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN004").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN004").child("deskripsi").getValue().toString();
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
        panduan = new Intent(jagung.this, Detail_Panduan.class);
        broku.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String judulnya = dataSnapshot.child("PDN001").child("judul").getValue().toString();
                String deskripsinya = dataSnapshot.child("PDN001").child("deskripsi").getValue().toString();
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
