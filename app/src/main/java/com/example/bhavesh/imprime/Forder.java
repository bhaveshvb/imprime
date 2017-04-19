package com.example.bhavesh.imprime;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class Forder extends Fragment implements View.OnClickListener{

    private ImageView product, logo;
    private Button order;
    private FirebaseAuth firebaseAuth;
    private StorageReference mstorageref;

    public Forder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forder, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        mstorageref = FirebaseStorage.getInstance().getReference();

        product = (ImageView) view.findViewById(R.id.imageView_product);
        logo = (ImageView) view.findViewById(R.id.imageView_logo);
        order = (Button) view.findViewById(R.id.button_order);

        // Load the image using Glide
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(mstorageref.child("usertshirts/1"))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(product);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(mstorageref.child("userlogos/1"))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .signature(new StringSignature(String.valueOf("1")))
                .signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                .into(logo);

        order.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == order){
            Fprofile fragment = new Fprofile();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }
}
