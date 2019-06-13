package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Login(View view) {

    }
    public void register(View v){
        Intent it = new Intent(this,Register.class);
        startActivity(it);
    }
    public void fillOrder(View v){
        Intent it = new Intent(this,FillOrder.class);
        startActivity(it);
    }

    public void homepage(View v){
        Intent it = new Intent(this,homepage.class);
        startActivity(it);
    }
    public void fillProject(View v){
        Intent it = new Intent(this,fillProject.class);
        startActivity(it);
    }



}
