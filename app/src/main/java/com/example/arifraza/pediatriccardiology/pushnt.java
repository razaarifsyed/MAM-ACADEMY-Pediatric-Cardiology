package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class pushnt extends AppCompatActivity {
    TextView textView27;
    TextView textView31;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pushnt);
        setTitle("MAM ACADEMY");

        textView27 = (TextView) findViewById(R.id.textView27);
        textView31 = (TextView) findViewById(R.id.textView31);


        //String value = getIntent().getExtras().getString("bucketno");
        Bundle extras = getIntent().getExtras();
        String aa = extras.getString("f1");
        String bb = extras.getString("s2");

if(aa==null)
{
    open655();
}

textView27.setText(aa);
        textView31.setText(bb);

    }

    @Override
    public void onBackPressed() {
       //finish();
        //System.exit(0);
        Intent intent = new Intent(this, MainActivitynew.class);
        startActivity(intent);

            }


    public void open655(){
        Intent intent = new Intent(this, MainActivitynew.class);
        startActivity(intent);
    }



}

