package com.example.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public RecyclerAdapter(Context context) {
        this.context = context;
    }
    private Context context;

    private String[] titles = {"Chocolate One", "Chocolate Cake", "Chocolate Macaron", "Chocolate Cafe Website"};

    private String[] details = {"Chocolate One", "Chocolate Cake", "Chocolate Macaron", "Chocolate Cafe Website"};

    private int[] images = {
        R.drawable.ic_launcher,
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout,viewGroup, false) ;
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[0]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position == 3) {
                        Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.chocolatharlem.com"));
                        v.getContext().startActivity(intent);
                    }
                    else {
                        Intent intent = new Intent(context,SecondActivity.class );
                        Bundle bundle = new Bundle();
                        bundle.putString("title", titles[position]);
                        bundle.putInt("image",position);
                        intent.putExtras(bundle);
                        context.startActivity(intent);                    }
                }
            });
        }
    }
}
