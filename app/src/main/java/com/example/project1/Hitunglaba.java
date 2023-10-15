package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project1.Model.Hasil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Hitunglaba extends AppCompatActivity {
    Button btnhitung, btnsimpan;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
    TextView result,result1,result2,result3,result4,result5,result6,result7;
    DatabaseReference reference;
    Hasil hasil;
    int a,b,c,d,e,f,g,i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitunglaba);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt1 = (EditText) findViewById(R.id.txtx1);
        txt2 = (EditText) findViewById(R.id.txtx2);
        txt3 = (EditText) findViewById(R.id.txtx3);
        txt4 = (EditText) findViewById(R.id.txtx4);
        txt5 = (EditText) findViewById(R.id.txtx5);
        txt6 = (EditText) findViewById(R.id.txtx6);
        txt7 = (EditText) findViewById(R.id.txtx7);
        txt8 = (EditText) findViewById(R.id.txtx8);
        result = (TextView) findViewById(R.id.result);
        result1 = (TextView) findViewById(R.id.result1);
        result2= (TextView) findViewById(R.id.result2);
        result3 = (TextView) findViewById(R.id.result3);
        result4 = (TextView) findViewById(R.id.result4);
        result5 = (TextView) findViewById(R.id.result5);
        result6 = (TextView) findViewById(R.id.result6);
        result7 = (TextView) findViewById(R.id.result7);
        hasil = new Hasil();
        reference = FirebaseDatabase.getInstance().getReference("Hasil");

        final String tgl_buat = new SimpleDateFormat("dd/MM/yyyy - HH:mm", Locale.getDefault()).format(new Date());

        btnhitung = (Button) findViewById(R.id.btn1);

        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtlap1 = txt1.getText().toString();
                String txtlap2 = txt2.getText().toString();
                String txtlap3 = txt3.getText().toString();
                String txtlap4 = txt4.getText().toString();
                String txtlap5 = txt5.getText().toString();
                String txtlap6 = txt6.getText().toString();
                String txtlap7 = txt7.getText().toString();
                String txtlap8 = txt8.getText().toString();


                if(TextUtils.isEmpty(txtlap1) || TextUtils.isEmpty(txtlap2) || TextUtils.isEmpty(txtlap3) || TextUtils.isEmpty(txtlap4) || TextUtils.isEmpty(txtlap5)
                        || TextUtils.isEmpty(txtlap6) || TextUtils.isEmpty(txtlap7) || TextUtils.isEmpty(txtlap8)){
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong! isi 0 jika tidak ada pesanan", Toast.LENGTH_SHORT).show();
                } else {
                    a = Integer.parseInt(txt1.getText().toString());
                    b = Integer.parseInt(txt2.getText().toString());
                    c = Integer.parseInt(txt3.getText().toString());
                    d = Integer.parseInt(txt4.getText().toString());
                    e = Integer.parseInt(txt5.getText().toString());
                    f = Integer.parseInt(txt6.getText().toString());
                    g = Integer.parseInt(txt7.getText().toString());
                    i = Integer.parseInt(txt8.getText().toString());

                    result.setText(String.valueOf(a*11000));
                    result1.setText(String.valueOf(b*13000));
                    result2.setText(String.valueOf(c*14000));
                    result3.setText(String.valueOf(d*15000));
                    result4.setText(String.valueOf(e*16000));
                    result5.setText(String.valueOf(f*10000));
                    result6.setText(String.valueOf(g*10000));
                    result7.setText(String.valueOf(((a*11000)+(b*13000)+(c*14000)+(d*15000)+(e*16000)+(f*10000)+(g*10000))-i));

                }


            }
        });
        btnsimpan = (Button) findViewById(R.id.btn2);
        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtlap1 = txt1.getText().toString();
                String txtlap2 = txt2.getText().toString();
                String txtlap3 = txt3.getText().toString();
                String txtlap4 = txt4.getText().toString();
                String txtlap5 = txt5.getText().toString();
                String txtlap6 = txt6.getText().toString();
                String txtlap7 = txt7.getText().toString();
                String txtlap8 = txt8.getText().toString();
                String rslt7 = result7.getText().toString();

                if( rslt7 != null && TextUtils.isEmpty(txtlap1) || TextUtils.isEmpty(txtlap2) || TextUtils.isEmpty(txtlap3) || TextUtils.isEmpty(txtlap4) || TextUtils.isEmpty(txtlap5)
                        || TextUtils.isEmpty(txtlap6) || TextUtils.isEmpty(txtlap7) || TextUtils.isEmpty(txtlap8)){
                    Toast.makeText(getApplicationContext(), "Data tidak boleh kosong! isi 0 jika tidak ada pesanan", Toast.LENGTH_SHORT).show();
                } else {
                    hasil.setLap1(String.valueOf(a*11000));
                    hasil.setLap2(String.valueOf(b*13000));
                    hasil.setLap3(String.valueOf(c*14000));
                    hasil.setLap4(String.valueOf(d*15000));
                    hasil.setLap5(String.valueOf(e*16000));
                    hasil.setLap6(String.valueOf(f*10000));
                    hasil.setLap7(String.valueOf(g*10000));
                    hasil.setLap8(String.valueOf(((a*11000)+(b*13000)+(c*14000)+(d*15000)+(e*16000)+(f*10000)+(g*10000))-i));
                    hasil.setTanggal_buat(tgl_buat);

                    reference.push().setValue(hasil).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(),"Hasil berhasil disimpan "+
                                            String.valueOf(((a*11000)+(b*13000)+(c*14000)+(d*15000)+(e*16000)+(f*10000)+(g*10000))-i)
                                    ,Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

    });

}
}
