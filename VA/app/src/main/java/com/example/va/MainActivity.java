package com.example.va;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button b1, b2;
    private FirebaseAuth auth;


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        ed1 = (EditText) findViewById(R.id.email_text);
        ed2 = (EditText) findViewById(R.id.password_text);
        b1 = findViewById(R.id.signin_admin);
        b2 = findViewById(R.id.signin_guest);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email1 = ed1.getText().toString();
                String txt_password1 = ed2.getText().toString();

                if (TextUtils.isEmpty(txt_email1) || TextUtils.isEmpty(txt_password1) || txt_password1.length() < 6 || (!Patterns.EMAIL_ADDRESS.matcher(txt_email1).matches())) {
                    Toast.makeText(MainActivity.this, "invalid credentials", Toast.LENGTH_LONG).show();
                } else {
                    LoginAdmin(txt_email1, txt_password1);
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email2 = ed1.getText().toString();
                String txt_password2 = ed2.getText().toString();

                if (TextUtils.isEmpty(txt_email2) || TextUtils.isEmpty(txt_password2) || txt_password2.length() < 6 || (!Patterns.EMAIL_ADDRESS.matcher(txt_email2).matches())) {
                    Toast.makeText(MainActivity.this, "invalid credentials", Toast.LENGTH_LONG).show();
                } else {
                    ViewGuest(txt_email2, txt_password2);
                }
            }
        });
    }

    private void LoginAdmin(String email1, String password1) {
        /*final Task<AuthResult> user_signed_in = auth.signInWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Toast.makeText(MainActivity.this, "user signed in", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = auth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                }); */
        if (email1.equals("swaralisuryawanshi2020.it@mmcoe.edu.in") && password1.equals("swaraliclg")) {
            Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, main.class));
            finish();
        } else {
            Toast.makeText(MainActivity.this, "registration failed,try signing up instead", Toast.LENGTH_SHORT).show();
        }
    }

    public void ViewGuest(String email2, String password2) {
        /*auth.createUserWithEmailAndPassword(email2, password2).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "new successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, View.class));
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "not successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}*/

        Toast.makeText(MainActivity.this, "registration successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, view.class));
        finish();
    }
}

