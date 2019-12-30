package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yourmeditationguru.saurabhthesuperhero.SecondActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class musicListAdapter extends RecyclerView.Adapter<musicListAdapter.MyViewHolder> {

    ArrayList personNames;
    ArrayList personImages;
    Context context;

    public musicListAdapter( Context context,ArrayList personNames, ArrayList personImages) {
        this.personNames = personNames;
        this.personImages = personImages;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }


    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemname.setText((CharSequence) personNames.get(position));
        Picasso.with(context)
                .load((String) personImages.get(position))
                .into(holder.itemimage);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", (String) personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }


    @Override
    public int getItemCount() {
        return personNames.size();   }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView itemname;
        ImageView itemimage;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            itemname = (TextView) itemView.findViewById(R.id.itemtitle);
            itemimage = (ImageView) itemView.findViewById(R.id.itemimage);
        }
    }

}
