package com.example.login;

public class fields {
    private String Mem_Name;
    private String Mem_Account;
    private String Mem_Password;
    private String Mem_Identity;
    private String Mem_Tell;
    private String Mem_Email;
    private String Mem_Address;
    //order
    private String Order_Name;
    private String Order_Time;
    private String Order_Place;
    private String Order_Phone;
    private String Order_Detail;
    private String Order_Price;
    //order

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

    public fields(String Order_Name,String Order_Time,String Order_Place,String Order_Phone,String Order_Detail,String Order_Price){
        this.Order_Name = Order_Name;
        this.Order_Time = Order_Time;
        this.Order_Place = Order_Place;
        this.Order_Phone = Order_Phone;
        this.Order_Detail = Order_Detail;
        this.Order_Price = Order_Price;

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