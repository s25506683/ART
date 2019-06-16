package com.example.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fillProject extends AppCompatActivity {

    MyAPIService myAPIService;

    //first step 宣告 start
    private Button submit;
    private  Button uploadfile;
    private EditText name;
    private EditText content;
    private EditText price;
    //first step 宣告 end

    private String up_name;
    private String up_content;
    private int up_price;


    ImageView imageView;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_project);



        //second step 接值 start
        submit = (Button) findViewById(R.id.submit);

        name = (EditText) findViewById(R.id.Text_name);
        content = (EditText) findViewById(R.id.Text_content);
        price = (EditText) findViewById(R.id.Text_price);
        //second step 接值 end


        //third step 按下submit按鈕，把edittext丟到宣告的字串中 start
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.submit){
                    new AlertDialog.Builder(fillProject.this)
                            .setTitle("上傳成功")//設定視窗標題
                            .setIcon(R.mipmap.ic_launcher)//設定對話視窗圖示
                            .setMessage("已成功上傳作品")//設定顯示的文字
                            .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    up_name = name.getText().toString().trim();
                                    up_content = content.getText().toString().trim();
                                    up_price = Integer.parseInt(price.getText().toString().trim());
                                    postinfor(up_name,up_content,up_price);
                                }
                            })//設定結束的子視窗
                            .show();//呈現對話視窗
                }

            }
        });

        //third step 按下submit按鈕，把edittext丟到宣告的字串中 end





//        Spinner notify = (Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(
//                this, R.array.unit, android.R.layout.simple_spinner_item );
//        nAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        notify.setAdapter(nAdapter);
//        Button b =(Button)findViewById(R.id.button);
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(fillProject.this,Pop.class));
//            }
//        });



        imageView = (ImageView)findViewById(R.id.imageView);
        uploadfile = (Button)findViewById(R.id.uploadfile);

        uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });



    }

    public void back(View v){
        Intent it = new Intent(this,homepage.class);
        startActivity(it);
    }



    public void postinfor(String up_name, String up_content, int up_price) {
        myAPIService = RetrofitManager.getInstance().getAPI();
        Call<Infor> call = myAPIService.postInfor3(new Req(new fields_Project(up_name, up_content, up_price)));
        call.enqueue(new Callback<Infor>() {
            @Override
            public void onResponse(Call<Infor> call, Response<Infor> response) {
                Toast.makeText(fillProject.this, "success", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Infor> call, Throwable t) {
                Toast.makeText(fillProject.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }



}