package com.example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private View view;
    MyAPIService myAPIService;

    private EditText account;
    private EditText password;

    private Button btn_Login;
    private String up_account;
    private String up_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_Login = (Button)findViewById(R.id.btn_Login);
        account = (EditText) findViewById(R.id.Check_account);
        password = (EditText) findViewById(R.id.Check_password);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                up_account = account.getText().toString().trim();
                up_password = password.getText().toString().trim();
                getInfor(up_account,up_password);
            }
        });
    }


    public void getInfor(final String up_account, final String up_password) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.getInfor();
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {//如果請求連接資料庫並成功抓到值
                int len = response.body().getRecords().length;
                int i = 0;
                boolean hasAccount = false;
                boolean isExisted = false;
                while (i < len) {
                    if (response.body().getfieldsAccount(i).equals(up_account)) {
                        hasAccount = true;
                        if(response.body().getfieldsPassword(i).equals(up_password)){
                            isExisted = true;
                            break;
                        }
                    }
                    i++;
                }
                if(isExisted){
                    Toast.makeText(MainActivity.this, "帳號密碼正確！", Toast.LENGTH_SHORT).show();
                    homepage();
                }else if(hasAccount){
                    Toast.makeText(MainActivity.this, "密碼錯誤！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "查無此帳號", Toast.LENGTH_SHORT).show();
                }

            }


            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                Toast.makeText(MainActivity.this, "input error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void register(View v){
        Intent it = new Intent(this,Register.class);
        startActivity(it);
    }
    public void fillOrder(View v){
        Intent it = new Intent(this,FillOrder.class);
        startActivity(it);
    }
    private void homepage() {
        Intent it = new Intent(this,homepage.class);
        startActivity(it);
    }


    public void fillProject(View v){
        Intent it = new Intent(this,fillProject.class);
        startActivity(it);
    }



}