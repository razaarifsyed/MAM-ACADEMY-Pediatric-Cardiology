package com.example.arifraza.pediatriccardiology;



import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;
import java.util.Date;


public class MainActivitynew extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;
    ProgressBar progressBar;
    private Button btnReset;
    //String message = "No new messages";
    String fir = "No new messages 1";
    String sec = "No new messages 2";
String o="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitynew);
open333();

        setTitle("Login Window");



        mAuth = FirebaseAuth.getInstance();

        btnReset = (Button) findViewById(R.id.buttonfgt);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        findViewById(R.id.textViewSignup).setOnClickListener(this);
        findViewById(R.id.buttonLogin).setOnClickListener(this);





        //forgot pass

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter the registered email ID first", Toast.LENGTH_SHORT).show();
                    return;
                }


                mAuth.sendPasswordResetEmail(email)

                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplication(), "Check your registered email inbox to reset your password!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplication(), "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                }


                            }
                        });
            }
        });

        //forgot pass





    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Minimum length of password should be 6");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(MainActivitynew.this, ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

//bug here
        if (getIntent().getExtras() != null) {
                //&& getIntent().getExtras().isEmpty()) {

            Bundle extras = getIntent().getExtras();
            fir= extras.getString("first");
             sec = extras.getString("second");

        //     if(fir!=null) {

                 Intent intent = new Intent(this, pushnt.class);
                 Bundle extras2 = new Bundle();
                 extras2.putString("f1", fir);
                 extras2.putString("s2", sec);
                 intent.putExtras(extras2);
                 startActivity(intent);
          //   }
            // else
             //{
               //  String g="";
             //}
           // message = getIntent().getExtras().getString("message");



           // Intent intent = new Intent(this, pushnt.class);


           // intent.putExtra("bucketno",message);
            //startActivity(intent);


           // if (message == null) {
             //   message = "No New Message";
              //  Toast.makeText(MainActivitynew.this, "No New Message", Toast.LENGTH_SHORT).show();
           // }

        } else {

            if (mAuth.getCurrentUser() != null) {
                finish();
                startActivity(new Intent(this, ProfileActivity.class));
            }
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textViewSignup:
                finish();
                startActivity(new Intent(this, SignUpActivity.class));
                break;

            case R.id.buttonLogin:
                userLogin();
                break;
        }
    }

    public void open333()
    {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean agreed = sharedPreferences.getBoolean("agreed",false);
        if (!agreed) {
            final AlertDialog d = new AlertDialog.Builder(this)
                    .setTitle("License agreement")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("agreed", true);
                            editor.commit();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("agreed", false);
                            editor.commit();

                            finish();
                            System.exit(0);


                        }
                    })
                    .setMessage(Html.fromHtml("The app EXPRESSLY DISCLAIMS ALL WARRANTIES OF ANY KIND, WHETHER EXPRESS OR IMPLIED.  We do not take responsibility for decisions taken by the user based solely on the information provided in this app. "+"\n"+"\n"+"<br>By clicking on 'YES', You agree to our conditions, and consent to our <a href=\"https://drive.google.com/open?id=1QCHh3GlrYe2GBqee-RrNOUKbUqWjinyUmFK1v1Kiv18\">Disclaimer </a> and <a href=\"https://drive.google.com/open?id=1DUTNeE5QUJiEY3Ub6dzYfzJi7MwvJ31I9f4M87TGdrk\">Privacy Policy</a>. "))
                    .show();

            ((TextView)d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

        }



    }


    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        Toast.makeText(this, "App closed!", Toast.LENGTH_LONG).show();


        //  finish();
       // System.exit(0);
    //    Toast.makeText(this, "App closed!", Toast.LENGTH_LONG).show();
    }

}
