package com.example.introapp.Temp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.introapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<News> list_data;

    private Context context;

    public MyAdapter(List<News> list_data, Context context) {
        this.list_data = list_data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News listData = list_data.get(position);

        Picasso.with(context)
                .load(listData
                        .getImage_url())
                .into(holder.img);

        holder.txtname.setText(listData.getName());

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView img;
        private AppCompatTextView txtname;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_view);
            txtname = itemView.findViewById(R.id.text_name);
        }
    }
}