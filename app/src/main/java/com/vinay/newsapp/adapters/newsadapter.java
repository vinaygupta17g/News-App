package com.vinay.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinay.newsapp.DetailActivity;
import com.vinay.newsapp.R;
import com.vinay.newsapp.models.newsmodel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class newsadapter extends RecyclerView.Adapter<newsadapter.viewHolder>{
    ArrayList<newsmodel> list;
    Context context;
    public newsadapter(ArrayList<newsmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_demo,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        newsmodel model= list.get(position);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, DetailActivity.class);
                intent.putExtra("title",model.getTitle());
                intent.putExtra("image",model.getImage());
                intent.putExtra("description",model.getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView title,description;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTextView);
            description=itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
