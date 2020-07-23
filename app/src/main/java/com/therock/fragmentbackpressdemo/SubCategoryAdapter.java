package com.therock.fragmentbackpressdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private ArrayList<String> arraylist_subcat_name;
    Context ctx;

    public  class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_description,user_name;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.user_name =  itemView.findViewById( R.id.user_name);
            this.user_description =  itemView.findViewById( R.id.user_description);
            this.imageViewIcon =  itemView.findViewById(R.id.imageView);

        }
    }

    public SubCategoryAdapter(Context ctx, ArrayList<String> arraylist_subcat_name) {
        this.arraylist_subcat_name = arraylist_subcat_name;
        this.ctx=ctx;

    }

    @Override
    public SubCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        SubCategoryAdapter.MyViewHolder myViewHolder = new SubCategoryAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final SubCategoryAdapter.MyViewHolder holder, final int listPosition) {

        TextView user_name = holder.user_name;
        TextView user_description = holder.user_description;
      //  Log.e( "desc-",subdescriptioinList.get( listPosition ) );

        user_name.setText(arraylist_subcat_name.get(listPosition).toString());


    }

    @Override
    public int getItemCount() {
        return arraylist_subcat_name.size();
    }
}
