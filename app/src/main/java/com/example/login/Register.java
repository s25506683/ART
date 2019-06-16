    package com.example.login;


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

    public class Register extends AppCompatActivity {

        MyAPIService myAPIService;
        //first step 宣告 start
        private Button submit;
        private EditText account;
        private EditText password;
        private EditText name;
        private EditText phone;
        private EditText identity;
        private EditText mail;
        private EditText address;
        //first step 宣告 end


        private String up_password;
        private String up_account;
        private String up_name;
        private String up_phone;
        private String up_identity;
        private String up_mail;
        private String up_address;
        private long up_passwordlong;

        ImageView imageView;
        Button button;
        private static final int PICK_IMAGE = 100;
        Uri imageUri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);


            //second step 接值 start
            submit = (Button) findViewById(R.id.submit);
            account = (EditText) findViewById(R.id.Text_account);
            password = (EditText)  findViewById(R.id.Text_password);
            name = (EditText) findViewById(R.id.Text_name);
            phone = (EditText) findViewById(R.id.Text_phone);
            identity = (EditText) findViewById(R.id.Text_identity);
            mail = (EditText) findViewById(R.id.Text_mail);
            address = (EditText) findViewById(R.id.Text_address);

            //second step 接值 end


            //third step 按下submit按鈕，把edittext丟到宣告的字串中 start
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    up_account = account.getText().toString().trim();
                    up_passwordlong = Long.parseLong(password.getText().toString().trim());
                    up_passwordlong = up_passwordlong%11*771/3*71;
                    up_password = String.valueOf(up_passwordlong);
                    up_name = name.getText().toString().trim();
                    up_phone = phone.getText().toString().trim();
                    up_identity = identity.getText().toString().trim();
                    up_mail = mail.getText().toString().trim();
                    up_address = address.getText().toString().trim();

                    //晚上改的
                    if(up_account.equals("") || up_password.equals("") || up_name == null || up_phone.equals("") ||up_identity.equals("")
                            || up_mail.equals("")|| up_address.equals(""))
                    {
                        Toast.makeText(Register.this,"有必填欄位未填!",Toast.LENGTH_SHORT).show();
                    }else
                        getInfor(up_account, up_password, up_name, up_phone, up_identity, up_mail, up_address);
                    }
                    //晚上改的







            });

            //third step 按下submit按鈕，把edittext丟到宣告的字串中 end





    //
    //        //點擊button進行註冊（未完成）
    //        btn = (Button)findViewById(R.id.btn);
    //        //註冊按鈕事件（未完成）
    //        btn.setOnClickListener(listener);


            imageView = (ImageView)findViewById(R.id.imageView);
            button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openGallery();
                }
            });

    //        button_yes = (Button)findViewById(R.id.button_yes);

            //清除

            Button clear = (Button)findViewById(R.id.button_yes);
            final EditText Text_account=(EditText) findViewById(R.id.Text_account);
            final EditText Text_password=(EditText) findViewById(R.id.Text_password);
            final EditText Text_name=(EditText) findViewById(R.id.Text_name);
            final EditText Text_phone=(EditText) findViewById(R.id.Text_phone);
            final EditText Text_identity=(EditText) findViewById(R.id.Text_identity);
            final EditText Text_mail=(EditText) findViewById(R.id.Text_mail);
            final EditText Text_address=(EditText) findViewById(R.id.Text_address);

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Text_account.setText("");
                    Text_password.setText("");
                    Text_name.setText("");
                    Text_phone.setText("");
                    Text_identity.setText("");
                    Text_mail.setText("");
                    Text_address.setText("");


                }
            });

            //清除結束

        }

        public void getInfor(final String up_account, final String up_password, final String up_name, final String up_phone, final String up_identity, final String up_mail, final String up_address) {
            myAPIService = RetrofitManager.getInstance().getAPI();
            Call<Infor> call = myAPIService.getInfor();
            call.enqueue(new Callback<Infor>() {
                @Override
                public void onResponse(Call<Infor> call, Response<Infor> response) {//如果請求連接資料庫並成功抓到值
                    int len = response.body().getRecords().length;
                    System.out.println(len);
                    int i = 0;
                    boolean ifExisted = false;
                    while (i < len) {
                        if (response.body().getfieldsAccount(i).equals(up_account)) {
                            ifExisted = true;
                            System.out.println(ifExisted);
                            Toast.makeText(Register.this, "此帳號已存在!", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        i++;
                    }
                    if (ifExisted == false) {
                        postinfor(up_account, up_password, up_name, up_phone, up_identity, up_mail, up_address);
                    }
                }

                @Override
                public void onFailure(Call<Infor> call, Throwable t) {
                    Toast.makeText(Register.this, "註冊失敗!!", Toast.LENGTH_SHORT).show();
                }
            });
        }//asoiduasioudioasu

        //postinfor備份
            public void postinfor(String up_account, String up_password, String up_name, String up_phone,String up_identity, String up_mail,String up_address) {
                myAPIService = RetrofitManager.getInstance().getAPI();
                Call<Infor> call = myAPIService.postInfor(new Req(new fields(up_account,up_name,up_password,up_identity,up_phone,up_mail,up_address)));
                call.enqueue(new Callback<Infor>() {
                    @Override
                    public void onResponse(Call<Infor> call, Response<Infor> response) {
                        Toast.makeText(Register.this, "註冊成功", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailure(Call<Infor> call, Throwable t) {
                        Toast.makeText(Register.this, "註冊失敗", Toast.LENGTH_SHORT).show();
                    }
                });
            //postinfor備份


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


        //複寫Button事件
    //        private Button.OnClickListener listener = new Button.OnClickListener(){
    //        @Override
    //        public void onClick(View v) {
    //        if(v.getId() == R.id.submit){
    //            new AlertDialog.Builder(Register.this)
    //                        .setTitle("註冊成功")//設定視窗標題
    //                        .setIcon(R.mipmap.ic_launcher)//設定對話視窗圖示
    //                        .setMessage("已成功註冊帳號")//設定顯示的文字
    //                        .setPositiveButton("關閉視窗",new DialogInterface.OnClickListener(){
    //                            @Override
    //                            public void onClick(DialogInterface dialog, int which) {
    //                            finish();
    //                            }
    //                        })//設定結束的子視窗
    //                        .show();//呈現對話視窗
    //            }
    //        }
    //};

    }
