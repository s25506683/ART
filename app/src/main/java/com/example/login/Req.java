package com.example.login;

public class Req {
    public String id;
    private fields fields;
    private fields_Project fieldsProject;

    public Req(fields fields) {
        this.fields = fields;
    }

    public Req(fields_Project fields){
        this.fieldsProject = fields;
    }

    public fields getFields() {
        return fields;
    }

    public void setFields(com.example.login.fields fields) {
        this.fields = fields;
    }

    //晚上改的
//    public fields getFields() {
//        return fields;
//    }
    //晚上改的
}
