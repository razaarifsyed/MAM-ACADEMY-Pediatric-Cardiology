package com.example.arifraza.pediatriccardiology;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {



    Button button23;
    Button button21;
    Button button24;
    Button button22;
    Button button20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setTitle("Admin");

        button23 = (Button) findViewById(R.id.button23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open4102();
            }
        });

        button21 = (Button) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1002();
            }
        });


        button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1003();
            }
        });

        button22 = (Button) findViewById(R.id.button22);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open82();
            }
        });

        button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openp();
            }
        });


    }


    public void open4102() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, rmessage.class);
        startActivity(intent);

    }


    public void open1002() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, addlec.class);
        startActivity(intent);

    }

    public void open1003() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, cusrs.class);
        startActivity(intent);

    }

    public void open82(){
        Intent intent = new Intent(this, bltn.class);
        startActivity(intent);
    }
    public void openp(){
        Intent intent = new Intent(this, setn.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}
