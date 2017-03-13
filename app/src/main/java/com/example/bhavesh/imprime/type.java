package com.example.bhavesh.imprime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class type extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getIntent().getExtras()!=null)
        {
            String s1 = getIntent().getStringExtra("key");
            Toast.makeText(this, s1, Toast.LENGTH_LONG).show();
        }

/*    Bundle b = getIntent().getBundleExtra("key3");
        String s1 = b.getString("key");
        int num1 = b.getInt("key2");*/

     //   Toast.makeText(this, "nanananna", Toast.LENGTH_LONG).show();


    }

}
