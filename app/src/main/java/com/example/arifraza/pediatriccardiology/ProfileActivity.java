package com.example.arifraza.pediatriccardiology;


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
import android.widget.TextView;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class ProfileActivity extends AppCompatActivity {



  //  TextView textView2;

    EditText editText;
    EditText editText14;
    EditText editText2;
    EditText editText5;
    EditText editText6;
    Button button8;
    Button buttonSave;
    //ProgressBar progressBar;



    FirebaseAuth mAuth;
    DatabaseReference databaseReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        setTitle("Profile");
        mAuth = FirebaseAuth.getInstance();




        editText14 = (EditText) findViewById(R.id.editText14);
        editText = (EditText) findViewById(R.id.editTextDisplayName);
        editText2 = (EditText) findViewById(R.id.editText);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);

        // progressBar = (ProgressBar) findViewById(R.id.progressbar);
       // textView2 = (TextView) findViewById(R.id.textView2);
        //loadUserInformation();
        //opennx3();



        opennx2();
        //opennx3();
        //opennx2();


        // finish();
        //Toast.makeText(ProfileActivity.this, "Application Minimized", Toast.LENGTH_SHORT).show();

        final FirebaseUser user366 = mAuth.getCurrentUser();
        editText14.setText(user366.getEmail().toString());

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlol();
            }
        });


        databaseReports = FirebaseDatabase.getInstance().getReference("users");

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInformation();
                //if filled then  only make next visible







               // button8.setVisibility(View.VISIBLE);
                save111();
               // buttonSave.setVisibility(View.INVISIBLE);
            }
        });

    }



    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivitynew.class));
        }
    }


    private void loadUserInformation() {
        final FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {

            if (user.getDisplayName() != null) {
                editText.setText(user.getDisplayName());

            }

        }

    }


    private void saveUserInformation() {


        String displayName = editText.getText().toString();
        String dhid2 = editText2.getText().toString().trim();
        String dds2 = editText5.getText().toString().trim();


        if (displayName.isEmpty()||dhid2.isEmpty()||dds2.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null ) {
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)

                    .build();

            user.updateProfile(profile)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(ProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
        }




    }
    //to goto main
    public void opennxt1() {

        Intent intent = new Intent(this, MainActivity.class);
        //finish();
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);



    }

    public void opennx2() {


        final FirebaseUser user2 = mAuth.getCurrentUser();

        if (user2.getDisplayName() != null) {
//add last seen



            Intent intent = new Intent(this, MainActivity.class);


            startActivity(intent);





        }}

    private void save111() {
        String dname = editText.getText().toString().trim();

        Date currentTime = Calendar.getInstance().getTime();
        String dhid = editText2.getText().toString().trim();
        String dds = editText5.getText().toString().trim();
        String dpn = editText6.getText().toString().trim();
        String deml = editText14.getText().toString().trim();
        String udt = currentTime.toString();


        if (!TextUtils.isEmpty(dname)&&!TextUtils.isEmpty(dhid)&&!TextUtils.isEmpty(dds)&&!TextUtils.isEmpty(dpn)) {
            button8.setVisibility(View.VISIBLE);
            buttonSave.setVisibility(View.INVISIBLE);

            String id = databaseReports.push().getKey();

            //creating an Artist Object
            user user = new user(id,dname,dhid,dds,dpn,deml,udt);

            //Saving the Artist
            databaseReports.child(id).setValue(user);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (!isFinishing()){
                        new AlertDialog.Builder(ProfileActivity.this)
                                .setTitle("Profile Information")
                                .setMessage("Account Successfully Created  "+"\n"+"Tap on 'Next' to continue ...")
                                .setCancelable(false)
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Whatever...
                                    }
                                }).show();

                    }
                }
            });






//opennxt1();

            //displaying a success toast
            //Toast.makeText(this, "Profile Updated", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            //focus


            editText.requestFocus();

            Toast.makeText(this, "Please enter all boxes", Toast.LENGTH_LONG).show();
        }



        // Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
    }

    public void openlol() {


//if filled then  only make next visible
        /*
        String displayName5 = editText.getText().toString();
        String dhid25 = editText2.getText().toString().trim();
        String dds25 = editText5.getText().toString().trim();


        if (!TextUtils.isEmpty(displayName5)&&!TextUtils.isEmpty(dhid25)&&!TextUtils.isEmpty(dds25)) {

            opennxt1();
        }


        else
        {
            Toast.makeText(this, "Fill everything, then click next again.", Toast.LENGTH_LONG).show();
        }

*/
        opennxt1();



    }

    public void opennx3() {

        final FirebaseUser user22 = mAuth.getCurrentUser();
        editText.setText(user22.getDisplayName());





    }




    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuLogout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivitynew.class));

                break;
        }

        return true;
    }
*/


    public void open5344() {
//for lastseen
        Query query= FirebaseDatabase.getInstance().getReference("users")
                .orderByChild("deml")
                .equalTo(editText14.getText().toString());


       // query.addListenerForSingleValueEvent(valueEventListener);


    }



}