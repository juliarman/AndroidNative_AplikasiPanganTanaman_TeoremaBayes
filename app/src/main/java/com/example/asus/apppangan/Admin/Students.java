package com.example.asus.apppangan.Admin;

public class Students {
    private String id;
    private String judul;
    private String deskripsi;

    public Students(String id, String judul, String deskripsi) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }



    public Students(String judul,String deskripsi){
           this.judul=judul;
           this.deskripsi=deskripsi;

    }
    public Students(){
    }
    public String toString(){
        return this.id + " - " + judul  ;
    }
}
