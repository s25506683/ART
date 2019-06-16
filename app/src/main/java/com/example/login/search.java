package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
    public void search_detail1(View v){
        Intent it = new Intent(this,search_detail1.class);
        startActivity(it);
    }
    public void search_detail2(View v){
        Intent it = new Intent(this,search_detail2.class);
        startActivity(it);
    }

    public void search_detail3(View v){
        Intent it = new Intent(this,search_detail3.class);
        startActivity(it);
    }

    public void search_detail4(View v){
        Intent it = new Intent(this,search_detail4.class);
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
