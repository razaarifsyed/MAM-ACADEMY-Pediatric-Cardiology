package com.example.arifraza.pediatriccardiology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

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
import androidx.core.content.ContextCompat;

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
import java.util.Collections;
import java.util.List;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button7;
    Button button9;
    Button button10;
    Button button14;
    Button button13;
    Button button16;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    TextView textView14;
    DatabaseReference databaseReports22;
    //TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       //dont forget theme for toolbar to work
        setTheme(R.style.AppTheme2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pediatric Cardiology");



        //first time user
opentb();

        mAuth = FirebaseAuth.getInstance();
        databaseReports22 = FirebaseDatabase.getInstance().getReference("blt");
open090();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

toolbar.setTitleTextColor(0xFFFFFFFF);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.mnu);
        toolbar.setOverflowIcon(drawable);

        textView14 = (TextView) findViewById(R.id.textView14);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open100111();
            }
        });

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open1001();
            }
        });




        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2102();
            }
        });


        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open3102();
            }
        });




        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openoo();
            }
        });



        button16 = (Button) findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openee();
            }
        });

    }


    public void open1001() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, lectures.class);
        startActivity(intent);
        Toast.makeText(getApplication(), "Loading ...", Toast.LENGTH_LONG).show();

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

    public void open100111() {
//open google drive


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://drive.google.com/open?id=1ck5hQX2Kw8kyDYBvYA9E6M6T6SyE1zuC"));
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        Toast.makeText(this, "App closed!", Toast.LENGTH_LONG).show();
        /*
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast toast= Toast.makeText(getApplicationContext(),
                "Already on Homepage!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);

        toast.show();
        */
    }

    public void open2102() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, cmessage.class);
        startActivity(intent);

    }

    public void open3102() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, myenq.class);
        startActivity(intent);

    }
    public void open4102() {
        //textView3 = (TextView) findViewById(R.id.textView3);


        Intent intent = new Intent(this, rmessage.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);

        MenuItem sinm = menu.findItem(R.id.m1);
        final FirebaseUser user323 = mAuth.getCurrentUser();
        String saa=user323.getDisplayName().toString();

        SpannableString content = new SpannableString("(Signed in As:"+saa+")" );
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        sinm.setTitle(content);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int res_id=item.getItemId();
        //if(res_id==R.id.m1)
         //   open3001();


        if(res_id==R.id.m2)
        {
            open614();
        }
        if(res_id==R.id.m3)
        {
            open7733();
        }

        if(res_id==R.id.m4)
        {
            open877();
        }

        if(res_id==R.id.m5)
        {
            open77();
        }

        //for tutor
        /*
        if(res_id==R.id.m8)
        {
            opentt();
        }
        */



        if(res_id==R.id.m9)
        {
            openff();
        }

        if(res_id==R.id.m6)
        {
            mAuth.signOut();
            finish();
            Intent intent = new Intent(this, MainActivitynew.class);
            startActivity(intent);

            Toast.makeText(this, "Signed Out!", Toast.LENGTH_LONG).show();

        }

        if(res_id==R.id.m7)
        {
            //Toast.makeText(this, "Instagram Feature under construction!", Toast.LENGTH_LONG).show();
            opentyu();

        }


        return super.onOptionsItemSelected(item);
    }


    public void open77()
    {
        final AlertDialog d = new AlertDialog.Builder(this)
                .setPositiveButton(android.R.string.ok, null)
                .setTitle("MAM ACADEMY")
                .setMessage(Html.fromHtml("<br> <br><a href=\"https://www.linkedin.com/in/doc-murtaza-kamal-1a03501a\">Dr. Murtaza Kamal</a><br> PEDIATRIC CARDIOLOGIST <br><br> <a href=\"https://www.practo.com/hyderabad/doctor/dr-dr-meera-jindal-gynecologist-obstetrician\">Dr. Meera Jindal</a><br>Fertility Specialist<br><br><a href=\"https://www.linkedin.com/in/razaarifsyed/\">Arif Raza</a> <br>  App Developer<br> <br><br><br><br>Tap on underlined names to know more")) //
                .create();
        d.show();
// Make the textview clickable. Must be called after show()
        ((TextView)d.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());




    }

    public void open7733(){
        Intent intent = new Intent(this, disclaimer.class);
        startActivity(intent);
    }
    public void open614(){
        Intent intent = new Intent(this, myprof.class);
        startActivity(intent);
    }

    public void open877(){
        Intent intent = new Intent(this, prvcy.class);
        startActivity(intent);
    }


    public void open090() {


        databaseReports22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                String l= "NOTICE:"+"\t"+value;

                textView14.setText(l);


            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }
    public void open82(){
        Intent intent = new Intent(this, bltn.class);
        startActivity(intent);
    }


    public void openoo(){
        Intent intent = new Intent(this, notice.class);
        startActivity(intent);
    }

    public void openp(){
        Intent intent = new Intent(this, setn.class);
        startActivity(intent);
    }


    public void openee(){
        Intent intent = new Intent(this, forum.class);
        startActivity(intent);
    }

    public void opentt(){
        Intent intent = new Intent(this, passw.class);
        startActivity(intent);
    }


    public void opentyu() {
//open google drive


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.instagram.com/mamacademy786/"));
        startActivity(intent);

    }


    public void openff(){
        Intent intent = new Intent(this, faqs.class);
        startActivity(intent);
    }



    public void opentb()
    {
        final SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        boolean agreed2 = sharedPreferences2.getBoolean("agreed2",false);
        if (!agreed2) {
            final AlertDialog d2 = new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setPositiveButton("Start", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog2, int which) {
                            SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                            editor2.putBoolean("agreed2", true);
                            editor2.commit();
                        }
                    })
                    .setNegativeButton("", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog2, int which) {

                            SharedPreferences.Editor editor2 = sharedPreferences2.edit();
                            editor2.putBoolean("agreed2", false);
                            editor2.commit();

                            finish();
                            System.exit(0);


                        }
                    })
                    .setMessage(Html.fromHtml("<br> Welcome to the MAM Academy. I am your tutor for this course. Good Luck !<br> ~ Dr. Murtaza Kamal.<br><br> Tap 'Start' to begin!  "))
                    .show();

            ((TextView)d2.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

        }



    }



    }
