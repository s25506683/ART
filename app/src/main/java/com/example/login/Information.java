package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }

    public void contact(View v){
        Intent it = new Intent(this,contact.class);
        startActivity(it);
    }

    public void search(View v){
        Intent it = new Intent(this,search.class);
        startActivity(it);
    }
    public void homepage(View v){
        Intent it = new Intent(this,homepage.class);
        startActivity(it);
    }
    public void orderlist(View v){
        Intent it = new Intent(this,orderlist.class);
        startActivity(it);
    }
}
