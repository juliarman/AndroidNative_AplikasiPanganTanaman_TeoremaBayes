package com.example.asus.apppangan;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.asus.apppangan.Admin.Admin;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivityLogin extends AppCompatActivity {


    public EditText emailnya,passwordnya;

    FirebaseDatabase database;
    DatabaseReference user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();





    }



    public void halaman_user(View view) {

      Intent intent = new Intent(MainActivityLogin.this, user.class);
      startActivity(intent);
    }

    public void admin(View view) {

        Intent intent = new Intent(this, Admin.class);
        startActivity(intent);

       /** emailnya = (EditText) findViewById(R.id.username);
        passwordnya = (EditText) findViewById(R.id.password);

        FirebaseAuth loginnya = FirebaseAuth.getInstance();


        final String email = emailnya.getText().toString().trim();
        final String password = passwordnya.getText().toString().trim();

        if (email.isEmpty()){

            emailnya.setError("Email tidak boleh koosng");
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            emailnya.setError("Email tdk Valid");
        }

        else if (password.isEmpty()){

            passwordnya.setError("Password tdk boleh kosong");

        }

        else if (password.length() < 5){

            passwordnya.setError("Minimal password terdiri 5 karakter");
        }
        else{

            loginnya.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivityLogin.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()){

                        Toast.makeText(MainActivityLogin.this, "Register Gagal" +task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                    else {

                        Bundle bundle = new Bundle();
                        bundle.putString("email", email);
                        bundle.putString("pass", password);
                       startActivity(new Intent(MainActivityLogin.this, Admin.class).putExtra("emailpass", bundle));
                    }

                }
            });
        }

            */

    }
}
