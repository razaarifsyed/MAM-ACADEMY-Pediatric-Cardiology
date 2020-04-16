package com.example.arifraza.pediatriccardiology;




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
import java.util.Collections;
import java.util.List;

import android.widget.ArrayAdapter;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class MessageList4 extends ArrayAdapter<msg> {





    private Activity context;
    private List<msg> messageList;

    public MessageList4(Activity context, List<msg> messageList) {
        super(context, R.layout.list_layout9, messageList);
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem2 = inflater.inflate(R.layout.list_layout9, null, true);

        TextView textViewName2 = (TextView) listViewItem2.findViewById(R.id.textViewName2);
        TextView textViewGenre2 = (TextView) listViewItem2.findViewById(R.id.textViewGenre2);
        TextView textViewcon2 = (TextView) listViewItem2.findViewById(R.id.textViewCon2);
        TextView textView6 = (TextView) listViewItem2.findViewById(R.id.textView6);
        TextView textView34 = (TextView) listViewItem2.findViewById(R.id.textView34);
        TextView textView36 = (TextView) listViewItem2.findViewById(R.id.textView36);
        //TextView textView37 = (TextView) listViewItem2.findViewById(R.id.textView37);
        //TextView textView38 = (TextView) listViewItem2.findViewById(R.id.textView38);
        TextView textView41 = (TextView) listViewItem2.findViewById(R.id.textView41);
        TextView textView44 = (TextView) listViewItem2.findViewById(R.id.textView44);

        msg msg = messageList.get(getCount()-position-1);
        textViewName2.setText("Sender Name:"+msg.getmname());
        textView34.setText("Sender Email:"+msg.getseml());
        textViewcon2.setText("Subject :"+msg.getcon());
        textViewGenre2.setText("Question:"+msg.getmmsg());
        textView6.setText(msg.getrdd());
        textView36.setText("Answer:"+msg.getmmsg2());
        //textView37.setText("Receiver Name:"+msg.getrnm2());
        //textView38.setText("Receiver's Email:"+msg.getrml2());
        textView41.setText("Date Sent:"+msg.getdat());
        textView44.setText("Date Replied:"+msg.getdat2());

        return listViewItem2;
    }

}
