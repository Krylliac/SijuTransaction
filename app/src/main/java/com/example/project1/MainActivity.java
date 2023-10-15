package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView laba,laporan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        laba = (ImageView) findViewById(R.id.laba);
        laba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,Hitunglaba.class);
                    startActivity(intent);

                }
        });
        laporan = (ImageView) findViewById(R.id.laporan);
        laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View r) {
                Intent intent1 = new Intent(MainActivity.this, Laporan.class);
                startActivity(intent1);

            }
        });
    }
}
