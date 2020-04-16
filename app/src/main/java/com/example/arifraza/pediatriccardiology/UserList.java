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
public class UserList extends ArrayAdapter<user>{


    private Activity context;
    private List<user> userList;

    public UserList(Activity context, List<user> userList) {
        super(context, R.layout.list_layout3, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem3 = inflater.inflate(R.layout.list_layout3, null, true);

        TextView textView7 = (TextView) listViewItem3.findViewById(R.id.textView7);
        TextView textView5 = (TextView) listViewItem3.findViewById(R.id.textView5);
        TextView textView9 = (TextView) listViewItem3.findViewById(R.id.textView9);
        TextView textView25 = (TextView) listViewItem3.findViewById(R.id.textView25);
        TextView textView26 = (TextView) listViewItem3.findViewById(R.id.textView26);
        TextView textView29 = (TextView) listViewItem3.findViewById(R.id.textView29);
        user user = userList.get(getCount()-position-1);
        textView7.setText("Name:"+user.getdname());
        textView5.setText("Account Created On:"+user.getudt());
        textView29.setText("Email:"+user.getdeml());
        textView9.setText("Country:"+user.getdhid());
        textView25.setText("Qualification:"+user.getdds());
        textView26.setText("Phone No:"+user.getdpn());


        return listViewItem3;
    }

}
