package com.example.bhavesh.imprime;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

import static com.example.bhavesh.imprime.fdesign.DATABASE_PATH_UPLOADS;


public class Ftype extends Fragment implements View.OnClickListener{
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10;
    private FirebaseAuth firebaseAuth;
   // private Uri userproductpath;
    StorageReference storageReference, mstorageref;
    byte[] data;

    public Ftype() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ftype, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        String name = user.getEmail().toString().trim();
//        mdatabase = FirebaseDatabase.getInstance().getReference(DATABASE_PATH_UPLOADS);
        // Read from the database
/*        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/

        //  mstorageref = FirebaseStorage.getInstance().getReference(STORAGE_PATH_UPLOADS);
        // mstorageref = FirebaseStorage.getInstance().getReference();
        // Reference to an image file in Firebase Storage
        storageReference = FirebaseStorage.getInstance().getReference("tshirts/");
        mstorageref = FirebaseStorage.getInstance().getReference("usertshirts/");

// ImageView in your Activity
        i1 = (ImageView) view.findViewById(R.id.i1);
        i2 = (ImageView) view.findViewById(R.id.i2);
        i3 = (ImageView) view.findViewById(R.id.i3);
        i4 = (ImageView) view.findViewById(R.id.i4);
        i5 = (ImageView) view.findViewById(R.id.i5);
        i6 = (ImageView) view.findViewById(R.id.i6);
        i7 = (ImageView) view.findViewById(R.id.i7);
        i8 = (ImageView) view.findViewById(R.id.i8);
        i9 = (ImageView) view.findViewById(R.id.i9);
        i10 = (ImageView) view.findViewById(R.id.i10);

        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("b-t-shirt.jpg"))
                .into(i1);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("bwtshirt.jpeg"))
                .into(i2);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("g-t-shirt.jpg"))
                .into(i3);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("h1.jpg"))
                .into(i4);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("h2.jpg"))
                .into(i5);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("h3.jpg"))
                .into(i6);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("redtshirt.jpg"))
                .into(i7);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("y-t-shirt.jpg"))
                .into(i8);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("otshirt.jpg"))
                .into(i9);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("Whitejersey.jpg"))
                .into(i10);

       /* i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the data from an ImageView as bytes
                i1.setDrawingCacheEnabled(true);
                i1.buildDrawingCache();
                Bitmap bitmap = i1.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                data = baos.toByteArray();
                fileUploader();
                //place your action here
                fdesign fragment = new fdesign();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });*/
            i1.setOnClickListener(this);
            i2.setOnClickListener(this);
            i3.setOnClickListener(this);
            i4.setOnClickListener(this);
            i5.setOnClickListener(this);
            i6.setOnClickListener(this);
            i7.setOnClickListener(this);
            i8.setOnClickListener(this);
            i9.setOnClickListener(this);
            i10.setOnClickListener(this);


    }

    private void fileUploader() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Saving in database....");
        progressDialog.show();

        UploadTask uploadTask = mstorageref.child("1").putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                progressDialog.dismiss();
                Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_LONG).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                progressDialog.dismiss();
               // Toast.makeText(getContext(), "Success! Now select a design", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == i1){
            // Get the data from an ImageView as bytes
            i1.setDrawingCacheEnabled(true);
            i1.buildDrawingCache();
            Bitmap bitmap = i1.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i2){
            // Get the data from an ImageView as bytes
            i2.setDrawingCacheEnabled(true);
            i2.buildDrawingCache();
            Bitmap bitmap = i2.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i3){
            // Get the data from an ImageView as bytes
            i3.setDrawingCacheEnabled(true);
            i3.buildDrawingCache();
            Bitmap bitmap = i3.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i4){
            // Get the data from an ImageView as bytes
            i4.setDrawingCacheEnabled(true);
            i4.buildDrawingCache();
            Bitmap bitmap = i4.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i5){
            // Get the data from an ImageView as bytes
            i5.setDrawingCacheEnabled(true);
            i5.buildDrawingCache();
            Bitmap bitmap = i5.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i6){
            // Get the data from an ImageView as bytes
            i6.setDrawingCacheEnabled(true);
            i6.buildDrawingCache();
            Bitmap bitmap = i6.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i7){
            // Get the data from an ImageView as bytes
            i7.setDrawingCacheEnabled(true);
            i7.buildDrawingCache();
            Bitmap bitmap = i7.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i8){
            // Get the data from an ImageView as bytes
            i8.setDrawingCacheEnabled(true);
            i8.buildDrawingCache();
            Bitmap bitmap = i8.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i9){
            // Get the data from an ImageView as bytes
            i9.setDrawingCacheEnabled(true);
            i9.buildDrawingCache();
            Bitmap bitmap = i9.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }
        else if (v == i10){
            // Get the data from an ImageView as bytes
            i10.setDrawingCacheEnabled(true);
            i10.buildDrawingCache();
            Bitmap bitmap = i10.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            fileUploader();
        }

        //place your action here
        fdesign fragment = new fdesign();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}