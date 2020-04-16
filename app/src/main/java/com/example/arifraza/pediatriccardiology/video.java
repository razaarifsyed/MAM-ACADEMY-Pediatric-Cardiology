package com.example.arifraza.pediatriccardiology;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;

public class video extends AppCompatActivity {
  //  EditText editText3;
  Button button11;
    Button button4;

    TextView textView11;
    TextView textView2;
    TextView textView6;
    TextView textView4;
    TextView textView12;
    DatabaseReference databaseReports222;
    DatabaseReference databaseReports223;
    DatabaseReference databaseReports224;
    DatabaseReference databaseReports225;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        setTitle("Watch Lecture");
        Toast.makeText(getApplication(), "Loading ...", Toast.LENGTH_LONG).show();
        //editText3 = (EditText) findViewById(R.id.editText3);
        textView11 =(TextView)findViewById(R.id.textView11);
        textView2 =(TextView)findViewById(R.id.textView2);
        textView4 =(TextView)findViewById(R.id.textView4);
        textView12 =(TextView)findViewById(R.id.textView12);
        textView6 =(TextView)findViewById(R.id.textView6);
        button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open10011();
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open10022();
            }
        });
        String value = getIntent().getExtras().getString("bucketno");
        textView4.setText(value);
        textView12.setText(value);
//editText3.setText(value);



        databaseReports222 = FirebaseDatabase.getInstance().getReference("lecs").child(value).child("deml");
        databaseReports223 = FirebaseDatabase.getInstance().getReference("lecs").child(value).child("ldsc");
        databaseReports224 = FirebaseDatabase.getInstance().getReference("lecs").child(value).child("dname");
        databaseReports225 = FirebaseDatabase.getInstance().getReference("lecs").child(value).child("dhid");

open332();
open455();
open555();
        final YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {

                //String videoId3 = editText3.getText().toString();

              //  databaseReports222.child("deml").g;
                //String videoId = editText3.getText().toString();





                youTubePlayerView.getPlayerUiController().showYouTubeButton(false);
                youTubePlayerView.getPlayerUiController().showFullscreenButton(true);



//youTubePlayerView.getPlayerUiController().enableLiveVideoUi(true);

String videoId = textView4.getText().toString();
                youTubePlayer.loadVideo(videoId, 0);
            }
        });

open32();


    }

    public void open32() {
        databaseReports223.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);



                textView11.setText(value);



            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }




    public void open332() {

        databaseReports222.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);


                textView4.setText(value);


            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void open10011() {
//open google drive


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://drive.google.com/open?id=1ck5hQX2Kw8kyDYBvYA9E6M6T6SyE1zuC"));
        startActivity(intent);

    }


    public void open455() {

        databaseReports224.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);


                textView2.setText("Lecture :"+value);


            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }


    public void open555() {

        databaseReports225.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);


                textView6.setText(""+value);


            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }


    public void open10022() {

        Intent intent = new Intent(this, comnt1.class);
       String g= textView12.getText().toString();
        intent.putExtra("bucketno",g);
        startActivity(intent);
    }

//like button



}
