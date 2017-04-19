package com.example.bhavesh.imprime;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.LoginFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fprofile extends Fragment {

    private Button logout;
    private TextView welcome;
    private TextView name, dob, loc, emailid;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private String dname, ddob, dloc, demail;

    public Fprofile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fprofile, container, false);
        // firebaseAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*signup = (Button) view.findViewById(R.id.signup_test_button);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //place your action here
                Intent i = new Intent(getActivity(), Signup.class);
                startActivity(i);*/
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
       /* DatabaseReference referencename = database.getReference("userinfo/aniket/name");
        DatabaseReference referencedob = database.getReference("userinfo/dob");
        DatabaseReference referenceloc = database.getReference("userinfo/location");
        DatabaseReference referenceemail = database.getReference("userinfo/email");
*/

        if (firebaseAuth.getCurrentUser() == null) {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        welcome = (TextView) view.findViewById(R.id.welcome);
        welcome.append(user.getEmail());

       // name = (TextView) view.findViewById(R.id.name_fp);
    /*    dob = (TextView) view.findViewById(R.id.dob_fp);
        loc = (TextView) view.findViewById(R.id.loc_fp);
        emailid = (TextView) view.findViewById(R.id.email_fp);*/
        //name.append(user.getDisplayName());


       /* // Read from the database
        referencename.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                dname = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        // Read from the database
        referencedob.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                ddob = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        // Read from the database
        referenceloc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                dloc = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        // Read from the database
        referenceemail.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                demail = dataSnapshot.getValue(String.class);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        name.setText(dname);
        dob.setText(ddob);
        loc.setText(dloc);
        emailid.setText(demail);*/


        logout = (Button) view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //place your action here
                getActivity().finish();
                Intent ilogout = new Intent(getActivity(), LoginActivity.class);
                startActivity(ilogout);

            }
        });
    }

}

