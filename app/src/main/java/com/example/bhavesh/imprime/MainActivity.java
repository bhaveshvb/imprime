package com.example.bhavesh.imprime;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String key = "key";
    private static final String key2 = "key2";
    private ImageView tshirt;
    private ImageView home;
    private ImageView design;
    private ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Home fragment = new Home();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();




        tshirt = (ImageView) findViewById(R.id.ptype);
        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ptype = new Intent(MainActivity.this,type.class);
              /*  Bundle b = new Bundle();
                b.putString(key, "This is type  activity");
                b.putInt(key2, 350);
                b.putBundle("key3", b);*/
                //ptype.putExtra(key,"this is from main");
               // startActivity(ptype);
                fragment_action(R.id.ftype);
            }
        });

        design = (ImageView) findViewById(R.id.design);
        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ptype = new Intent(MainActivity.this,type.class);
              /*  Bundle b = new Bundle();
                b.putString(key, "This is type  activity");
                b.putInt(key2, 350);
                b.putBundle("key3", b);*/
                //ptype.putExtra(key,"this is from main");
                // startActivity(ptype);
                fragment_action(R.id.fdesign);
            }
        });

        profile = (ImageView) findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ptype = new Intent(MainActivity.this,type.class);
              /*  Bundle b = new Bundle();
                b.putString(key, "This is type  activity");
                b.putInt(key2, 350);
                b.putBundle("key3", b);*/
                //ptype.putExtra(key,"this is from main");
                // startActivity(ptype);
                fragment_action(R.id.fprofile);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void fragment_action(int frag_id)
    {
        if (frag_id == R.id.fhome){

            Home fragment = new Home();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        else if (frag_id == R.id.fdesign){

            fdesign fragment = new fdesign();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        else if (frag_id == R.id.ftype){

            Ftype fragment = new Ftype();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        else if (frag_id == R.id.fprofile){

            Fprofile fragment = new Fprofile();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

}
