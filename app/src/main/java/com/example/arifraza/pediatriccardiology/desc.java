package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class desc extends AppCompatActivity {
    EditText editText8;
    EditText editText2;

    Button button6;
    DatabaseReference databaseReports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);
        setTitle("Lecture Description");

        final String value = getIntent().getExtras().getString("bucketno");

        editText8 = (EditText) findViewById(R.id.editText8);
        editText2 = (EditText) findViewById(R.id.editText2);
        button6 = (Button) findViewById(R.id.button6);
       // databaseReports = FirebaseDatabase.getInstance().getReference("lecs");

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setText(value);
               openm1();
openm22();

            }
        });
    }

    public void openm1() {
String val2=editText2.getText().toString();
        databaseReports = FirebaseDatabase.getInstance().getReference("lecs").child(val2);
      String mm=  editText8.getText().toString();
databaseReports.child("ldsc").setValue(mm);

    }
    public void openm22() {
        Intent intent = new Intent(this, MainActivity.class);
        //finish();
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(this, "Lecture Added!", Toast.LENGTH_LONG).show();
    }
}
