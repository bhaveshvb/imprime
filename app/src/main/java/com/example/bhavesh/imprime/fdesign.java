package com.example.bhavesh.imprime;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static android.R.id.progress;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fdesign.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fdesign#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fdesign extends Fragment implements View.OnClickListener{
    public static final String STORAGE_PATH_UPLOADS = "logos/";
    public static final String DATABASE_PATH_UPLOADS = "userinfo";
    private static final int PICK_IMAGE_REQUEST = 234;
    private ImageView user_image;
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14;
    private ImageView i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32;
    private Button b_choose, b_upload;
    private Uri userimagepath;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mdatabase;
    private StorageReference mstorageref;
    private byte[] data;
    private Transaction Handler;
   /* // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
*/
    public fdesign() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fdesign.
     */
   /* // TODO: Rename and change types and number of parameters
    public static fdesign newInstance(String param1, String param2) {
        fdesign fragment = new fdesign();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fdesign, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {

            startActivity(new Intent(getActivity(), LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        mdatabase = FirebaseDatabase.getInstance().getReference(DATABASE_PATH_UPLOADS);
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
        mstorageref = FirebaseStorage.getInstance().getReference();
        // Reference to an image file in Firebase Storage
        StorageReference storageReference = FirebaseStorage.getInstance().getReference(STORAGE_PATH_UPLOADS);

// ImageView in your Activity
         i1 = (ImageView) view.findViewById(R.id.l1);
         i2 = (ImageView) view.findViewById(R.id.l2);
         i3 = (ImageView) view.findViewById(R.id.l3);
         i4 = (ImageView) view.findViewById(R.id.l4);
         i5 = (ImageView) view.findViewById(R.id.l5);
         i6 = (ImageView) view.findViewById(R.id.l6);
         i7 = (ImageView) view.findViewById(R.id.l7);
         i8 = (ImageView) view.findViewById(R.id.l8);
         i9 = (ImageView) view.findViewById(R.id.l9);
         i10 = (ImageView) view.findViewById(R.id.l10);
         i11 = (ImageView) view.findViewById(R.id.l11);
         i12 = (ImageView) view.findViewById(R.id.l12);
         i13 = (ImageView) view.findViewById(R.id.l13);
         i14 = (ImageView) view.findViewById(R.id.l14);
         i15 = (ImageView) view.findViewById(R.id.l15);
         i16 = (ImageView) view.findViewById(R.id.l16);
         i17 = (ImageView) view.findViewById(R.id.l17);
         i18 = (ImageView) view.findViewById(R.id.l18);
         i19 = (ImageView) view.findViewById(R.id.l19);
         i20 = (ImageView) view.findViewById(R.id.l20);
         i21 = (ImageView) view.findViewById(R.id.l21);
         i22 = (ImageView) view.findViewById(R.id.l22);
         i23 = (ImageView) view.findViewById(R.id.l23);
         i24 = (ImageView) view.findViewById(R.id.l24);
         i25 = (ImageView) view.findViewById(R.id.l25);
         i26 = (ImageView) view.findViewById(R.id.l26);
         i27 = (ImageView) view.findViewById(R.id.l27);
         i28 = (ImageView) view.findViewById(R.id.l28);
         i29 = (ImageView) view.findViewById(R.id.l29);
         i30 = (ImageView) view.findViewById(R.id.l30);
         i31 = (ImageView) view.findViewById(R.id.l31);
         i32 = (ImageView) view.findViewById(R.id.l32);

// Load the image using Glide
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("hp.svg"))
                .into(i1);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("cn.svg"))
                .into(i2);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("apple.svg"))
                .into(i3);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("danger.svg"))
                .into(i4);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("ktm.png"))
                .into(i5);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("google.svg"))
                .into(i6);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("intel.svg"))
                .into(i7);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("lamborghini.svg"))
                .into(i8);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("udacity.svg"))
                .into(i9);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("wb.svg"))
                .into(i10);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("batman.gif"))
                .into(i11);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("arsenal.svg"))
                .into(i12);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("audi.svg"))
                .into(i13);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("chanel.svg"))
                .into(i14);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("csk.svg"))
                .into(i15);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("dell.svg"))
                .into(i16);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("fcb.svg"))
                .into(i17);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("ferrari.png"))
                .into(i18);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("batsuper.jpg"))
                .into(i19);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("gulf.svg"))
                .into(i20);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("ironman.jpeg"))
                .into(i21);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("kkr.svg"))
                .into(i22);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("github.png"))
                .into(i23);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("mi.svg"))
                .into(i24);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("oracle.svg"))
                .into(i25);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("playboy.svg"))
                .into(i26);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("porsche.svg"))
                .into(i27);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("realmadrid.svg"))
                .into(i28);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("rollsroyce.svg"))
                .into(i29);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("samsung.svg"))
                .into(i30);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("walkman.svg"))
                .into(i31);
        Glide.with(this.getContext())
                .using(new FirebaseImageLoader())
                .load(storageReference.child("bmw.jpg"))
                .into(i32);

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
        i11.setOnClickListener(this);
        i12.setOnClickListener(this);
        i13.setOnClickListener(this);
        i14.setOnClickListener(this);
        i15.setOnClickListener(this);
        i16.setOnClickListener(this);
        i17.setOnClickListener(this);
        i18.setOnClickListener(this);
        i19.setOnClickListener(this);
        i20.setOnClickListener(this);
        i21.setOnClickListener(this);
        i22.setOnClickListener(this);
        i23.setOnClickListener(this);
        i24.setOnClickListener(this);
        i25.setOnClickListener(this);
        i26.setOnClickListener(this);
        i27.setOnClickListener(this);
        i28.setOnClickListener(this);
        i29.setOnClickListener(this);
        i30.setOnClickListener(this);
        i31.setOnClickListener(this);
        i32.setOnClickListener(this);


        File localFile = null;
        try{
            localFile = File.createTempFile("images", "jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mstorageref.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });

        user_image = (ImageView) view.findViewById(R.id.user_imageView);
        b_choose = (Button) view.findViewById(R.id.choose);
        b_upload = (Button) view.findViewById(R.id.upload);

        b_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //choose an image
            showFileChooser();

            }
        });

        b_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //upload the image
                fileUploader();
                final ProgressDialog pdialog = new ProgressDialog(getActivity());
                pdialog.setTitle("Saving in database....");
                pdialog.show();

                new CountDownTimer(5000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        // You don't need anything here
                    }

                    public void onFinish() {
                        pdialog.dismiss();
                        Forder fragment = new Forder();
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fragment);
                        fragmentTransaction.commit();

                    }
                }.start();

            }
        });


    }

    private void fileUploader(){
        if (userimagepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.setTitle("Uploading....");
            progressDialog.show();

            StorageReference ulogo = mstorageref.child("userlogos/1.jpg");

            ulogo.putFile(userimagepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                progressDialog.dismiss();
                            Toast.makeText(getContext(), "File Uplaoded", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), exception.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                           /* double progress = (100.0 * taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage(((int) progress) + "%uploaded");*/
                        }
                    });
        }
    }

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select an Image"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
          userimagepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), userimagepath);
                user_image.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }

        }


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
            userlogoUploader();
        }
        else if (v == i2){
            // Get the data from an ImageView as bytes
            i2.setDrawingCacheEnabled(true);
            i2.buildDrawingCache();
            Bitmap bitmap = i2.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i3){
            // Get the data from an ImageView as bytes
            i3.setDrawingCacheEnabled(true);
            i3.buildDrawingCache();
            Bitmap bitmap = i3.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i4){
            // Get the data from an ImageView as bytes
            i4.setDrawingCacheEnabled(true);
            i4.buildDrawingCache();
            Bitmap bitmap = i4.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i5){
            // Get the data from an ImageView as bytes
            i5.setDrawingCacheEnabled(true);
            i5.buildDrawingCache();
            Bitmap bitmap = i5.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i6){
            // Get the data from an ImageView as bytes
            i6.setDrawingCacheEnabled(true);
            i6.buildDrawingCache();
            Bitmap bitmap = i6.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i7){
            // Get the data from an ImageView as bytes
            i7.setDrawingCacheEnabled(true);
            i7.buildDrawingCache();
            Bitmap bitmap = i7.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i8){
            // Get the data from an ImageView as bytes
            i8.setDrawingCacheEnabled(true);
            i8.buildDrawingCache();
            Bitmap bitmap = i8.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i9){
            // Get the data from an ImageView as bytes
            i9.setDrawingCacheEnabled(true);
            i9.buildDrawingCache();
            Bitmap bitmap = i19.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i10){
            // Get the data from an ImageView as bytes
            i10.setDrawingCacheEnabled(true);
            i10.buildDrawingCache();
            Bitmap bitmap = i10.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i11){
            // Get the data from an ImageView as bytes
            i11.setDrawingCacheEnabled(true);
            i11.buildDrawingCache();
            Bitmap bitmap = i11.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i12){
            // Get the data from an ImageView as bytes
            i12.setDrawingCacheEnabled(true);
            i12.buildDrawingCache();
            Bitmap bitmap = i12.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i13){
            // Get the data from an ImageView as bytes
            i13.setDrawingCacheEnabled(true);
            i13.buildDrawingCache();
            Bitmap bitmap = i13.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i14){
            // Get the data from an ImageView as bytes
            i14.setDrawingCacheEnabled(true);
            i14.buildDrawingCache();
            Bitmap bitmap = i14.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i15){
            // Get the data from an ImageView as bytes
            i15.setDrawingCacheEnabled(true);
            i15.buildDrawingCache();
            Bitmap bitmap = i15.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i16){
            // Get the data from an ImageView as bytes
            i16.setDrawingCacheEnabled(true);
            i16.buildDrawingCache();
            Bitmap bitmap = i16.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i17){
            // Get the data from an ImageView as bytes
            i17.setDrawingCacheEnabled(true);
            i17.buildDrawingCache();
            Bitmap bitmap = i17.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i18){
            // Get the data from an ImageView as bytes
            i18.setDrawingCacheEnabled(true);
            i18.buildDrawingCache();
            Bitmap bitmap = i18.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i19){
            // Get the data from an ImageView as bytes
            i19.setDrawingCacheEnabled(true);
            i19.buildDrawingCache();
            Bitmap bitmap = i19.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i20){
            // Get the data from an ImageView as bytes
            i20.setDrawingCacheEnabled(true);
            i20.buildDrawingCache();
            Bitmap bitmap = i20.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i21){
            // Get the data from an ImageView as bytes
            i21.setDrawingCacheEnabled(true);
            i21.buildDrawingCache();
            Bitmap bitmap = i21.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i22){
            // Get the data from an ImageView as bytes
            i22.setDrawingCacheEnabled(true);
            i22.buildDrawingCache();
            Bitmap bitmap = i22.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i23){
            // Get the data from an ImageView as bytes
            i23.setDrawingCacheEnabled(true);
            i23.buildDrawingCache();
            Bitmap bitmap = i23.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i24){
            // Get the data from an ImageView as bytes
            i24.setDrawingCacheEnabled(true);
            i24.buildDrawingCache();
            Bitmap bitmap = i24.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i25){
            // Get the data from an ImageView as bytes
            i25.setDrawingCacheEnabled(true);
            i25.buildDrawingCache();
            Bitmap bitmap = i25.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i26){
            // Get the data from an ImageView as bytes
            i26.setDrawingCacheEnabled(true);
            i26.buildDrawingCache();
            Bitmap bitmap = i26.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i27){
            // Get the data from an ImageView as bytes
            i27.setDrawingCacheEnabled(true);
            i27.buildDrawingCache();
            Bitmap bitmap = i27.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i28){
            // Get the data from an ImageView as bytes
            i28.setDrawingCacheEnabled(true);
            i28.buildDrawingCache();
            Bitmap bitmap = i28.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i29){
            // Get the data from an ImageView as bytes
            i29.setDrawingCacheEnabled(true);
            i29.buildDrawingCache();
            Bitmap bitmap = i29.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i30){
            // Get the data from an ImageView as bytes
            i30.setDrawingCacheEnabled(true);
            i30.buildDrawingCache();
            Bitmap bitmap = i30.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }else if (v == i31){
            // Get the data from an ImageView as bytes
            i31.setDrawingCacheEnabled(true);
            i31.buildDrawingCache();
            Bitmap bitmap = i31.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        else if (v == i32){
            // Get the data from an ImageView as bytes
            i32.setDrawingCacheEnabled(true);
            i32.buildDrawingCache();
            Bitmap bitmap = i32.getDrawingCache();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            data = baos.toByteArray();
            userlogoUploader();
        }
        //place your action here
        final ProgressDialog pdialog = new ProgressDialog(getActivity());
        pdialog.setTitle("Saving in database....");
        pdialog.show();

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                // You don't need anything here
            }

            public void onFinish() {
                pdialog.dismiss();
                Forder fragment = new Forder();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        }.start();
    }

    public void userlogoUploader(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Saving in database....");
        progressDialog.show();

        UploadTask uploadTask = mstorageref.child("userlogos/1").putBytes(data);
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

    /* @Override
    public void onClick(View v) {
        if (v == b_choose){
            //choose an image
        }
        else if (v == b_upload){
            //upload the image
        }
    }*/


/*    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    *//**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
