package com.mayikt.service.entity;

public class UserEntity {
    private int id;
    private String fathername;
    private String childvalue;

    public UserEntity(String username,String value){
         this.fathername=username;
         this.childvalue=value;
    }
    public UserEntity(int id,String username,String value){
        this.fathername=username;
        this.childvalue=value;
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getfathername() {
        return fathername;
    }

    public String getchildvalue() {
        return childvalue;
    }

    public void setchildvalue(String age) {
        this.childvalue = age;
    }

    public void setfathername(String fathername) {
        this.fathername = fathername;
    }
}
