package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    RecyclerView recyclerView;
    public Context mCtx;
    public List<Category> categoryList;
    public Category category;

    public  CategoryAdapter(Context mCtx,List<Category> categoryList){
        this.mCtx=mCtx;
        this.categoryList=categoryList;

    }



    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.category_cardview,null);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

          category=categoryList.get(position);
        holder.title.setText(category.getTitle());
        String tttile=category.getTitle();
        Picasso.with(mCtx)
                .load(category.getImgUrl())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(mCtx, MediList.class);
                intent.putExtra("id",  tttile); // put image data in Intent
                mCtx.startActivity(intent); // start Intent
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;

        public CategoryViewHolder(View itemView)

        {
            super(itemView);

            title=itemView.findViewById(R.id.TitleCategory);
            img=itemView.findViewById(R.id.iconcard);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition();
//                    Category clickedDataItem = categoryList.get(pos);
//
//                    System.out.println("can u see me i am title "+category.getTitle());
//                    //int position=recyclerView.getChildLayoutPosition(v);
//              //   Category temp=categoryList.get(position);
//                    // Uri.parse(temp);
//                   /* Intent i=new Intent(Intent.ACTION_SEND);
//                    i.setType("text/plain");
//                    i.putExtra(i.hgjhjgfhhgjEXTRA_TEXT,temp);
//                    i.setPackage("com.whatsapp");
//                    context.startActivity(i);
//                    */
//                   Intent intent=new Intent();
//                    Intent i = new Intent(mCtx, MediList.class);
//                    i.putExtra("id", String.valueOf(category.getTitle()));
//                    mCtx.startActivity(i);
//
//
//                }
//            });
        }



    }
}
