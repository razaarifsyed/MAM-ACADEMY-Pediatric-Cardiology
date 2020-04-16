package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;

//import android.support.annotation.NonNull;

//import android.v7.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

public class addlec extends AppCompatActivity {

    EditText editText;
    EditText editText14;
    EditText editText2;
    EditText editText5;
    EditText editText6;
    Button button3;



    DatabaseReference databaseReports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlec);





        setTitle("Add a New Lecture");


        editText14 = (EditText) findViewById(R.id.editText14);
        editText = (EditText) findViewById(R.id.editTextDisplayName);
        editText2 = (EditText) findViewById(R.id.editText);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);



        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save1111();
                //open1222();

            }
        });


        databaseReports = FirebaseDatabase.getInstance().getReference("lecs");

    }

    private void save1111() {

        Date currentTime = Calendar.getInstance().getTime();

        String dname = editText.getText().toString().trim();

        String dhid = editText2.getText().toString().trim();
        String dds = editText5.getText().toString().trim();
        String dpn = editText6.getText().toString().trim();
        String deml = editText14.getText().toString().trim();
        String ltm = currentTime.toString();

String ldsc="";




        if (!TextUtils.isEmpty(dname)&&!TextUtils.isEmpty(dhid)&&!TextUtils.isEmpty(dds)) {

            String id = databaseReports.push().getKey();

            //creating an Artist Object
            lecs lecs = new lecs(id,dname,dhid,dds,dpn,deml,ldsc,ltm);

            //Saving the Artist
            databaseReports.child(id).setValue(lecs);


//send id
            Intent intent = new Intent(this, desc.class);

            intent.putExtra("bucketno",id);
            //finish();
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        } else {



            editText.requestFocus();

            Toast.makeText(this, "Please enter all boxes", Toast.LENGTH_LONG).show();
        }
    }

    public void open1222() {

        Intent intent = new Intent(this, desc.class);
        //finish();
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
       // Toast.makeText(this, "Lecture Added!", Toast.LENGTH_LONG).show();


    }
}