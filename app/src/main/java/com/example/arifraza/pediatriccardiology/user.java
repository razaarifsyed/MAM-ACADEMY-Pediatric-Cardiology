package com.example.arifraza.pediatriccardiology;


public class user {



    String did;
    String dname;
    String deml;
    String dhid;
    String dds;
    String dpn;
String udt;



    public user(){

    }

    public user(String did, String dname,String dhid,  String dds, String dpn,String deml,String udt) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.dds=dds;
        this.dpn=dpn;
        this.deml=deml;
        this.udt=udt;

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

    public String getdds(){
        return dds;
    }
    public String getdpn() {
        return dpn;
    }
    public String getdeml() {
        return deml;
    }
    public String getudt() {
        return udt;
    }


}
