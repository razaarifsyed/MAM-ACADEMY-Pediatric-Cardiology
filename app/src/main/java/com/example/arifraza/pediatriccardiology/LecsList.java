package com.example.arifraza.pediatriccardiology;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import android.widget.ArrayAdapter;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.net.URL;
import java.util.List;
public class LecsList extends ArrayAdapter<lecs> {


    private Activity context;
    private List<lecs> lecsList;


    public LecsList(Activity context, List<lecs> lecsList) {
        super(context, R.layout.list_layout1, lecsList);
        this.context = context;
        this.lecsList = lecsList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem3 = inflater.inflate(R.layout.list_layout1, null, true);
        TextView textView7 = (TextView) listViewItem3.findViewById(R.id.textView7);
       // TextView textView9 = (TextView) listViewItem3.findViewById(R.id.textView9);
        TextView textView25 = (TextView) listViewItem3.findViewById(R.id.textView25);

        TextView textView26 = (TextView) listViewItem3.findViewById(R.id.textView26);

        TextView textView29 = (TextView) listViewItem3.findViewById(R.id.textView29);

        ImageView myImageView = (ImageView)listViewItem3.findViewById(R.id.imageView2);
        //myImageView.setImageResource(R.drawable.mu);





        //change the order from below for reversing
//Also check lecture on click listner
        // lecs lecs = lecsList.get(getCount()-position-1);
        lecs lecs = lecsList.get(position);
        //textView7.setText("Lecture:" + lecs.getdname());
       // textView29.setText("Date Uploaded:" + lecs.getltm());
         textView29.setText(lecs.getltm());
       // textView9.setText("Lecture Name:" + lecs.getdhid());
        textView7.setText(lecs.getdname()+ ":"+"\t"+lecs.getdhid());

       // textView25.setText("Topic:" + lecs.getdds());
        textView25.setText(lecs.getdds());
       // textView26.setText("Tutor Name:" + lecs.getdpn());
        textView26.setText( lecs.getdpn());


        String pp= lecs.getdeml();
     //the bewlo thing is taken from a website, change this if website changes this. website https://orbitingweb.com/blog/view-youtube-thumbnail-image/

        String bb= "https://i.ytimg.com/vi/"+pp+"/hqdefault.jpg";


        Picasso.get()
                .load(bb)
                //load("https://i.ytimg.com/vi/uTt9tmzOfjQ/hqdefault.jpg")
                .resize(200, 200)
                .centerCrop()
                .into(myImageView);

        return listViewItem3;
    }
}


