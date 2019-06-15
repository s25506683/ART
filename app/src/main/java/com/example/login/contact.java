package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    public void fillorder(View v){
        Intent it = new Intent(this,FillOrder.class);
        startActivity(it);
    }
    public void back(View v){
        Intent it = new Intent(this,Information.class);
        startActivity(it);
    }
}