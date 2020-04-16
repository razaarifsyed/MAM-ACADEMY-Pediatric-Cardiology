package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class setn extends AppCompatActivity {
    EditText editText10;
    EditText editText12;
    Button button15;
    DatabaseReference databaseReports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setn);
        setTitle("Add a New Notice");
        editText10 = (EditText) findViewById(R.id.editText10);
        editText12 = (EditText) findViewById(R.id.editText12);
        button15 = (Button) findViewById(R.id.button15);
        databaseReports = FirebaseDatabase.getInstance().getReference("notc");
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openii();
            }
        });


    }


    public void openii() {


        String dname = editText10.getText().toString().trim();

        Date currentTime22 = Calendar.getInstance().getTime();
        String deml = currentTime22.toString();
        String dhid = editText12.getText().toString().trim();

       // String lid = textView10.getText().toString();

        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dhid)) {

            String id = databaseReports.push().getKey();
            notc notc = new notc(id, dname, dhid, deml);


            databaseReports.child(id).setValue(notc);
            // Toast.makeText(this, "Comment Added!", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Notice Added!", Toast.LENGTH_LONG).show();
           // Toast.makeText(this, "Go back and reopen comments to see your new comment!", Toast.LENGTH_LONG).show();

            editText10.setText("");
            editText12.setText("");


        }
        else {
            //if the value is not given displaying a toast
            //focus


            editText10.requestFocus();

            Toast.makeText(this, "Please enter all boxes", Toast.LENGTH_LONG).show();
        }

    }


}
