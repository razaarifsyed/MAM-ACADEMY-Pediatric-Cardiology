package com.example.arifraza.pediatriccardiology;


public class notc {



    String did;
    String dname;
    String deml;
    String dhid;


    public notc(){

    }

    public notc(String did, String dname,String dhid, String deml) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.deml=deml;



    }


    public String getdid() {
        return did;
    }

    public String getdname() {
        return dname;
    }
    public String getdhid() {
        return dhid;
    }


    public String getdeml() {
        return deml;
    }



}
