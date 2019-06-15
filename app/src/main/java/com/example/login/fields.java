package com.example.login;

public class fields {
    private String Mem_Name;
    private String Mem_Account;
    private String Mem_Password;
    private String Mem_Identity;
    private String Mem_Tell;
    private String Mem_Email;
    private String Mem_Address;
//    private String test;
    //因為我測試資料只放Notes,Name兩個欄位，可以自己加
    public fields(String Mem_Name, String Mem_Account, String Mem_Password,String Mem_Identity,String Mem_Tell,String Mem_Email,String Mem_Address) {
        this.Mem_Name = Mem_Name;
        this.Mem_Account = Mem_Account;
        this.Mem_Password = Mem_Password;
        this.Mem_Identity = Mem_Identity;
        this.Mem_Tell = Mem_Tell;
        this.Mem_Email = Mem_Email;
        this.Mem_Address = Mem_Address;

    }
    public fields(String Mem_Name) {
        this.Mem_Name = Mem_Name;
    }

//    public fields(String test) {
//        this.test = test;
//    }

    public String getMem_Name() {
        return Mem_Name;
    }

    public String getMem_Account() {
        return Mem_Account;
    }


}