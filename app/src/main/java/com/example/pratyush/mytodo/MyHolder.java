package com.example.pratyush.mytodo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

//this class holds all our views and they all will be recycled. Here we can also implement Views.onItemClick Listener
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView titletxt, descriptiontxt;
    ItemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);
        titletxt=itemView.findViewById(R.id.cardtitle);
        descriptiontxt=itemView.findViewById(R.id.carddescription);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }
    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener=ic;
    }
}
