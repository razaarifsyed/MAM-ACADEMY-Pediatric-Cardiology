package com.example.arifraza.pediatriccardiology;


public class comnt {



    String did;
    String dname;
    String deml;
    String dhid;
String lid;
String ml;

    public comnt(){

    }

    public comnt(String did, String dname,String dhid, String deml,String lid,String ml) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.deml=deml;
        this.lid=lid;
        this.ml=ml;


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
    public String getlid() {
        return lid;
    }
    public String getml() {
        return ml;
    }


}
