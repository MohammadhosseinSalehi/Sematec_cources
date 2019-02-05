package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        final EditText firstName = findViewById(R.id.firstName);
        final EditText lastName = findViewById(R.id.lastName);
        final EditText age = findViewById(R.id.age);
        final EditText phone = findViewById(R.id.phoneNumber);
        final EditText mail = findViewById(R.id.mail);
        Button Register=findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Register_activity.this, AcceptRegistery.class);
                intent.putExtra("firstName", firstName.getText().toString());
                intent.putExtra("lastName", lastName.getText().toString());
                intent.putExtra("age", age.getText().toString());
                intent.putExtra("phoneNumber", phone.getText().toString());
                intent.putExtra("mail", mail.getText().toString());

                Intent resultIntent = new Intent();
                resultIntent.putExtra("ResultRegisteryActivity",firstName.getText().toString());
                setResult(Activity.RESULT_OK,resultIntent);

                startActivity(intent);
                finish();
            }
        });

    }
}
