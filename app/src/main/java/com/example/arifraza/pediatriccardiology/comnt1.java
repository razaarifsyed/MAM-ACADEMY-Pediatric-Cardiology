package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.NonNull;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class comnt1 extends AppCompatActivity {
    EditText editText3;
    EditText editText4;
    Button button;
    DatabaseReference databaseReports;
   // FirebaseAuth mAuth;
    ListView listViewComnt;
    List<comnt> comntList;
    TextView textView10;
    FirebaseAuth mAuth4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comnt1);
        setTitle("Comments");
        //mAuth = FirebaseAuth.getInstance();
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);

        textView10 =(TextView)findViewById(R.id.textView10);
        databaseReports = FirebaseDatabase.getInstance().getReference("comnt");
        mAuth4 = FirebaseAuth.getInstance();
        String valuel = getIntent().getExtras().getString("bucketno");
        textView10.setText(valuel);
        open2y();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlol22();
            }
        });
        listViewComnt = (ListView) findViewById(R.id.listViewComnt);
        comntList = new ArrayList<>();

        open393();

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            comntList.clear();
            if (dataSnapshot.exists()) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    comnt comnt = postSnapshot.getValue(comnt.class);

                    comntList.add(comnt);
                }

                ComntList adapter = new ComntList(comnt1.this, comntList);
                listViewComnt.setAdapter(adapter);



//adapter.notifyDataSetChanged();
            }
            else
            {
                open230();
            }}

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };




    public void open393() {
        //textView3 = (TextView) findViewById(R.id.textView3);
String hh= textView10.getText().toString();


        Query query= FirebaseDatabase.getInstance().getReference("comnt")
                .orderByChild("lid")
                .equalTo(hh);


        query.addListenerForSingleValueEvent(valueEventListener);

    }


    public void open230() {

        Toast.makeText(this, "No Comments to show", Toast.LENGTH_LONG).show();

    }


    public void openlol22() {



        String dname = editText3.getText().toString().trim();

        Date currentTime22 = Calendar.getInstance().getTime();
        String deml = currentTime22.toString();
        String dhid = editText4.getText().toString().trim();

        String lid = textView10.getText().toString();

        final FirebaseUser user444 = mAuth4.getCurrentUser();
        String seml = user444.getEmail().toString();


        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dhid)) {

            String id = databaseReports.push().getKey();
            comnt comnt = new comnt(id, dname, dhid, deml, lid,seml);


            databaseReports.child(id).setValue(comnt);
            Toast.makeText(this, "Comment Added!", Toast.LENGTH_SHORT).show();
          //  Toast.makeText(this, "Go back and reopen comments to see your new comment!", Toast.LENGTH_LONG).show();
           // Toast.makeText(this, "Go back and reopen comments to see your new comment!", Toast.LENGTH_LONG).show();

            //editText3.setText("");
            editText4.setText("");
open393();

        }
        else {
            //if the value is not given displaying a toast
            //focus


            editText3.requestFocus();

            Toast.makeText(this, "Please enter all boxes", Toast.LENGTH_LONG).show();
        }

    }


    public void open2y() {

        final FirebaseUser user4 = mAuth4.getCurrentUser();
        editText3.setText(user4.getDisplayName().toString());
    }

}
