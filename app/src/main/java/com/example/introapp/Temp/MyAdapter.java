package com.example.introapp.Temp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.introapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<News> list_data;

    private Context context;

    public MyAdapter(Context context, List<News> list_data) {
        this.list_data = list_data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final News listData = list_data.get(position);

        Glide.with(context)
                .load(listData
                        .getImageurl())
                .into(holder.img);

        holder.txtname.setText(listData.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listData.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView img;
        private AppCompatTextView txtname;
        private CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view);
            txtname = itemView.findViewById(R.id.text_name);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}