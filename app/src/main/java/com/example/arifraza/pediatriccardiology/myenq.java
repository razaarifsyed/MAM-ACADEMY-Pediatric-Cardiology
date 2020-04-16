package com.example.arifraza.pediatriccardiology;




import android.os.Bundle;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import android.widget.ListView;
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
import java.util.List;

public class myenq extends AppCompatActivity {

    DatabaseReference databaseReports;

    FirebaseAuth mAuth44;
    FirebaseAuth mAuth;
    ListView listViewMessages;
    List<msg> messageList;
    Button button19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myenq);
        setTitle("My Enquiries");
        Toast.makeText(this, "Loading ...", Toast.LENGTH_LONG).show();

        mAuth = FirebaseAuth.getInstance();



        listViewMessages = (ListView) findViewById(R.id.listViewReports6);

        messageList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("messages");
        open393();

        listViewMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Create a new message to reply instead", Toast.LENGTH_LONG).show();
                //confusion below in reportList or reports or artists

              //  msg msg = messageList.get(adapterView.getCount()-i-1);

               //readff(msg.getmId(),msg.getrdd());
                //showUpdateDialog2(msg.getmId(), msg.getrnm2(),msg.getmname());

            }
        });

    }


    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            messageList.clear();
            if (dataSnapshot.exists()) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    msg msg = postSnapshot.getValue(msg.class);

                    messageList.add(msg);
                }

                MessageList4 adapter = new MessageList4(myenq.this, messageList);
                listViewMessages.setAdapter(adapter);

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

        final FirebaseUser user3 = mAuth.getCurrentUser();
        String deml2=user3.getEmail().toString();

        Query query= FirebaseDatabase.getInstance().getReference("messages")
                .orderByChild("seml")
                .equalTo(deml2);





        query.addListenerForSingleValueEvent(valueEventListener);

    }

    public void open230() {

        Toast.makeText(this, "No Message found", Toast.LENGTH_LONG).show();

    }





}
