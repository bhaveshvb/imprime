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


/**
 * A simple {@link Fragment} subclass.
 */
public class Fprofile extends Fragment {

    private Button logout;
    private TextView welcome;
    private FirebaseAuth firebaseAuth;

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

        if (firebaseAuth.getCurrentUser() == null) {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
            welcome = (TextView) view.findViewById(R.id.welcome);
            welcome.append(user.getEmail());


        logout = (Button) view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //place your action here
                Intent ilogout = new Intent(getActivity(), LoginActivity.class);
                startActivity(ilogout);

            }
        });
    }
}

