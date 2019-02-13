package com.example.sematec_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sematec_1.Adapters.RecyclerAdapter;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Button addToUsers_btn = (Button)findViewById(R.id.addToUsers_btn);
        addToUsers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, Register_activity.class);
                startActivity(intent);
            }
        });

        List<String> userList = Hawk.get("List");
        RecyclerView recyclerView = findViewById(R.id.recycler);
        RecyclerAdapter adapter = new RecyclerAdapter(userList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this, RecyclerView.VERTICAL, false));

        Button deleteHawk_btn = (Button)findViewById(R.id.deleteHawk_btn);
        deleteHawk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hawk.delete("List");
                Intent intent = new Intent(RecyclerActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(RecyclerActivity.this,"users has been deleted",Toast.LENGTH_LONG).show();
            }
        });

    }
}
