package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project1.Model.Hasil;
import com.example.project1.Model.Lapadapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Laporan extends AppCompatActivity {
    private Toolbar toolbar1;
    private List<Hasil> list = new ArrayList<>();
    private Context context = this;
    RecyclerView rv_laporan;
    private  Lapadapter lapadapter;
    DatabaseReference reference;
    Hasil hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        toolbar1.setTitle("Hasil Rugi/Laba bersih");
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv_laporan = (RecyclerView) findViewById(R.id.rv_laporan);

        rv_laporan.setHasFixedSize(true);
        rv_laporan.setLayoutManager(new LinearLayoutManager(Laporan.this));

        reference = FirebaseDatabase.getInstance().getReference("Hasil");
        hasil = new Hasil();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Hasil hasil = snapshot.getValue(Hasil.class);
                    String key = snapshot.getKey();
                    hasil.setID(key);
                    list.add(hasil);
                }
                lapadapter = new Lapadapter(list, context);
                rv_laporan.setAdapter(lapadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Gagal Menampilkan Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
