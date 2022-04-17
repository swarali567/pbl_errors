package com.example.va;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create extends AppCompatActivity {

    String name,address,car_model,vehicle_code,email,contact;
    Button create_user;
    DatabaseHelper obj;
    users users;

    FirebaseDatabase root;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        create_user = findViewById(R.id.create_create);
        obj=new DatabaseHelper(this);

        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reference the whole database
                root=FirebaseDatabase.getInstance();
                //reference the child of database
                ref=root.getReference("users");

                name=((EditText)findViewById(R.id.name_create)).getText().toString();
                address=((EditText)findViewById(R.id.address_create)).getText().toString();
                car_model=((EditText)findViewById(R.id.cmodel_create)).getText().toString();
                vehicle_code=((EditText)findViewById(R.id.vcode_create)).getText().toString();
                email=((EditText)findViewById(R.id.email_create)).getText().toString();
                contact=((EditText)findViewById(R.id.contact_create)).getText().toString();

                if(name.trim().length()==0 || address.trim().length()==0 || car_model.trim().length()==0 || vehicle_code.trim().length()==0 || email.trim().length()==0 || contact.trim().length()==0) {
                    Toast.makeText(getApplicationContext(), "Fill out the details properly", Toast.LENGTH_LONG).show();
                }
                else{
                    if(contact.trim().length()>10 || contact.trim().length()<10) {
                        Toast.makeText(getApplicationContext(), "Enter correct contact number", Toast.LENGTH_LONG).show();
                    }
                    else{
                        users user=new users(name,address,car_model,vehicle_code,email,contact);
                        ref.child(contact).setValue(user);
                        if(obj.insertData(name,address,car_model,vehicle_code,email,contact)) {
                            Toast.makeText(getApplicationContext(), "user created", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), display.class);
                            intent.putExtra("contact", contact);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "user could not be created", Toast.LENGTH_SHORT).show();
                        }

            }
        }
    }
});
    }
}
