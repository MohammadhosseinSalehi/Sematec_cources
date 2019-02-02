package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessController;

public class AcceptRegistery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_registery);
        TextView firstName = findViewById(R.id.firstName1);
        TextView lastName = findViewById(R.id.lastName1);
        TextView age = findViewById(R.id.age1);
        TextView phone = findViewById(R.id.phoneNumber1);
        TextView mail = findViewById(R.id.mail1);

        Button accept= findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AcceptRegistery.this, "اطلاعات شما با موفقیت ثبت شد",Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        firstName.setText(intent.getStringExtra("firstName"));
        lastName.setText(intent.getStringExtra("lastName"));
        age.setText(intent.getStringExtra("age"));
        phone.setText(intent.getStringExtra("phoneNumber"));
        mail.setText(intent.getStringExtra("mail"));

    }
}
