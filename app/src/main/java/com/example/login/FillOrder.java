package com.example.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FillOrder extends AppCompatActivity {

    MyAPIService myAPIService;
    //order
    private EditText show;
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
    private int up_price;
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
                if(v.getId() == R.id.submit){
                    new AlertDialog.Builder(FillOrder.this)
                            .setTitle("填寫成功")//設定視窗標題
                            .setIcon(R.mipmap.ic_launcher)//設定對話視窗圖示
                            .setMessage("已成功填寫訂單")//設定顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    up_name = Name.getText().toString().trim();
                                    up_time = Time.getText().toString().trim();
                                    up_place = Place.getText().toString().trim();
                                    up_phone = Phone.getText().toString().trim();
                                    up_detail = Detail.getText().toString().trim();
                                    up_price =Integer.parseInt(Price.getText().toString());
                                    postinfor(up_name, up_time, up_place, up_phone, up_detail, up_price);
                                    finish();
                                }
                            })//設定結束的子視窗
                            .show();//呈現對話視窗
                }

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


        //fillorder清除開始
        Button btnclear = (Button)findViewById(R.id.clear);
        final EditText projectname=(EditText) findViewById(R.id.Text_name);
        final EditText DateText=(EditText) findViewById(R.id.Text_time);
        final EditText orderPlace=(EditText) findViewById(R.id.Text_place);
        final EditText phoneText=(EditText) findViewById(R.id.Text_phone);
        final EditText otherText=(EditText) findViewById(R.id.Text_detail);
        final EditText priceText=(EditText) findViewById(R.id.Text_price);

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectname.setText("");
                DateText.setText("");
                orderPlace.setText("");
                phoneText.setText("");
                otherText.setText("");
                priceText.setText("");
            }
        });
        //清除結束

    }

    public void postinfor(String up_name,String up_time, String up_place, String up_phone, String up_detail, int up_price){
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.postInfor2(new Req(new fields(up_name, up_time, up_place, up_phone, up_detail,up_price )));
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
        //複寫Button事件
//        Button.OnClickListener listener = new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                if(v.getId() == R.id.submit){
//                    new AlertDialog.Builder(FillOrder.this)
//                            .setTitle("註冊成功")//設定視窗標題
//                            .setIcon(R.mipmap.ic_launcher)//設定對話視窗圖示
//                            .setMessage("已成功註冊帳號")//設定顯示的文字
//                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            })//設定結束的子視窗
//                            .show();//呈現對話視窗
//                }
//            }
//        };



    }



}