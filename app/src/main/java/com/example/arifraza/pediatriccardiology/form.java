package com.example.arifraza.pediatriccardiology;


public class form {



    String did;
    String dname;
    String deml;
    String dhid;
    String ml;


    public form(){

    }

    public form(String did, String dname,String dhid, String deml,String ml) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.deml=deml;
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
    public String getml() {
        return ml;
    }


}
