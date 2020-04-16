package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;




import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
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
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cusrs extends AppCompatActivity {

    DatabaseReference databaseReports;

    ListView listViewUsers;
    List<user> userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusrs);
        setTitle("User Accounts");
        Toast.makeText(getApplication(), "Loading ...", Toast.LENGTH_LONG).show();

        listViewUsers = (ListView) findViewById(R.id.listViewUsers);
        userList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("users");


        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                user user = userList.get(adapterView.getCount()-i-1);
              //openccc(user.deml);

                open1aa(user.deml);


            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        databaseReports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    user user = postSnapshot.getValue(user.class);

                    userList.add(user);
                }

                UserList adapter = new UserList(cusrs.this, userList);
                listViewUsers.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


//to send email used earlier
    public void open1aa(final String deml) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{deml});
        intent.putExtra(Intent.EXTRA_SUBJECT, "MAM-ACADEMY");
        Date currentTime = Calendar.getInstance().getTime();


        String messagel = "";

        messagel += "\n" + "Admin MAM Academy ";
        messagel += "\n" + "-----------------------------------------------------";
        messagel += "\n";
        messagel += "\n";




        intent.putExtra(Intent.EXTRA_TEXT, messagel);


        intent.setType("message/rfc822");

        intent.setPackage("com.google.android.gm");
        startActivity(intent);





    }
    public void openccc(final String deml){
        Intent intent = new Intent(this, cmessage2.class);
        intent.putExtra("bucketno",deml);
        startActivity(intent);
    }


}
