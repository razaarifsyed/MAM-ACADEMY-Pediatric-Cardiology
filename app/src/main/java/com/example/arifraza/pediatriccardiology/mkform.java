package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class mkform extends AppCompatActivity {
    EditText editText13;
    EditText editText15;
    Button button18;
    DatabaseReference databaseReports;
    FirebaseAuth mAuth4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mkform);
        setTitle("Post New Message");
        editText13 = (EditText) findViewById(R.id.editText13);
        editText15 = (EditText) findViewById(R.id.editText15);


        databaseReports = FirebaseDatabase.getInstance().getReference("form");

        mAuth4 = FirebaseAuth.getInstance();
        open2y();
        button18 = (Button) findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opener();
            }
        });

    }






    public void opener() {


        String dname = editText13.getText().toString().trim();




        Date currentTime22 = Calendar.getInstance().getTime();
        String deml = currentTime22.toString();
        String dhid = editText15.getText().toString().trim();
        final FirebaseUser user444 = mAuth4.getCurrentUser();
        String seml = user444.getEmail().toString();



        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dhid)) {

            String id = databaseReports.push().getKey();
            form form = new form(id, dname, dhid, deml,seml);


            databaseReports.child(id).setValue(form);
             Toast.makeText(this, "Message Added! Go back", Toast.LENGTH_LONG).show();
           // Toast.makeText(this, "Go back and reopen comments to see your new comment!", Toast.LENGTH_LONG).show();
            //Toast.makeText(this, "Go back and reopen comments to see your new comment!", Toast.LENGTH_LONG).show();

          //  editText13.setText("");
            editText15.setText("");


        }
        else {
            //if the value is not given displaying a toast
            //focus


            editText13.requestFocus();

            Toast.makeText(this, "Please enter all boxes", Toast.LENGTH_LONG).show();
        }

    }
    public void open2y() {

        final FirebaseUser user4 = mAuth4.getCurrentUser();
        editText13.setText(user4.getDisplayName().toString());
    }

}
