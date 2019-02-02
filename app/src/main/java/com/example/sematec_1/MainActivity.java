package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("statussss: ", "onCreate");
        final Button newActivity= (Button)findViewById(R.id.newActivity);
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        final Button registry= (Button)findViewById(R.id.registery);
        registry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register_activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("statussss: ", "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("statussss: ", "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("statussss: ", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("statussss: ", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("statussss: ", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("statussss: ", "onDestroy");
    }
}
