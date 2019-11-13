package com.example.asus.apppangan.Admin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.apppangan.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KelolaPanduan extends AppCompatActivity {
    EditText tID,tjudulnya,tdeskripsinya;
    Button btnUpdate,btnCancel;
    DatabaseReference databaseReference;
    private TextView result;
    Module module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        result=(TextView)findViewById(R.id.textView2);
        tID=(EditText) findViewById(R.id.tID);
        tjudulnya=(EditText) findViewById(R.id.tjudul);
        tdeskripsinya=(EditText) findViewById(R.id.tdeskripsi);

        btnUpdate=(Button) findViewById(R.id.btnUpadate);
        btnCancel= (Button) findViewById(R.id.btnCancel) ;

        databaseReference= FirebaseDatabase.getInstance().getReference("panduan");
        module=((Module)getApplicationContext());
        final String str = module.getGvalue_id().substring(0,6);

        tID.setText(str);
        tID.setEnabled(false);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Students students = dataSnapshot.child(str).getValue(Students.class);
                tjudulnya.setText(students.getJudul());
                tdeskripsinya.setText(students.getDeskripsi());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fungsisimpannya();
                kosongfield();
                Intent intphto =new Intent(getApplicationContext(),Showdata.class);
                startActivity(intphto);


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kosongfield();
            }
        });
    }
    private void kosongfield(){
        tID.setText("");
        tjudulnya.setText("");
        tdeskripsinya.setText("");
        result.setText("");
        tID.requestFocus();

    }

    private void  fungsisimpannya() {
        final String id = tID.getText().toString().trim();
        final String judul = tjudulnya.getText().toString().trim();
        final String deskripsi = tdeskripsinya.getText().toString().trim();




            Students students = new Students(id, judul, deskripsi);
            databaseReference.child("panduan").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    databaseReference = FirebaseDatabase.getInstance().getReference();
                    databaseReference.child("panduan").child(id).child("judul").setValue(judul);
                    databaseReference.child("panduan").child(id).child("deskripsi").setValue(deskripsi);


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            Toast.makeText(this, "Data berhasil tersimpan!", Toast.LENGTH_LONG).show();
            kosongfield();

        }
    }

