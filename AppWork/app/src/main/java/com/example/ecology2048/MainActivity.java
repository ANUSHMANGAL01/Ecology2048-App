package com.example.ecology2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton level1 = (ImageButton)findViewById(R.id.level01);
        ImageButton level2 = (ImageButton)findViewById(R.id.level02);
        ImageButton level3 = (ImageButton)findViewById(R.id.level03);
        Intent level1_intent = new Intent(this, MainActivity2.class);
        Intent level2_intent = new Intent(this, MainActivity4.class);
        Intent level3_intent = new Intent(this, MainActivity3.class);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(level1_intent);
            }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(level2_intent);
            }
        });
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(level3_intent);
            }
        });

    }
}