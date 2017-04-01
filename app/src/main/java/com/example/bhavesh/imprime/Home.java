package com.example.bhavesh.imprime;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private Button viewall;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthlistener;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        mAuthlistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:"+user.getUid());
                } else{
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                }
            };
        viewall = (Button) view.findViewById(R.id.view_all);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //place your action here
                Ftype fragment = new Ftype();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthlistener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthlistener != null) {
            mAuth.removeAuthStateListener(mAuthlistener);
        }
    }


}