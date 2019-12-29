package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import android.content.Context;
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

    private Context mCtx;
    private List<Category> categoryList;


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

        Category category=categoryList.get(position);

        holder.title.setText(category.getTitle());

        Picasso.with(mCtx)
                .load(category.getImgUrl())
                .into(holder.img);

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

        }
    }
}
