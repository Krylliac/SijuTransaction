package com.example.project1.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project1.DetailLaporan;
import com.example.project1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Lapadapter extends RecyclerView.Adapter<Lapadapter.ListViewHolder>{
    private List<Hasil> list;
    private Context context;
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Hasil");

    public Lapadapter(List<Hasil> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull

    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_laporan, viewGroup, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Hasil hasil = list.get(position);
        holder.tv_laporan.setText("Rp "+hasil.getLap8());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailLaporan.class);
                intent.putExtra("laporan1", hasil.getLap1());
                intent.putExtra("laporan2", hasil.getLap2());
                intent.putExtra("laporan3", hasil.getLap3());
                intent.putExtra("laporan4", hasil.getLap4());
                intent.putExtra("laporan5", hasil.getLap5());
                intent.putExtra("laporan6", hasil.getLap6());
                intent.putExtra("laporan7", hasil.getLap7());
                intent.putExtra("laporan8", hasil.getLap8());
                intent.putExtra("tanggal", hasil.getTanggal_buat());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_laporan;
        View view;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_laporan = (TextView) itemView.findViewById(R.id.tv_laporan);
            view = itemView;

        }
    }
}
