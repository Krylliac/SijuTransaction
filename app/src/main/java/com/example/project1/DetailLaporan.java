package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailLaporan extends AppCompatActivity {
    TextView tv_laporan1, tv_laporan2,tv_laporan3,tv_laporan4,tv_laporan5,tv_laporan6,tv_laporan7,tv_laporan8;
    TextView tv_tanggal1, tv_tanggal2,tv_tanggal3,tv_tanggal4,tv_tanggal5,tv_tanggal6,tv_tanggal7,tv_tanggal8;
    Intent intent;
    String lap1,lap2,lap3,lap4,lap5,lap6,lap7,lap8;
    String tgl;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laporan);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_laporan1 = (TextView) findViewById(R.id.laporan1);
        tv_laporan2 = (TextView) findViewById(R.id.laporan2);
        tv_laporan3 = (TextView) findViewById(R.id.laporan3);
        tv_laporan4 = (TextView) findViewById(R.id.laporan4);
        tv_laporan5 = (TextView) findViewById(R.id.laporan5);
        tv_laporan6 = (TextView) findViewById(R.id.laporan6);
        tv_laporan7 = (TextView) findViewById(R.id.laporan7);
        tv_laporan8 = (TextView) findViewById(R.id.laporan8);

        tv_tanggal1 = (TextView) findViewById(R.id.tgl1);
        tv_tanggal2 = (TextView) findViewById(R.id.tgl2);
        tv_tanggal3 = (TextView) findViewById(R.id.tgl3);
        tv_tanggal4 = (TextView) findViewById(R.id.tgl4);
        tv_tanggal5 = (TextView) findViewById(R.id.tgl5);
        tv_tanggal6 = (TextView) findViewById(R.id.tgl6);
        tv_tanggal7 = (TextView) findViewById(R.id.tgl7);
        tv_tanggal8 = (TextView) findViewById(R.id.tgl8);

        intent = getIntent();
        lap1 = intent.getStringExtra("laporan1");
        lap2 = intent.getStringExtra("laporan2");
        lap3 = intent.getStringExtra("laporan3");
        lap4 = intent.getStringExtra("laporan4");
        lap5 = intent.getStringExtra("laporan5");
        lap6 = intent.getStringExtra("laporan6");
        lap7 = intent.getStringExtra("laporan7");
        lap8 = intent.getStringExtra("laporan8");
        tgl = intent.getStringExtra("tanggal");

        tv_tanggal1.setText(tgl);
        tv_tanggal2.setText(tgl);
        tv_tanggal3.setText(tgl);
        tv_tanggal4.setText(tgl);
        tv_tanggal5.setText(tgl);
        tv_tanggal6.setText(tgl);
        tv_tanggal7.setText(tgl);
        tv_tanggal8.setText(tgl);

        tv_laporan1.setText(lap1+" (Original)");
        tv_laporan2.setText(lap2+" (Satu rasa)");
        tv_laporan3.setText(lap3+ " (Dua rasa)");
        tv_laporan4.setText(lap4+ " (Tiga rasa)");
        tv_laporan5.setText(lap5+ " (Empat rasa)");
        tv_laporan6.setText(lap6+ " (Lima rasa)");
        tv_laporan7.setText(lap7+ " (Enam rasa)");
        tv_laporan8.setText(lap8+ " (Tujuh Rasa) ");

    }
}
