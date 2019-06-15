package com.example.login;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FillOrder extends AppCompatActivity {

    MyAPIService myAPIService;
    //order
    private TextView show;
    private Button submit;
    private EditText Name;
    private EditText Time;
    private EditText Place;
    private EditText Phone;
    private EditText Detail;
    private EditText Price;
    //order

    //order
    private String up_name;
    private String up_time;
    private String up_place;
    private String up_phone;
    private String up_detail;
    private String up_price;
    //order


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_order);


        //second step 接值 start
        submit = (Button) findViewById(R.id.submit);
        Name = (EditText) findViewById(R.id.Text_name);
        Time = (EditText) findViewById(R.id.Text_time);
        Place = (EditText) findViewById(R.id.Text_place);
        Phone = (EditText) findViewById(R.id.Text_phone);
        Detail = (EditText) findViewById(R.id.Text_detail);
        Price = (EditText) findViewById(R.id.Text_price);
        //

        //third step 按下submit按鈕，把edittext丟到宣告的字串中 start
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up_name = Name.getText().toString().trim();
                up_time = Time.getText().toString().trim();
                up_place = Place.getText().toString().trim();
                up_phone = Phone.getText().toString().trim();
                up_detail = Detail.getText().toString().trim();
                up_price = Price.getText().toString().trim();
                postinfor(up_name, up_time, up_place, up_phone, up_detail, up_price);
            }
        });
        //third step 按下submit按鈕，把edittext丟到宣告的字串中 end


//        Button b =(Button)findViewById(R.id.button);
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(FillOrder.this,Pop.class));
//            }
//        });

    }

    public void postinfor(String up_name,String up_time, String up_place, String up_phone, String up_detail, String up_price){
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.postInfor2(new Req(new fields(up_name)));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                Toast.makeText(FillOrder.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                Toast.makeText(FillOrder.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

