package com.example.arifraza.pediatriccardiology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class forum extends AppCompatActivity {




    DatabaseReference databaseReports;

    ListView listViewForm;
    List<form> formList;
    Button button17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        setTitle("Forum Discussion");
        Toast.makeText(getApplication(), "Loading ...", Toast.LENGTH_LONG).show();

        listViewForm = (ListView) findViewById(R.id.listViewForm);
        formList = new ArrayList<>();
        databaseReports = FirebaseDatabase.getInstance().getReference("form");

        button17 = (Button) findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openiy();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseReports.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                formList.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                     form form = postSnapshot.getValue(form.class);

                        formList.add(form);
                    }

                    FormList adapter = new FormList(forum.this, formList);
                    listViewForm.setAdapter(adapter);
                }

                else
                {
                    open23a0();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void open23a0() {

        Toast.makeText(this, "No Notices to show", Toast.LENGTH_LONG).show();

    }
    public void openiy(){
        Intent intent = new Intent(this, mkform.class);
        startActivity(intent);
    }


}
