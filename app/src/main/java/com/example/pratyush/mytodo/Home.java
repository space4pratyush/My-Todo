package com.example.pratyush.mytodo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity{

    EditText title, description;
    FloatingActionButton fab;
    RecyclerView rv;
    MyAdapter adapter;

    ArrayList<TaskList> taskLists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d=new Dialog(Home.this);
                d.requestWindowFeature(Window.FEATURE_NO_TITLE);
                d.setContentView(R.layout.layout_custom_dialog);
                title=d.findViewById(R.id.title);
                description=d.findViewById(R.id.description);
                Button save=d.findViewById(R.id.save);
                final Button retrieve=d.findViewById(R.id.retrieve);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        save(title.getText().toString(), description.getText().toString());
                    }
                });
                retrieve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        retrieve();
                    }
                });
                d.show();

            }
        });
        //Recycler setting
        rv=findViewById(R.id.recyclerView);
//        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
//        rv.setItemAnimator(new DefaultItemAnimator());

        //Adapter setting
        adapter=new MyAdapter(this,taskLists);
        retrieve();
    }
    private void save(String stitle, String sdescription){
        DBAdapter db=new DBAdapter(Home.this);
        //open the database
        db.openDB();
        //commit
        long result=db.add(stitle,sdescription);
        if (result>0){
            title.setText("");
            description.setText("");
        }
        else{
            Snackbar.make(title,"Unable to save data", Snackbar.LENGTH_SHORT).show();
        }
        db.closeDB();
        //ReFresh
        retrieve();
    }
    private void retrieve() {
        taskLists.clear();
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        Cursor c = db.getAllTask();
        //Loop and add to arraylist
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String title = c.getString(1);
            String description = c.getString(2);
            TaskList t = new TaskList(id, title, description);
            //Add to arraylist
            taskLists.add(t);
        }
        if (!(taskLists.size()<1)){
            rv.setAdapter(adapter);
        }
        db.closeDB();
    }
}
