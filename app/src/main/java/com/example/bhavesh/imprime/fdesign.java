package com.example.bhavesh.imprime;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

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
            //place your action here
            Forder fragment = new Forder();
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
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
