package com.example.pratyush.mytodo;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<TaskList> taskLists;

    public static final String EXTRA_TITLE="title";
    public static final String EXTRA_DESCRIPTION="description";

    public MyAdapter(Context c, ArrayList<TaskList> taskLists) {
        this.c = c;
        this.taskLists = taskLists;
    }
    //here we have implemented methods of VIEWHOLDER class an initializing viewholder

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //VIEW OBJECTS HERE
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        //HOLDER HOLDS THE DATAS
        MyHolder holder=new MyHolder(v);

        return holder;
    }
//this override method binds the datas to the views
    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.titletxt.setText(taskLists.get(position).getTitle());
//        holder.descriptiontxt.setText(taskLists.get(position).getDescription());

        //CLICKED ACTION WILL BE HAPPENED ON THIS CODE
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClick(View v, int pos) {
//                Snackbar.make(v,taskLists.get(pos).getTitle(),Snackbar.LENGTH_SHORT).show();
//
//            }
//        });
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent intent=new Intent(c,DetailActivity.class);
                TaskList taskList=taskLists.get(position);
                intent.putExtra(EXTRA_TITLE,taskList.getTitle());
                intent.putExtra(EXTRA_DESCRIPTION,taskList.getDescription());
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return taskLists.size();
    }
}
