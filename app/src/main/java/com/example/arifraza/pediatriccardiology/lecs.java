package com.example.arifraza.pediatriccardiology;



public class lecs {



    String did;
    String dname;
    String deml;
    String dhid;
    String dds;
    String dpn;
    String ldsc;
    String ltm;



    public lecs(){

    }

    public lecs(String did, String dname,String dhid,  String dds, String dpn,String deml,String ldsc,String ltm) {
        this.did=did;
        this.dname=dname;
        this.dhid=dhid;
        this.dds=dds;
        this.dpn=dpn;
        this.deml=deml;
        this.ldsc=ldsc;
        this.ltm=ltm;
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
    public String getldsc() {
        return ldsc;
    }
    public String getltm() {
        return ltm;
    }

}
