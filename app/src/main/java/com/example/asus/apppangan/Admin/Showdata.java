package com.example.asus.apppangan.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.apppangan.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Showdata extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView listshow;
    Button btnUpdate,btnDelete;
    ArrayList <String> arrList= new ArrayList<>();
    ArrayAdapter <String> arrAdp;
    Module module;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);

        setTitle("EDIT PANDUAN");
        module=((Module)getApplicationContext());
        databaseReference=FirebaseDatabase.getInstance().getReference("panduan");
        listshow= (ListView) findViewById(R.id.listviewtxt);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        arrAdp= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrList);
        listshow.setAdapter(arrAdp);
        //Toast.makeText(this,"OK",Toast.LENGTH_SHORT).show();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value= dataSnapshot.getValue(Students.class).toString();
                arrList.add(value);
                arrAdp.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        listshow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //UpdateInput(arrList.get(position),position);
                module.setGvalue_id(arrList.get(position));
                module.setGvalue_Name(arrList.get(position));
                //Toast.makeText(Showdata.this,arrList.get(position),Toast.LENGTH_LONG).show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(module.getGvalue_id().equals("")){
                    Toast.makeText(Showdata.this,"Please Select Items",Toast.LENGTH_LONG).show();
                }else {
                    Intent intphto =new Intent(getApplicationContext(), KelolaPanduan.class);
                    startActivity(intphto);
                }
            }
        });


    }
}
