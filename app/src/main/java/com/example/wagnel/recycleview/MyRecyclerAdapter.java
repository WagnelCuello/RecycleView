package com.example.wagnel.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyRecycleItemViewHolder> {

    private final ArrayList<Marca> items;
    private final Context context;

    public MyRecyclerAdapter(Context context , ArrayList<Marca> items){
        this.context = context;
        this.items = items;
    }

    @Override public int getItemViewType(int position){
        if (position == 0){
            return R.layout.activity_recycler_layout_header;
        }else if (position % 2 == 0){
            return R.layout.activity_recycler_layout_body;
        }else {
            return R.layout.activity_recycler_layout_foot;
        }
    }

    @Override public MyRecycleItemViewHolder onCreateViewHolder(ViewGroup parent, int layout) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        MyRecycleItemViewHolder holder = new MyRecycleItemViewHolder(view);
        return holder;
    }
    @Override public void onBindViewHolder(MyRecycleItemViewHolder holder, int position) {
        holder.marca.setText(items.get(position).getMarca());
        holder.marca.setTag(items.get(position).getMarca());
        holder.pais.setText(items.get(position).getPais());
        holder.pais.setTag(items.get(position).getPais());

        holder.marca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.pais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override  public int getItemCount() {  return items.size(); }

    public static class MyRecycleItemViewHolder extends RecyclerView.ViewHolder {

        public TextView marca;
        public TextView pais;

        public MyRecycleItemViewHolder(View itemView) {
            super(itemView);
            marca = itemView.findViewById(R.id.tvMarca);
            pais = itemView.findViewById(R.id.tvPais);
        }
    }
}
