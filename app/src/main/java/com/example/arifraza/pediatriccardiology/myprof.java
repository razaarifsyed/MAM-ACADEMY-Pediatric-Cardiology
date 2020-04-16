package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


public class myprof extends AppCompatActivity {

    ListView listViewUsers2;
    List<user> userList2;


    FirebaseAuth mAuth4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprof);
        setTitle("My profile");
        Toast.makeText(this, "Loading ...", Toast.LENGTH_SHORT).show();
        mAuth4 = FirebaseAuth.getInstance();

        listViewUsers2 = (ListView) findViewById(R.id.listViewUsers2);
        userList2 = new ArrayList<>();

        open394();


    }


    public void open394() {
        //textView3 = (TextView) findViewById(R.id.textView3);
        //String hh= textView10.getText().toString();

        final FirebaseUser user444 = mAuth4.getCurrentUser();
        String seml = user444.getEmail().toString();

        Query query= FirebaseDatabase.getInstance().getReference("users")
                .orderByChild("deml")
                .equalTo(seml);


        query.addListenerForSingleValueEvent(valueEventListener);

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            userList2.clear();
            if (dataSnapshot.exists()) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    user user = postSnapshot.getValue(user.class);
                    userList2.add(user);
                }

                UserList2 adapter = new UserList2(myprof.this, userList2);
                listViewUsers2.setAdapter(adapter);

            }
            else
            {
                open230();
            }}

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


    public void open230() {

        Toast.makeText(this, "Error! No profile Info Available", Toast.LENGTH_LONG).show();

    }
}
