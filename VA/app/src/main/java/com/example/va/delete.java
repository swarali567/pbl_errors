package com.example.va;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class delete extends AppCompatActivity {

    String email;
    Button delete;
    DatabaseHelper obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        obj=new DatabaseHelper(this);
        delete=findViewById(R.id.delete_delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=((EditText)findViewById(R.id.email_delete)).getText().toString();

                if(email.length()==0) {
                    Toast.makeText(getApplicationContext(), "Enter email-id", Toast.LENGTH_SHORT).show();
                }else{
                    if(obj.deleteData(email)) {
                        Toast.makeText(getApplicationContext(), "Record deleted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Entry not found", Toast.LENGTH_SHORT).show();
                        ((EditText) findViewById(R.id.email_delete)).setText("");
                    }
                    FirebaseDatabase.getInstance().getReference().child("users").child(email).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Record deleted", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(getApplicationContext(),"Record could not be deleted",Toast.LENGTH_SHORT).show();
                                ((EditText)findViewById(R.id.email_delete)).setText("");
                            }
                        }
                    });
            }
        }
    });
}
}


