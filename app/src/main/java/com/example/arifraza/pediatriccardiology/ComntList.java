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
public class ComntList extends ArrayAdapter<comnt>{


    private Activity context;
    private List<comnt> comntList;

    public ComntList(Activity context, List<comnt> comntList) {
        super(context, R.layout.list_layout4,comntList);
        this.context = context;
        this.comntList = comntList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem3 = inflater.inflate(R.layout.list_layout4, null, true);

        TextView textView7 = (TextView) listViewItem3.findViewById(R.id.textView7);
        TextView textView5 = (TextView) listViewItem3.findViewById(R.id.textView5);
        TextView textView9 = (TextView) listViewItem3.findViewById(R.id.textView9);
        TextView textView25 = (TextView) listViewItem3.findViewById(R.id.textView25);
        TextView textView26 = (TextView) listViewItem3.findViewById(R.id.textView26);
        TextView textView29 = (TextView) listViewItem3.findViewById(R.id.textView29);
        //TextView textView27 = (TextView) listViewItem3.findViewById(R.id.textView27);
        comnt comnt = comntList.get(getCount()-position-1);
        textView7.setText(""+comnt.getdname());

        textView29.setText("Date:"+comnt.getdeml());
        textView9.setText("Comment:"+comnt.getdhid());
       // textView27.setText("Email:"+comnt.getml());

        return listViewItem3;
    }

}
