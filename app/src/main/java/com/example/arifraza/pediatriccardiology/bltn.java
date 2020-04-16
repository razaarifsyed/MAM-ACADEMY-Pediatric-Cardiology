package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class bltn extends AppCompatActivity {
    DatabaseReference databaseReports22;
    EditText editText9;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bltn);
        setTitle("Edit Notice");
        editText9 = (EditText) findViewById(R.id.editText9);
        databaseReports22 = FirebaseDatabase.getInstance().getReference("blt");

        open37();
        button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2l();
            }
        });
    }


    public void open37() {


        databaseReports22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);


                editText9.setText(value);


            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
    public void open2l() {

        String kk=editText9.getText().toString();


        databaseReports22.setValue(kk);
        Toast.makeText(this, "Notice Updated!", Toast.LENGTH_LONG).show();



    }

}
