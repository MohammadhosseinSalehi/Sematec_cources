package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show_Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__information);

        TextView firstName = findViewById(R.id.firstName2);
        TextView lastName = findViewById(R.id.lastName2);
        TextView age = findViewById(R.id.age2);
        TextView phone = findViewById(R.id.phoneNumber2);
        TextView mail = findViewById(R.id.mail2);

        firstName.setText(PreferenceManager.getDefaultSharedPreferences(Show_Information.this).getString("key_firstName","FirstName is empty"));
        lastName.setText(PreferenceManager.getDefaultSharedPreferences(Show_Information.this).getString("key_lastName", "LastName is empty"));
        age.setText(PreferenceManager.getDefaultSharedPreferences(Show_Information.this).getString("key_age", "Age is empty"));
        phone.setText(PreferenceManager.getDefaultSharedPreferences(Show_Information.this).getString("key_phone", "Phone is empty"));
        mail.setText(PreferenceManager.getDefaultSharedPreferences(Show_Information.this).getString("key_mail", "E-Mail is empty"));

    }
}
