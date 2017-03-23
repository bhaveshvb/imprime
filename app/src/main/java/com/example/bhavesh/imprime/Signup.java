package com.example.bhavesh.imprime;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity implements View.OnClickListener{

    private EditText email_ET;
    private EditText password_ET;
    private Button submit;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        submit = (Button) findViewById(R.id.signup_button);
        submit.setOnClickListener(this);
/*        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createuser();
            }
        });*/
    }

            private void createuser() {
                email_ET = (EditText) findViewById(R.id.email_et);
                password_ET = (EditText) findViewById(R.id.password_et);

                String email = email_ET.getText().toString();
                String password = password_ET.getText().toString();

               // firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(Signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(Signup.this, "Failed to Register. Please try again!", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                        });
            }

    @Override
    public void onClick(View v) {
        if (v == submit){
            createuser();
        }
    }
}
