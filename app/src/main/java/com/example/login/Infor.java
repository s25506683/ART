package com.example.login;

public class Infor {
    private Infor[] records;
    private String id = "1";
    private fields fields;
    private String createTime;

    public Infor(String id, fields fields1, String createTime) {
        this.id = id;
        this.fields = fields1;
        this.createTime = createTime;
    }

    public Infor[] getRecords() {
        return records;
    }

    public String getId(int i) {
        return records[i].id;
    }

//    public String getfields(int i) {
//        return records[i].getFields().getMem_Name();
//    }

    public String getfieldsAccount(int i) {
        return records[i].getFields().getMem_Account();
    }

    public String getfieldsPassword(int i){
        return records[i].getFields().getMem_Password();
    }



//    public String getfieldsName() {
//        return getFields().getName();
//    }
//
//    public String getfieldsNote(){
//        return fields.getNotes();
//    }


    //晚上改的
    public fields getFields() {
        return fields;
    }
    //晚上改的
//
//    public Object getfieldsName(int i) {
//        return records[i].getFields().getMem_Name();
//    }
//


//    public String getCreateTime() {
//        return createTime;
//    }

}
