package com.example.bhavesh.imprime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Signup extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText name_ET, dob_ET, contact_ET, confirm_password_ET;
    private EditText email_ET;
    private EditText password_ET;
    private RadioGroup gender_ET;
    private RadioButton male_ET, female_ET, gen_ET;
    private Spinner location_ET;
    private Button submit;
    private String loc;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        submit = (Button) findViewById(R.id.signup_button);
        submit.setOnClickListener(this);
/*        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createuser();
            }
        });*/
        location_ET = (Spinner) findViewById(R.id.spinner_et);
        location_ET.setOnItemSelectedListener(this);

        // Spinner Drop down elements
     /*   List<String> loc = new ArrayList<String>();
        loc.add("Mumbai");
        loc.add("Pune");
        loc.add("Banglore");
        loc.add("Kolkata");
*/
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        location_ET.setAdapter(adapter);

    }


    private void createuser() {
        email_ET = (EditText) findViewById(R.id.email_et);
        password_ET = (EditText) findViewById(R.id.password_et);

        gender_ET = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = gender_ET.getCheckedRadioButtonId();
        gen_ET = (RadioButton) findViewById(selectedId);
        male_ET = (RadioButton) findViewById(R.id.male_radio);
        female_ET = (RadioButton) findViewById(R.id.female_radio);

        //  String loc = location_ET.getText().toString;

        name_ET = (EditText) findViewById(R.id.name_et);
        dob_ET = (EditText) findViewById(R.id.date_et);
        contact_ET = (EditText) findViewById(R.id.contact_et);
        confirm_password_ET = (EditText) findViewById(R.id.confirm_pass_et);

        String email = email_ET.getText().toString();
        String password = password_ET.getText().toString();

        // firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Signup.this, "Registered Successfully. Login to Continue", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(Signup.this, LoginActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(Signup.this, "Failed to Register. Please try again!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }

    private void SaveSigupDetails(){

        FirebaseUser user = firebaseAuth.getCurrentUser();

       // String userid = user.getUid().toString();
        String userid = name_ET.getText().toString().trim();

        String name = name_ET.getText().toString().trim();
        String dob = dob_ET.getText().toString().trim();
        String gender = gen_ET.getText().toString().trim();
        //String fgender = female_ET.getText().toString().trim();
        String location = loc.trim();
        String contact = contact_ET.getText().toString().trim();
        String email = name_ET.getText().toString().trim();
        String password = password_ET.getText().toString().trim();
        String cnfpassword = confirm_password_ET.getText().toString().trim();
        Toast.makeText(this, userid, Toast.LENGTH_LONG).show();

        SignupDetails signupDetails = new SignupDetails(userid, name, dob, gender, location, contact, email, password, cnfpassword);



        //databaseReference.child("userinfo").child(user.getUid()).setValue(signupDetails);
        databaseReference.child("userinfo").child(userid).setValue(signupDetails);

        Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onClick(View v) {
        if (v == submit){
            createuser();
            SaveSigupDetails();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        loc = item;

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onBackPressed() {
        finish();
       Intent i = new Intent(Signup.this, LoginActivity.class);
        startActivity(i);
    }
}
