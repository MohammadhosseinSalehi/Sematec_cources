package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;

public class AcceptRegistery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_registery);
        final TextView tv_firstName = findViewById(R.id.firstName1);
        final TextView tv_lastName = findViewById(R.id.lastName1);
        final TextView tv_age = findViewById(R.id.age1);
        final TextView tv_phone = findViewById(R.id.phoneNumber1);
        final TextView tv_mail = findViewById(R.id.mail1);

        //****************************HAWK LIBRARY*****************************

        Intent intent = getIntent();
        tv_firstName.setText(intent.getStringExtra("firstName"));
        tv_lastName.setText(intent.getStringExtra("lastName"));
        tv_age.setText(intent.getStringExtra("age"));
        tv_phone.setText(intent.getStringExtra("phoneNumber"));
        tv_mail.setText(intent.getStringExtra("mail"));

        Button accept= findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).edit().putString("key_firstName",tv_firstName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).edit().putString("key_lastName",tv_lastName.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).edit().putString("key_age",tv_age.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).edit().putString("key_phone",tv_phone.getText().toString()).apply();
                PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).edit().putString("key_mail",tv_mail.getText().toString()).apply();

                Toast.makeText(AcceptRegistery.this, PreferenceManager.getDefaultSharedPreferences(AcceptRegistery.this).getString("key_firstName","FirstName is empty") ,Toast.LENGTH_LONG).show();
                Hawk.put("userList_key", tv_firstName.getText().toString());
                Intent intent = new Intent(AcceptRegistery.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
