package com.example.project1.Model;

public class Hasil {
    String lap1,lap2,lap3,lap4,lap5,lap6,lap7,lap8,ID, tanggal_buat;

    public Hasil(){

    }

    public Hasil(String lap1, String lap2, String lap3, String lap4, String lap5, String lap6, String lap7, String lap8, String ID, String tanggal_buat) {
        this.lap1 = lap1;
        this.lap2 = lap2;
        this.lap3 = lap3;
        this.lap4 = lap4;
        this.lap5 = lap5;
        this.lap6 = lap6;
        this.lap7 = lap7;
        this.lap8 = lap8;
        this.ID = ID;
        this.tanggal_buat = tanggal_buat;
    }

    public String getLap1() {
        return lap1;
    }

    public void setLap1(String lap1) {
        this.lap1 = lap1;
    }

    public String getLap2() {
        return lap2;
    }

    public void setLap2(String lap2) {
        this.lap2 = lap2;
    }

    public String getLap3() {
        return lap3;
    }

    public void setLap3(String lap3) {
        this.lap3 = lap3;
    }

    public String getLap4() {
        return lap4;
    }

    public void setLap4(String lap4) {
        this.lap4 = lap4;
    }

    public String getLap5() {
        return lap5;
    }

    public void setLap5(String lap5) {
        this.lap5 = lap5;
    }

    public String getLap6() {
        return lap6;
    }

    public void setLap6(String lap6) {
        this.lap6 = lap6;
    }

    public String getLap7() {
        return lap7;
    }

    public void setLap7(String lap7) {
        this.lap7 = lap7;
    }

    public String getLap8() {
        return lap8;
    }

    public void setLap8(String lap8) {
        this.lap8 = lap8;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTanggal_buat() {
        return tanggal_buat;
    }

    public void setTanggal_buat(String tanggal_buat) {
        this.tanggal_buat = tanggal_buat;
    }
}
