package com.example.pratyush.mytodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.pratyush.mytodo.MyAdapter.EXTRA_DESCRIPTION;
import static com.example.pratyush.mytodo.MyAdapter.EXTRA_TITLE;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_view);
        Intent intent=getIntent();
        String title=intent.getStringExtra(EXTRA_TITLE);
        String description=intent.getStringExtra(EXTRA_DESCRIPTION);

        TextView title1=findViewById(R.id.cardtitle);
        TextView description1=findViewById(R.id.carddescription);
        title1.setText(title);
        description1.setText(description);
    }
}
