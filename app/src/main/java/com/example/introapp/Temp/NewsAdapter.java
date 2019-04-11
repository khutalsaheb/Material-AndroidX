package com.example.introapp.Temp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.introapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private final List<News> mNews;
    private final Context context;
    private final ChangeStatusListener listener;
    private int mNumberItems;

    public NewsAdapter(Context context, int numberOfItems, ArrayList<News> news, ChangeStatusListener listener) {
        mNumberItems = numberOfItems;
        mNews = news;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.v("onCreateViewHolder", "onCreateViewHolder is called !");
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.backdrops, viewGroup, false);

        return new NewsViewHolder(view);

    }

    //onBindViewHolder()
    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News news = mNews.get(position);
        TextView textView = holder.listItemNumberView;
        textView.setText(news.getName());
        textView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InflateParams")
            @Override
            public void onClick(View v) {
                listener.ChangeStatus(news);
            }
        });

    }

    @Override
    public int getItemCount() {
        mNumberItems = mNews.size();
        return mNumberItems;
    }

    public interface ChangeStatusListener {
        void ChangeStatus(News product);

    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        final TextView listItemNumberView;

        NewsViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = itemView.findViewById(R.id.title);
        }

    }

}