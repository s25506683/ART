package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void information(View v){
        Intent it = new Intent(this,Information.class);
        startActivity(it);
    }

    public void order(View v){
        Intent it = new Intent(this,FillOrder.class);
        startActivity(it);
    }

    public void search(View v){
        Intent it = new Intent(this,search.class);
        startActivity(it);
    }

    public void fillProject(View v){
        Intent it = new Intent(this,fillProject.class);
        startActivity(it);
    }



}

